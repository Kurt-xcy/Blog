package com.xcy.blog.service;

public interface ArticleTagRefService {
    /**
     * 根据标签ID查询文章数
     * @return
     */
    public Integer countArticleByTagId(Integer id);
}
