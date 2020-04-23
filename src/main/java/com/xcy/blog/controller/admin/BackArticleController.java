package com.xcy.blog.controller.admin;

import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.xcy.blog.VO.ArticleParam;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Category;
import com.xcy.blog.pojo.Tag;
import com.xcy.blog.pojo.User;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.CategoryService;
import com.xcy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/article")
public class BackArticleController {
    @Autowired
    private ArticleService articleServiceImpl;
    @Autowired
    private CategoryService categoryServiceImpl;
    @Autowired
    private TagService tagServiceImpl;
    @RequestMapping("")
    public String showPage(@RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) Integer status,
                                 Model model){
        if (status == null) {
            model.addAttribute("pageUrlPrefix", "/admin/article?pageIndex");

        } else {
            model.addAttribute("pageUrlPrefix", "/admin/article?status=" + status + "&pageIndex");
        }
        PageInfo<Article> articlePageInfo = articleServiceImpl.pageArticle(pageIndex, pageSize, status);
        model.addAttribute("pageInfo", articlePageInfo);
        return "Admin/Article/index";
    }

    /**
     * 后台添加文章页面显示
     *
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insertArticleView(Model model) {
        List<Category> categoryList = categoryServiceImpl.listCategory();
        List<Tag> tagList = tagServiceImpl.listTag();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("tagList", tagList);
        return "Admin/Article/insert";
    }

    /**
     * 后台添加文章提交操作
     *
     * @param articleParam
     * @return
     */
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertArticleSubmit(HttpSession session, ArticleParam articleParam) {
        Article article = new Article();
        //用户ID
        User user = (User) session.getAttribute("user");
        if (user != null) {
            article.setArticleUserId(user.getUserId());
        }
        article.setArticleTitle(articleParam.getArticleTitle());
        //文章摘要
        int summaryLength = 150;
        String summaryText = HtmlUtil.cleanHtmlTag(articleParam.getArticleContent());
        if (summaryText.length() > summaryLength) {
            String summary = summaryText.substring(0, summaryLength);
            article.setArticleSummary(summary);
        } else {
            article.setArticleSummary(summaryText);
        }
        article.setArticleContent(articleParam.getArticleContent());
        article.setArticleStatus(articleParam.getArticleStatus());
        Date date = new Date();
        article.setArticleCreateTime(date);
        article.setArticleUpdateTime(date);
        article.setArticleOrder(1);
        article.setArticleIsComment(1);
        //填充分类
        List<Category> categoryList = new ArrayList<>();
        if (articleParam.getArticleChildCategoryId() != null) {
            Category category = new Category();
            category.setCategoryId(articleParam.getArticleParentCategoryId());
            categoryList.add(category);
        }
        if (articleParam.getArticleChildCategoryId() != null) {
            Category category = new Category();
            category.setCategoryId(articleParam.getArticleChildCategoryId());
            categoryList.add(category);
        }
        article.setCategoryList(categoryList);
        //填充标签
        List<Tag> tagList = new ArrayList<>();
        if (articleParam.getArticleTagIds() != null) {
            for (int i = 0; i < articleParam.getArticleTagIds().size(); i++) {
                Tag tag = new Tag();
                tag.setTagId(articleParam.getArticleTagIds().get(i));
                tagList.add(tag);
            }
        }
        article.setTagList(tagList);

        articleServiceImpl.insertArticle(article);

        return "redirect:/admin/article";
    }
}
