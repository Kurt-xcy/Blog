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

    /**
     * 插入目录
     * @param category
     * @return
     */
    public Integer insertCategory(Category category);

    /**
     *
     * 通过id删除目录
     * @param categoryId
     * @return
     */
    public Integer deleteCategory(Integer categoryId);

    /**
     * 根据id查询目录
     * @param categoryId
     * @return
     */
    public Category getCategoryById(Integer categoryId);

    /**
     * 更新目录
     * @return
     */
    public Integer updateCategory(Category category);
}
