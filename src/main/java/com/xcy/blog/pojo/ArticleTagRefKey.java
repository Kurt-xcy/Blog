package com.xcy.blog.pojo;

import java.io.Serializable;

public class ArticleTagRefKey implements Serializable {
    private Integer articleId;

    private Integer tagId;

    private static final long serialVersionUID = 1L;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}