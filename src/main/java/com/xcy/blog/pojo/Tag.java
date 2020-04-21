package com.xcy.blog.pojo;

import java.io.Serializable;

public class Tag implements Serializable {
    private Integer tagId;

    private String tagName;

    private String tagDescription;

    private static final long serialVersionUID = 1L;


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