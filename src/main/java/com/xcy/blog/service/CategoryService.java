package com.xcy.blog.service;

import com.xcy.blog.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有目录
     * @return
     */
    public List<Category> listCategory();

    /**
     * 查询所有目录并带回文章数
     * @return
     */
    public List<Category> listCategoryWithCount();
}
