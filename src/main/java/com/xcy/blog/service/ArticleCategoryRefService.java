package com.xcy.blog.service;

public interface ArticleCategoryRefService {
    /**
     * 根据目录id查询文章数
     * @param categoryId
     * @return
     */
    public Integer countArticleByCategoryId(Integer categoryId);

    /**
     * 根据目录id删除
     * @param categoryId
     * @return
     */
    public Integer deleteByCategoryId(Integer categoryId);
}
