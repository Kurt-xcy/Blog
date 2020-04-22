package com.xcy.blog.service;

import com.github.pagehelper.PageInfo;
import com.xcy.blog.VO.UserVO;
import com.xcy.blog.pojo.Article;

import java.util.Date;
import java.util.List;


public interface ArticleService {
    /**
     * 查询最新的几个文章
     * @param limit
     * @return
     */
    public List<Article> listRecentArticle(Integer limit);

    /**
     * 查询某状态的文章
     * @param pageIndex
     * @param pageSize
     * @param status
     * @return
     */
    public PageInfo<Article> pageArticle(Integer pageIndex,Integer pageSize,Integer status);

    /**
     * 新增文章
     * @param article
     * @return
     */
    public Integer insertArticle(Article article);

    /**
     * 根据创建时间查找文章
     * @param date
     * @return
     */
    public Article selectByCreateTime(Date date);

    /**
     * 根据状态和id查询文章
     * @param id
     * @return
     */
    public Article getArticleByStatusAndId(Integer status,Integer id);

    /**
     * 更新文章评论+1
     * @param id
     * @return
     */
    public Integer updateCommentCount(Integer id);

    /**
     * 更新文章
     * @param article
     * @return
     */
    public Integer updateArticle(Article article);
}
