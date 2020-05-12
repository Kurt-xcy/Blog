package com.xcy.blog.controller.admin;


import com.github.pagehelper.PageInfo;

import com.xcy.blog.entity.ArticleStatus;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Comment;
import com.xcy.blog.service.ArticleService;
import com.xcy.blog.service.CommentService;
import com.xcy.blog.util.MyUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/admin/comment")
public class BackCommentController {

    @Autowired
    private CommentService commentServiceImpl;

    @Autowired
    private ArticleService articleServiceImpl;

    /**
     * 评论页面
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return modelAndView
     */
    @RequestMapping(value = "")
    public String commentListView(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                  Model model) {
        PageInfo<Comment> commentPageInfo = commentServiceImpl.listCommentByPage(pageIndex, pageSize);
        model.addAttribute("pageInfo", commentPageInfo);
        model.addAttribute("pageUrlPrefix","/admin/comment?pageIndex");
        return "Admin/Comment/index";
    }


    /**
     * 添加评论
     *
     * @param request
     * @param comment
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    @ResponseBody
    @RequiresRoles("admin")
    public void insertComment(HttpServletRequest request, Comment comment) {
        //添加评论
        comment.setCommentIp(MyUtils.getIpAddr(request));
        comment.setCommentCreateTime(new Date());
        commentServiceImpl.insertComment(comment);
        //更新文章的评论数
        Article article = articleServiceImpl.getArticleByStatusAndId(null, comment.getCommentArticleId());
        articleServiceImpl.updateCommentCount(article.getArticleId());
    }

    /**
     * 删除评论
     *
     * @param id 批量ID
     */
    @RequestMapping(value = "/delete/{id}")
    @RequiresRoles("admin")
    public void deleteComment(@PathVariable("id") Integer id) {
        Comment comment = commentServiceImpl.getCommentById(id);
        //删除评论
        commentServiceImpl.deleteComment(id);
        //删除其子评论
        List<Comment> childCommentList = commentServiceImpl.listChildComment(id);
        for (int i = 0; i < childCommentList.size(); i++) {
            commentServiceImpl.deleteComment(childCommentList.get(i).getCommentId());
        }
        //更新文章的评论数
        Article article = articleServiceImpl.getArticleByStatusAndId(null, comment.getCommentArticleId());
        articleServiceImpl.updateCommentCount(article.getArticleId());
    }

    /**
     * 编辑评论页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public String editCommentView(@PathVariable("id") Integer id, Model model) {
        Comment comment = commentServiceImpl.getCommentById(id);
        model.addAttribute("comment", comment);
        return "Admin/Comment/edit";
    }


    /**
     * 编辑评论提交
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String editCommentSubmit(Comment comment) {
        commentServiceImpl.updateComment(comment);
        return "redirect:/admin/comment";
    }


    /**
     * 回复评论页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/reply/{id}")
    public String replyCommentView(@PathVariable("id") Integer id, Model model) {
        Comment comment = commentServiceImpl.getCommentById(id);
        model.addAttribute("comment", comment);
        return "Admin/Comment/reply";
    }

    /**
     * 回复评论提交
     *
     * @param request
     * @param comment
     * @return
     */
    @RequestMapping(value = "/replySubmit", method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String replyCommentSubmit(HttpServletRequest request, Comment comment) {
        //文章评论数+1
        Article article = articleServiceImpl.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
        article.setArticleCommentCount(article.getArticleCommentCount() + 1);
        articleServiceImpl.updateArticle(article);
        //添加评论
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(MyUtils.getIpAddr(request));
        commentServiceImpl.insertComment(comment);
        return "redirect:/admin/comment";
    }

}
