package com.xcy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcy.blog.mapper.*;
import com.xcy.blog.pojo.*;

import com.xcy.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

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
    @Autowired
    private CommentMapper commentMapper;
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
        ArticleExample.Criteria criteria = example.createCriteria();
        if (status!=null){
            criteria.andArticleStatusEqualTo(status);
        }
        example.setOrderByClause("article_order desc");
        List<Article> articleList = articleMapper.selectByExample(example);
        List<ArticleWithBLOBs> articleWithBLOBsList = articleMapper.selectByExampleWithBLOBs(example);
        for (int i = 0 ; i<articleList.size();i++){
            articleList.get(i).setArticleContent(articleWithBLOBsList.get(i+pageSize*(pageIndex-1)).getArticleContent());
            articleList.get(i).setArticleSummary(articleWithBLOBsList.get(i+pageSize*(pageIndex-1)).getArticleSummary());
        }
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
    public PageInfo<Article> pageArticleByUserId(Integer pageIndex, Integer pageSize, Integer status, int userId) {
        ArticleExample example = new ArticleExample();
        PageHelper.startPage(pageIndex,pageSize);
        ArticleExample.Criteria criteria = example.createCriteria();
        if (status!=null){
            criteria.andArticleStatusEqualTo(status);
        }
        criteria.andArticleUserIdEqualTo(userId);
        List<Article> articleList = articleMapper.selectByExample(example);
        List<ArticleWithBLOBs> articleWithBLOBsList = articleMapper.selectByExampleWithBLOBs(example);
        for (int i = 0 ; i<articleList.size();i++){
            articleList.get(i).setArticleContent(articleWithBLOBsList.get(i).getArticleContent());
            articleList.get(i).setArticleSummary(articleWithBLOBsList.get(i).getArticleSummary());
        }
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
        articleWithBLOBs.setArticleIsComment(article.getArticleIsComment());
        Integer index = articleMapper.insertSelective(articleWithBLOBs);

        List<Category> categoryList = article.getCategoryList();
        List<Tag> tagList = article.getTagList();
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("article_create_time desc");
        example.createCriteria().andArticleTitleEqualTo(articleWithBLOBs.getArticleTitle());
        List<Article> getArticle = articleMapper.selectByExample(example);
        System.out.println("article.getArticleId()"+getArticle.get(0).getArticleId());
        for (Category category:categoryList){
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef();
            System.out.println("article.getArticleId()"+getArticle.get(0).getArticleId());
            articleCategoryRef.setArticleId(getArticle.get(0).getArticleId());
            articleCategoryRef.setCategoryId(category.getCategoryId());
            articleCategoryRefMapper.insertSelective(articleCategoryRef);
        }

        for(Tag tag:tagList){
            ArticleTagRefKey articleTagRefKey = new ArticleTagRefKey();
            articleTagRefKey.setArticleId(getArticle.get(0).getArticleId());
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
    public ArticleWithBLOBs getArticleByStatusAndId(Integer status, Integer id) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleIdEqualTo(id);
        if (status!=null){
            example.createCriteria().andArticleStatusEqualTo(status);
        }
        List<ArticleWithBLOBs> articleList = articleMapper.selectByExampleWithBLOBs(example);
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

    @Override
    public List<Article> listRandomArticle(Integer limit) {
        List<Article> articleList = new ArrayList<>();
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("RAND()");
        example.createCriteria().andArticleStatusEqualTo(1);
        articleList = articleMapper.selectByExample(example);
        if (articleList.size()>limit){
            List<Article> list = articleList.subList(0,limit);
            return list;
        }else {
            return articleList;
        }

    }

    @Override
    public List<Article> listArticleByCommentCount(Integer limit) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("article_comment_count desc");
        example.createCriteria().andArticleStatusEqualTo(1);
        List<Article> articleList = articleMapper.selectByExample(example);
        if (articleList.size()>limit){
            List<Article> list = articleList.subList(0,limit);
            return list;
        }
        return null;

    }

    @Override
    public PageInfo<Article> pageArticleSearch(Integer pageIndex, Integer pageSize, Integer status, String keywords) {
        ArticleExample example = new ArticleExample();
        PageHelper.startPage(pageIndex,pageSize);
        ArticleExample.Criteria criteria = example.createCriteria();
        if (status!=null){
            criteria.andArticleStatusEqualTo(status);
        }
        criteria.andArticleTitleLike("%"+keywords+"%");
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
    public PageInfo<Article> pageArticleBycategoryId(Integer pageIndex, Integer pageSize, Integer status, Integer categoryId) {
        ArticleCategoryRefExample articleCategoryRefExample = new ArticleCategoryRefExample();
        articleCategoryRefExample.createCriteria().andCategoryIdEqualTo(categoryId);
        List<ArticleCategoryRef> articleCategoryRefList = articleCategoryRefMapper.selectByExample(articleCategoryRefExample);
        List<Article> articleList = new ArrayList<>();
        for (ArticleCategoryRef articleCategoryRef:articleCategoryRefList){
            Article article = articleMapper.selectByPrimaryKey(articleCategoryRef.getArticleId());
            if (article!=null){
                if (status==article.getArticleStatus()){
                    articleList.add(article);
                }
            }

        }
        return new PageInfo<>(articleList);
    }

    @Override
    public List<Integer> listCategoryIdByArticleId(Integer articleId) {
        ArticleCategoryRefExample articleCategoryRefExample = new ArticleCategoryRefExample();
        articleCategoryRefExample.createCriteria().andArticleIdEqualTo(articleId);
        List<ArticleCategoryRef> articleCategoryRefList = articleCategoryRefMapper.selectByExample(articleCategoryRefExample);
        List<Integer> integerList = new ArrayList<>();
        for (ArticleCategoryRef articleCategoryRef:articleCategoryRefList){
            integerList.add(articleCategoryRef.getCategoryId());
        }
        return integerList;
    }

    @Override
    public List<Article> listArticleByCategoryIds(List<Integer> categoryIds, Integer limit) {
        List<Article> articleList = new ArrayList<>();
        for (Integer categoryId:categoryIds){
            ArticleCategoryRefExample articleCategoryRefExample = new ArticleCategoryRefExample();
            articleCategoryRefExample.createCriteria().andCategoryIdEqualTo(categoryId);
            List<ArticleCategoryRef> articleCategoryRefList = articleCategoryRefMapper.selectByExample(articleCategoryRefExample);
            for (ArticleCategoryRef articleCategoryRef:articleCategoryRefList){
                Article article = articleMapper.selectByPrimaryKey(articleCategoryRef.getArticleId());
                articleList.add(article);
            }
        }
        List<Article> list = new ArrayList<>();
        if (articleList.size()>5){
            list = articleList.subList(0,5);
        }
        return list;
    }

    @Override
    public Integer countArticle(Integer status) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleStatusEqualTo(status);
        List<Article> articleList = articleMapper.selectByExample(example);
        return articleList.size();
    }

    @Override
    public Integer countArticleComment() {
        return commentMapper.countByExample(new CommentExample());
    }

    @Override
    public Integer countArticleView() {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleStatusEqualTo(1);
        List<Article> articleList= articleMapper.selectByExample(example);
        Integer sum = 0;
        for (Article article:articleList){
            if (article.getArticleViewCount()!=null){
                sum += article.getArticleViewCount();
            }
        }
        return sum;
    }

    @Override
    public Article getLastUpdateArticle() {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("article_update_time desc");
        List<Article> articleList = articleMapper.selectByExample(example);
        if (articleList.size()>0){
            return articleList.get(0);
        }
        return null;
    }

    @Override
    public List<Article> listArticleByViewCount(Integer limit) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("article_view_count desc");
        List<Article> articleList = articleMapper.selectByExample(example);
        List<Article> list = new ArrayList<>();
        if (articleList.size()>5){
            list = articleList.subList(0,5);
            return list;
        }
        return articleList;
    }

    @Override
    public Article getAfterArticle(Integer articleId) {
        return articleMapper.selectByPrimaryKey(articleId+1);
    }

    @Override
    public Article getPreArticle(Integer articleId) {
        return articleMapper.selectByPrimaryKey(articleId-1);
    }

    @Override
    public List<Article> listAllNotWithContent() {
        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public PageInfo<Article> pageArticleBytagId(Integer pageIndex, Integer pageSize, Integer status, Integer tagId) {
        ArticleTagRefExample articleTagRefExample = new ArticleTagRefExample();
        articleTagRefExample.createCriteria().andTagIdEqualTo(tagId);
        List<ArticleTagRefKey> articleTagRefKeyList = articleTagRefMapper.selectByExample(articleTagRefExample);
        List<Article> articleList = new ArrayList<>();
        for (ArticleTagRefKey articleTagRefKey:articleTagRefKeyList){
            Article article = articleMapper.selectByPrimaryKey(articleTagRefKey.getArticleId());
            articleList.add(article);
        }
        return new PageInfo<>(articleList);
    }

    @Override
    public Integer countArticle() {
        return articleMapper.countByExample(new ArticleExample());
    }

    @Override
    public Integer deleteArticle(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateArticleDetail(Article article) {
        ArticleWithBLOBs articleWithBLOBs = new ArticleWithBLOBs();
        articleWithBLOBs.setArticleId(article.getArticleId());
        articleWithBLOBs.setArticleUserId(article.getArticleUserId());
        articleWithBLOBs.setArticleTitle(article.getArticleTitle());
        articleWithBLOBs.setArticleContent(article.getArticleContent());
        articleWithBLOBs.setArticleSummary(article.getArticleSummary());
        articleWithBLOBs.setArticleCreateTime(article.getArticleCreateTime());
        articleWithBLOBs.setArticleUpdateTime(article.getArticleUpdateTime());
        articleWithBLOBs.setArticleOrder(article.getArticleOrder());
        articleWithBLOBs.setArticleStatus(article.getArticleStatus());
        articleWithBLOBs.setArticleIsComment(article.getArticleIsComment());
        Integer index = articleMapper.updateByPrimaryKeySelective(articleWithBLOBs);

        List<Category> categoryList = article.getCategoryList();
        List<Tag> tagList = article.getTagList();

        ArticleCategoryRefExample articleCategoryRefExample = new ArticleCategoryRefExample();
        articleCategoryRefExample.createCriteria().andArticleIdEqualTo(article.getArticleId());
        articleCategoryRefMapper.deleteByExample(articleCategoryRefExample);
        for (Category category:categoryList){
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef();
            articleCategoryRef.setArticleId(article.getArticleId());
            articleCategoryRef.setCategoryId(category.getCategoryId());
            articleCategoryRefMapper.insertSelective(articleCategoryRef);
        }

        ArticleTagRefExample articleTagRefExample = new ArticleTagRefExample();
        articleTagRefExample.createCriteria().andArticleIdEqualTo(article.getArticleId());
        articleTagRefMapper.deleteByExample(articleTagRefExample);
        for(Tag tag:tagList){
            ArticleTagRefKey articleTagRefKey = new ArticleTagRefKey();
            articleTagRefKey.setArticleId(article.getArticleId());
            articleTagRefKey.setTagId(tag.getTagId());
            articleTagRefMapper.insertSelective(articleTagRefKey);
        }

        return index;
    }

    @Override
    public List<Article> listArticleByUser(User user, Integer limit) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleUserIdEqualTo(user.getUserId());
        List<Article> articleList = articleMapper.selectByExample(example);
        if (articleList.size()>5){
            articleList = articleList.subList(0,5);
        }
        return articleList;
    }

    //对文章重新排序，依靠设置article_order
    public Integer reorder(){
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("article_create_time desc");
        List<Article> articleList = articleMapper.selectByExample(example);
        int order = 10;
        for (Article article:articleList){
            if (articleList.indexOf(article)<10){
                article.setArticleOrder(order--);
                articleMapper.updateByPrimaryKey(article);
            }else{
                article.setArticleOrder(1);
                articleMapper.updateByPrimaryKey(article);
            }


        }

        //按照viewcount浏览量降序
        Collections.sort(articleList, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o2.getArticleViewCount()-o1.getArticleViewCount();
            }
        });
        Integer viewMax = articleList.get(0).getArticleViewCount();
        for (Article article:articleList){
            article.setArticleOrder(article.getArticleViewCount()*10/viewMax+article.getArticleOrder());
            articleMapper.updateByPrimaryKey(article);
        }

        //按照commentcount评论量降序
        Collections.sort(articleList, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o2.getArticleCommentCount()-o1.getArticleCommentCount();
            }
        });
        Integer countMax = articleList.get(0).getArticleCommentCount();
        for (Article article:articleList){
            article.setArticleOrder(article.getArticleCommentCount()*10/countMax+article.getArticleOrder());
            articleMapper.updateByPrimaryKey(article);
        }

        return 1;
    }
}
