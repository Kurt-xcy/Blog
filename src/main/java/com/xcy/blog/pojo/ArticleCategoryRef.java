package com.xcy.blog.pojo;

import java.io.Serializable;

public class ArticleCategoryRef implements Serializable {
    private Integer articleId;

    private Integer categoryId;

    private static final long serialVersionUID = 1L;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}