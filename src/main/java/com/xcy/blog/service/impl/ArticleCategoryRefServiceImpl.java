package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.ArticleCategoryRefMapper;
import com.xcy.blog.pojo.ArticleCategoryRef;
import com.xcy.blog.pojo.ArticleCategoryRefExample;
import com.xcy.blog.service.ArticleCategoryRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryRefServiceImpl implements ArticleCategoryRefService {
    @Autowired
    private ArticleCategoryRefMapper articleCategoryRefMapper;
    @Override
    public Integer countArticleByCategoryId(Integer categoryId) {
        ArticleCategoryRefExample example = new ArticleCategoryRefExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        List<ArticleCategoryRef> articleCategoryRefList = articleCategoryRefMapper.selectByExample(example);
        return articleCategoryRefList.size();
    }

    @Override
    public Integer deleteByCategoryId(Integer categoryId) {
        ArticleCategoryRefExample example = new ArticleCategoryRefExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        return articleCategoryRefMapper.deleteByExample(example);
    }
}
