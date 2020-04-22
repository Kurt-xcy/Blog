package com.xcy.blog.controller.portal;


import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Notice;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeServiceImpl;

    @Autowired
    private ArticleService articleServiceImpl;

    /**
     * 公告详情页显示
     *
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/notice/{noticeId}")
    public String NoticeDetailView(@PathVariable("noticeId") Integer noticeId,
                                   Model model) {
        //公告内容和信息显示
        Notice notice  = noticeServiceImpl.getNoticeById(noticeId);
        model.addAttribute("notice",notice);

        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleServiceImpl.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/noticeDetail";
    }
}
