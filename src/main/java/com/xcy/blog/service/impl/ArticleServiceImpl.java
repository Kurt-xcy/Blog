package com.xcy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcy.blog.mapper.ArticleCategoryRefMapper;
import com.xcy.blog.mapper.ArticleMapper;
import com.xcy.blog.mapper.ArticleTagRefMapper;
import com.xcy.blog.mapper.CategoryMapper;
import com.xcy.blog.pojo.*;

import com.xcy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleCategoryRefMapper articleCategoryRefMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;
    @Override
    public List<Article> listRecentArticle(Integer limit) {

        ArticleExample example = new ArticleExample();
        example.setOrderByClause("article_update_time desc");
        PageHelper.startPage(1,5);
        return articleMapper.selectByExample(example);

    }

    @Override
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, Integer status) {
        ArticleExample example = new ArticleExample();
        PageHelper.startPage(pageIndex,pageSize);
        if (status!=null){
            example.createCriteria().andArticleStatusEqualTo(status);
        }
        List<Article> articleList = articleMapper.selectByExample(example);
        for (Article article:articleList){
            ArticleCategoryRefExample articleCategoryRefExample = new ArticleCategoryRefExample();
            articleCategoryRefExample.createCriteria().andArticleIdEqualTo(article.getArticleId());
            List<ArticleCategoryRef> articleCategoryRef = articleCategoryRefMapper.selectByExample(articleCategoryRefExample);
            List<Category> categoryList = new ArrayList<>();
            for(ArticleCategoryRef ref : articleCategoryRef){
                categoryList.add(categoryMapper.selectByPrimaryKey(ref.getCategoryId()));
            }
            article.setCategoryList(categoryList);
        }
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }

    @Override
    public Integer insertArticle(Article article) {
        ArticleWithBLOBs articleWithBLOBs = new ArticleWithBLOBs();
        articleWithBLOBs.setArticleUserId(article.getArticleUserId());
        articleWithBLOBs.setArticleTitle(article.getArticleTitle());
        articleWithBLOBs.setArticleContent(article.getArticleContent());
        articleWithBLOBs.setArticleSummary(article.getArticleSummary());
        articleWithBLOBs.setArticleCreateTime(article.getArticleCreateTime());
        articleWithBLOBs.setArticleUpdateTime(article.getArticleUpdateTime());
        articleWithBLOBs.setArticleOrder(article.getArticleOrder());
        articleWithBLOBs.setArticleStatus(article.getArticleStatus());
        Integer index = articleMapper.insert(articleWithBLOBs);

        List<Category> categoryList = article.getCategoryList();
        List<Tag> tagList = article.getTagList();
        article = selectByCreateTime(article.getArticleCreateTime());
        for (Category category:categoryList){
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef();
            articleCategoryRef.setArticleId(article.getArticleId());
            articleCategoryRef.setCategoryId(category.getCategoryId());
            articleCategoryRefMapper.insertSelective(articleCategoryRef);
        }

        for(Tag tag:tagList){
            ArticleTagRefKey articleTagRefKey = new ArticleTagRefKey();
            articleTagRefKey.setArticleId(article.getArticleId());
            System.out.println(article.getArticleId());
            articleTagRefKey.setTagId(tag.getTagId());
            articleTagRefMapper.insertSelective(articleTagRefKey);
        }

        return index;
    }

    @Override
    public Article selectByCreateTime(Date date) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleCreateTimeEqualTo(date);
        List<Article> articleList = articleMapper.selectByExample(example);
        if(articleList.size()>0){
            return articleList.get(0);
        }
        return null;
    }

    @Override
    public Article getArticleByStatusAndId(Integer status, Integer id) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleIdEqualTo(id);
        if (status!=null){
            example.createCriteria().andArticleStatusEqualTo(status);
        }
        List<Article> articleList = articleMapper.selectByExample(example);
        if (articleList.size()>0){
            return articleList.get(0);
        }
        return null;
    }

    @Override
    public Integer updateCommentCount(Integer id) {
        Article article = getArticleByStatusAndId(null,id);
        article.setArticleCommentCount(article.getArticleCommentCount()+1);
        return articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public Integer updateArticle(Article article) {
        return articleMapper.updateByPrimaryKey(article);
    }


}
