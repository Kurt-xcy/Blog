package com.xcy.blog.controller.portal;


import com.alibaba.fastjson.JSON;

import com.xcy.blog.entity.ArticleStatus;
import com.xcy.blog.pojo.*;
import com.xcy.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private CommentService commentServiceImpl;

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private TagService tagServiceImpl;

    @Autowired
    private CategoryService categoryServiceImpl;

    /**
     * 文章详情页显示
     *
     * @param articleId 文章ID
     * @return modelAndView
     */
    @RequestMapping(value = "/article/{articleId}")
    public String getArticleDetailPage(@PathVariable("articleId") Integer articleId, Model model) {

        //文章信息，分类，标签，作者，评论
        ArticleWithBLOBs article = articleServiceImpl.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), articleId);
        if (article == null) {
            return "Home/Error/404";
        }

        //用户信息
        User user = userServiceImpl.getUserById(article.getArticleUserId());
        article.setUser(user);

        //文章信息
        model.addAttribute("article", article);

        //评论列表
        List<Comment> commentList = commentServiceImpl.listCommentByArticleId(articleId);
        model.addAttribute("commentList", commentList);

        //相关文章
        List<Integer> categoryIds = articleServiceImpl.listCategoryIdByArticleId(articleId);
        List<Article> similarArticleList = articleServiceImpl.listArticleByCategoryIds(categoryIds, 5);
        //如果该目录下没有文章，返回同作者的其他文章
        if (similarArticleList==null||similarArticleList.size()==0){
            similarArticleList = articleServiceImpl.listArticleByUser(article.getUser(),5);
        }
        model.addAttribute("similarArticleList", similarArticleList);

        //猜你喜欢
        List<Article> mostViewArticleList = articleServiceImpl.listArticleByViewCount(5);
        model.addAttribute("mostViewArticleList", mostViewArticleList);

        //获取下一篇文章
        Article afterArticle = articleServiceImpl.getAfterArticle(articleId);
        model.addAttribute("afterArticle", afterArticle);

        //获取上一篇文章
        Article preArticle = articleServiceImpl.getPreArticle(articleId);
        model.addAttribute("preArticle", preArticle);

        //侧边栏
        //标签列表显示
        List<Tag> allTagList = tagServiceImpl.listTag();
        model.addAttribute("allTagList", allTagList);
        //获得随机文章
        List<Article> randomArticleList = articleServiceImpl.listRandomArticle(8);
        model.addAttribute("randomArticleList", randomArticleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);

        return "Home/Page/articleDetail";
    }

    /**
     * 点赞增加
     *
     * @param id 文章ID
     * @return 点赞量数量
     */
    @RequestMapping(value = "/article/like/{id}", method = {RequestMethod.POST})
    @ResponseBody
    public String increaseLikeCount(@PathVariable("id") Integer id) {
        Article article = articleServiceImpl.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleLikeCount() + 1;
        article.setArticleLikeCount(articleCount);
        articleServiceImpl.updateArticle(article);
        return JSON.toJSONString(articleCount);
    }

    /**
     * 文章访问量数增加
     *
     * @param id 文章ID
     * @return 访问量数量
     */
    @RequestMapping(value = "/article/view/{id}", method = {RequestMethod.POST})
    @ResponseBody
    public String increaseViewCount(@PathVariable("id") Integer id) {
        Article article = articleServiceImpl.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleViewCount() + 1;
        article.setArticleViewCount(articleCount);
        articleServiceImpl.updateArticle(article);
        return JSON.toJSONString(articleCount);
    }


}
