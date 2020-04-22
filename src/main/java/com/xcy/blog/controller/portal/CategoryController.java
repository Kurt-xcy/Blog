package com.xcy.blog.controller.portal;


import com.github.pagehelper.PageInfo;

import com.xcy.blog.entity.ArticleStatus;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Category;
import com.xcy.blog.pojo.Tag;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.CategoryService;
import com.xcy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;



@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryServiceImpl;

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private TagService tagServiceImpl;

    /**
     * 根据分类查询文章
     *
     * @param cateId 分类ID
     * @return 模板
     */
    @RequestMapping("/category/{cateId}")
    public String getArticleListByCategory(@PathVariable("cateId") Integer cateId,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                           Model model) {

        //该分类信息
        Category category = categoryServiceImpl.getCategoryById(cateId);
        if (category == null) {
            return "redirect:/404";
        }
        model.addAttribute("category", category);

        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("categoryId", cateId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleServiceImpl.pageArticleBycategoryId(pageIndex, pageSize, ArticleStatus.PUBLISH.getValue(),cateId);
        model.addAttribute("pageInfo", articlePageInfo);

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
        model.addAttribute("pageUrlPrefix", "/category/"+pageIndex+"?pageIndex");
        return "Home/Page/articleListByCategory";
    }


}
