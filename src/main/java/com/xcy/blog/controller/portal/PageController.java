package com.xcy.blog.controller.portal;





import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Category;
import com.xcy.blog.pojo.Page;
import com.xcy.blog.pojo.Tag;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.CategoryService;
import com.xcy.blog.service.PageService;
import com.xcy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class PageController {

    @Autowired
    private PageService pageServiceImpl;

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private CategoryService categoryServiceImpl;


    @Autowired
    private TagService tagServiceImpl;

    /**
     * 页面详情页面
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/{key}")
    public String pageDetail(@PathVariable("key") String key, Model model) {
        Page page = pageServiceImpl.getPageByKeyAndStatus(1, key);
        if (page == null) {
            return "redirect:/404";
        }
        model.addAttribute("page", page);

        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/page";

    }


    /**
     * 文章归档页面显示
     *
     * @return
     */
    @RequestMapping(value = "/articleFile")
    public String articleFile(Model model) {
        List<Article> articleList = articleServiceImpl.listAllNotWithContent();
        model.addAttribute("articleList", articleList);
        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(10);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/articleFile";
    }

    /**
     * 站点地图显示
     *
     * @return
     */
    @RequestMapping(value = "/map")
    public String siteMap(Model model) {
        //文章显示
        List<Article> articleList = articleServiceImpl.listAllNotWithContent();
        model.addAttribute("articleList", articleList);
        //分类显示
        List<Category> categoryList = categoryServiceImpl.listCategory();
        model.addAttribute("categoryList", categoryList);
        //标签显示
        List<Tag> tagList = tagServiceImpl.listTag();
        model.addAttribute("tagList", tagList);

        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(10);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/siteMap";
    }

    /**
     * 留言板
     *
     * @return
     */
    @RequestMapping(value = "/message")
    public String message(Model model) {

        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/message";
    }
}
