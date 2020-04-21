package com.xcy.blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class ArticleWithBLOBs extends Article implements Serializable {
    private String articleContent;

    private String articleSummary;

    @Override
    public Integer getArticleId() {
        return articleId;
    }

    @Override
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Override
    public Integer getArticleUserId() {
        return articleUserId;
    }

    @Override
    public void setArticleUserId(Integer articleUserId) {
        this.articleUserId = articleUserId;
    }

    @Override
    public String getArticleTitle() {
        return articleTitle;
    }

    @Override
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Override
    public Integer getArticleViewCount() {
        return articleViewCount;
    }

    @Override
    public void setArticleViewCount(Integer articleViewCount) {
        this.articleViewCount = articleViewCount;
    }

    @Override
    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    @Override
    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    @Override
    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    @Override
    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    @Override
    public Integer getArticleIsComment() {
        return articleIsComment;
    }

    @Override
    public void setArticleIsComment(Integer articleIsComment) {
        this.articleIsComment = articleIsComment;
    }

    @Override
    public Integer getArticleStatus() {
        return articleStatus;
    }

    @Override
    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    @Override
    public Integer getArticleOrder() {
        return articleOrder;
    }

    @Override
    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    @Override
    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    @Override
    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    @Override
    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    @Override
    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    private Integer articleId;

    private Integer articleUserId;

    private String articleTitle;

    private Integer articleViewCount;

    private Integer articleCommentCount;

    private Integer articleLikeCount;

    private Integer articleIsComment;

    private Integer articleStatus;

    private Integer articleOrder;

    private Date articleUpdateTime;

    private Date articleCreateTime;

    private static final long serialVersionUID = 1L;

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }
}