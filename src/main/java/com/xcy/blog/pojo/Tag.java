package com.xcy.blog.pojo;

import java.io.Serializable;

public class Tag implements Serializable {
    private Integer tagId;

    private String tagName;

    private String tagDescription;

    private static final long serialVersionUID = 1L;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    /**
     * 文章数量(不是数据库字段)
     */
    private Integer articleCount;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription == null ? null : tagDescription.trim();
    }
}