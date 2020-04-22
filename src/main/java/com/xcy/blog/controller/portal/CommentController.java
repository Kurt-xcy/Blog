package com.xcy.blog.controller.portal;

import cn.hutool.http.HtmlUtil;

import com.xcy.blog.VO.JsonResult;
import com.xcy.blog.entity.ArticleStatus;
import com.xcy.blog.entity.Role;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Comment;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.CommentService;
import com.xcy.blog.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;



@Controller
@RestController
public class CommentController {
    @Autowired
    private CommentService commentServiceImpl;

    @Autowired
    private ArticleService articleServiceImpl;

    /**
     * '添加评论
     *
     * @param request
     * @param comment
     */
    @RequestMapping(value = "/comment", method = {RequestMethod.POST})
    public JsonResult insertComment(HttpServletRequest request, Comment comment) {
        //添加评论
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(MyUtils.getIpAddr(request));
        if (request.getSession().getAttribute("user") != null) {
            comment.setCommentRole(Role.ADMIN.getValue());
        } else {
            comment.setCommentRole(Role.VISITOR.getValue());
        }
        comment.setCommentAuthorAvatar(MyUtils.getGravatar(comment.getCommentAuthorEmail()));

        //过滤字符，防止XSS攻击
        comment.setCommentContent(HtmlUtil.escape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtil.escape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtil.escape(comment.getCommentAuthorEmail()));
        comment.setCommentAuthorUrl(HtmlUtil.escape(comment.getCommentAuthorUrl()));
        try {
            commentServiceImpl.insertComment(comment);
            //更新文章的评论数
            Article article = articleServiceImpl.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
            articleServiceImpl.updateCommentCount(article.getArticleId());
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult().fail();
        }
        return new JsonResult().ok();
    }


}
