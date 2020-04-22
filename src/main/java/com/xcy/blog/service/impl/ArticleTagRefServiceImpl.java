package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.ArticleTagRefMapper;
import com.xcy.blog.pojo.ArticleTagRefExample;
import com.xcy.blog.service.ArticleTagRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTagRefServiceImpl implements ArticleTagRefService {
    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;
    @Override
    public Integer countArticleByTagId(Integer id) {
        ArticleTagRefExample example = new ArticleTagRefExample();
        example.createCriteria().andTagIdEqualTo(id);
        return articleTagRefMapper.countByExample(example);
    }
}
