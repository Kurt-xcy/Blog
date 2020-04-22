package com.xcy.blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 角色(管理员1，访客0)
     */
    private Integer commentRole;

    /**
     * 非数据库字段
     */
    private Article article;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public String getCommentPname() {
        return commentPname;
    }

    public void setCommentPname(String commentPname) {
        this.commentPname = commentPname == null ? null : commentPname.trim();
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public String getCommentAuthorName() {
        return commentAuthorName;
    }

    public void setCommentAuthorName(String commentAuthorName) {
        this.commentAuthorName = commentAuthorName == null ? null : commentAuthorName.trim();
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail == null ? null : commentAuthorEmail.trim();
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl == null ? null : commentAuthorUrl.trim();
    }

    public String getCommentAuthorAvatar() {
        return commentAuthorAvatar;
    }

    public void setCommentAuthorAvatar(String commentAuthorAvatar) {
        this.commentAuthorAvatar = commentAuthorAvatar == null ? null : commentAuthorAvatar.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent == null ? null : commentAgent.trim();
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp == null ? null : commentIp.trim();
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public Integer getCommentRole() {
        return commentRole;
    }

    public void setCommentRole(Integer commentRole) {
        this.commentRole = commentRole;
    }
}