package com.xcy.blog.service;

import com.github.pagehelper.PageInfo;
import com.xcy.blog.VO.UserVO;
import com.xcy.blog.pojo.Article;
import com.xcy.blog.pojo.ArticleWithBLOBs;
import com.xcy.blog.pojo.Category;
import com.xcy.blog.pojo.User;

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
     * 查询某状态的文章,限定指定用户的文章
     * @param pageIndex
     * @param pageSize
     * @param status
     * @param userId
     * @return
     */
    public PageInfo<Article> pageArticleByUserId(Integer pageIndex,Integer pageSize,Integer status,int userId);

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
     * 根据状态和id查询文章(大文本)
     * @param id
     * @return
     */
    public ArticleWithBLOBs getArticleByStatusAndId(Integer status, Integer id);

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

    /**
     * 获取乱序的limit数量文章
     * @param limit
     * @return
     */
    public List<Article> listRandomArticle(Integer limit);

    /**
     *
     * 获取评论数最高的limit数量文章
     * @param limit
     * @return
     */
    public List<Article> listArticleByCommentCount(Integer limit);

    /**
     * 查询文章根据状态以及关键词
     * @param pageIndex
     * @param pageSize
     * @param status
     * @param keywords
     * @return
     */
    public PageInfo<Article> pageArticleSearch(Integer pageIndex,Integer pageSize,Integer status,String keywords);

    /**
     * 查询文章根据状态以及目录ID
     * @param pageIndex
     * @param pageSize
     * @param status
     * @param categoryId
     * @return
     */
    public PageInfo<Article> pageArticleBycategoryId(Integer pageIndex,Integer pageSize,Integer status,Integer categoryId);

    /**
     * 根据文章id查询目录id
     * @param articleId
     * @return
     */
    public List<Integer> listCategoryIdByArticleId(Integer articleId);

    /**
     * 根据目录id查询文章
     * @param categoryIds
     * @param limit
     * @return
     */
    public List<Article> listArticleByCategoryIds(List<Integer> categoryIds,Integer limit);

    /**
     * 查询文章数量
     * @param status
     * @return
     */
    public Integer countArticle(Integer status);

    /**
     * 查询文章所有评论
     * @return
     */
    public Integer countArticleComment();

    /**
     * 查询文章访问总数
     * @return
     */
    public Integer countArticleView();

    /**
     * 查询最后更新的文章
     * @return
     */
    public Article getLastUpdateArticle();

    /**
     * 按照阅读数查询文章
     * @param limit
     * @return
     */
    public List<Article> listArticleByViewCount(Integer limit);

    /**
     * 查询下一篇文章
     * @param articleId
     * @return
     */
    public Article getAfterArticle(Integer articleId);

    /**
     * 查询上一篇文章
     * @param articleId
     * @return
     */
    public Article getPreArticle(Integer articleId);

    /**
     * 查询全部文章
     * @return
     */
    public List<Article> listAllNotWithContent();

    /**
     * 根据标签id和状态查询文章
     * @return
     */
    public PageInfo<Article> pageArticleBytagId(Integer pageIndex,Integer pageSize,Integer status,Integer tagId);

    /**
     * 获取当前文章总数
     * @return
     */
    public Integer countArticle();

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    public Integer deleteArticle(Integer id);

    /**
     * 更新文章，以及目录和标签
     * @param article
     * @return
     */
    public Integer updateArticleDetail(Article article);

    public List<Article> listArticleByUser(User user, Integer limit);
}
