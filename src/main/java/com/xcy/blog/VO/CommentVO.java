package com.xcy.blog.VO;

import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.Comment;

import java.util.Date;

public class CommentVO extends Comment {
    private Integer commentId;

    private Integer commentPid;

    private String commentPname;

    private Integer commentArticleId;

    private String commentAuthorName;

    private String commentAuthorEmail;

    private String commentAuthorUrl;

    private String commentAuthorAvatar;

    private String commentContent;

    private String commentAgent;

    private String commentIp;

    private Date commentCreateTime;

    private Integer commentRole;
    /**
     * 非数据库字段
     */
    private Article article;

    @Override
    public Integer getCommentPid() {
        return commentPid;
    }

    @Override
    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    @Override
    public String getCommentPname() {
        return commentPname;
    }

    @Override
    public void setCommentPname(String commentPname) {
        this.commentPname = commentPname;
    }

    @Override
    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    @Override
    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    @Override
    public String getCommentAuthorName() {
        return commentAuthorName;
    }

    @Override
    public void setCommentAuthorName(String commentAuthorName) {
        this.commentAuthorName = commentAuthorName;
    }

    @Override
    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    @Override
    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    @Override
    public String getCommentAuthorAvatar() {
        return commentAuthorAvatar;
    }

    @Override
    public void setCommentAuthorAvatar(String commentAuthorAvatar) {
        this.commentAuthorAvatar = commentAuthorAvatar;
    }

    @Override
    public String getCommentContent() {
        return commentContent;
    }

    @Override
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String getCommentAgent() {
        return commentAgent;
    }

    @Override
    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    @Override
    public String getCommentIp() {
        return commentIp;
    }

    @Override
    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    @Override
    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    @Override
    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    @Override
    public Integer getCommentRole() {
        return commentRole;
    }

    @Override
    public void setCommentRole(Integer commentRole) {
        this.commentRole = commentRole;
    }

    @Override
    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    @Override
    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    @Override
    public Integer getCommentId() {
        return commentId;
    }

    @Override
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public CommentVO(Comment c) {
        super();
        this.commentId = c.getCommentId();
        this.commentPid = c.getCommentPid();
        this.commentPname = c.getCommentPname();
        this.commentArticleId = c.getCommentArticleId();
        this.commentAuthorName = c.getCommentAuthorName();
        this.commentAuthorEmail = c.getCommentAuthorEmail();
        this.commentAuthorUrl = c.getCommentAuthorUrl();
        this.commentAuthorAvatar = c.getCommentAuthorAvatar();
        this.commentContent = c.getCommentContent();
        this.commentAgent = c.getCommentAgent();
        this.commentIp = c.getCommentIp();
        this.commentCreateTime = c.getCommentCreateTime();
        this.commentRole = c.getCommentRole();
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}

