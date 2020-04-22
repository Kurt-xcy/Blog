package com.xcy.blog.controller.portal;

import com.github.pagehelper.PageInfo;

import com.xcy.blog.VO.CommentVO;
import com.xcy.blog.entity.ArticleStatus;
import com.xcy.blog.entity.LinkStatus;
import com.xcy.blog.entity.NoticeStatus;
import com.xcy.blog.pojo.*;
import com.xcy.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private LinkService linkServiceImpl;

    @Autowired
    private NoticeService noticeServiceImpl;

    @Autowired
    private TagService tagServiceImpl;

    @Autowired
    private CommentService commentServiceImpl;

    @RequestMapping(value = {"/", "/article"})
    public String index(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
        //文章列表
        PageInfo<Article> articleList = articleServiceImpl.pageArticle(pageIndex, pageSize, ArticleStatus.PUBLISH.getValue());
        model.addAttribute("pageInfo", articleList);

        //公告
        List<Notice> noticeList = noticeServiceImpl.listNoticeByStatus(NoticeStatus.NORMAL.getValue());
        model.addAttribute("noticeList", noticeList);
        //友情链接
        List<Link> linkList = linkServiceImpl.listLinkByStatus(LinkStatus.NORMAL.getValue());
        model.addAttribute("linkList", linkList);

        //侧边栏显示
        //标签列表显示
        List<Tag> allTagList = tagServiceImpl.listTag();
        model.addAttribute("allTagList", allTagList);
        //最新评论
        List<CommentVO> recentCommentList = commentServiceImpl.listRecentComment(10);
        model.addAttribute("recentCommentList", recentCommentList);
        model.addAttribute("pageUrlPrefix", "/article?pageIndex");
        return "Home/index";
    }

    @RequestMapping(value = "/search")
    public String search(
            @RequestParam(required = false,value="keywords") String keywords,
            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
        //文章列表
        PageInfo<Article> articlePageInfo = articleServiceImpl.pageArticleSearch(pageIndex, pageSize, ArticleStatus.PUBLISH.getValue(),keywords);
        model.addAttribute("pageInfo", articlePageInfo);

        //侧边栏显示
        //标签列表显示
        List<Tag> allTagList = tagServiceImpl.listTag();
        model.addAttribute("allTagList", allTagList);
        //获得随机文章
        List<Article> randomArticleList = articleServiceImpl.listRandomArticle(8);
        model.addAttribute("randomArticleList", randomArticleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        //最新评论
        List<CommentVO> recentCommentList = commentServiceImpl.listRecentComment(10);
        model.addAttribute("recentCommentList", recentCommentList);
        model.addAttribute("pageUrlPrefix", "/search?pageIndex");
        return "Home/Page/search";
    }

    @RequestMapping("/404")
    public String NotFound(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "Home/Error/404";
    }

    @RequestMapping("/500")
    public String ServerError(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "Home/Error/500";
    }


}




