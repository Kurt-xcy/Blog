package com.xcy.blog.service;

import com.xcy.blog.pojo.Tag;

import java.util.List;

public interface TagService {
    /**
     * 查询所有标签
     * @return
     */
    public List<Tag> listTag();
}
