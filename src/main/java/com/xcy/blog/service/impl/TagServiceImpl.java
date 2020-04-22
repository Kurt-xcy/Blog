package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.ArticleTagRefMapper;
import com.xcy.blog.mapper.TagMapper;
import com.xcy.blog.pojo.ArticleTagRefExample;
import com.xcy.blog.pojo.Tag;
import com.xcy.blog.pojo.TagExample;
import com.xcy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;
    @Override
    public List<Tag> listTag() {
        return tagMapper.selectByExample(new TagExample());
    }

    @Override
    public List<Tag> listTagWithCount() {
        List<Tag> tagList = tagMapper.selectByExample(new TagExample());
        for (Tag tag:tagList){
            ArticleTagRefExample example = new ArticleTagRefExample();
            example.createCriteria().andTagIdEqualTo(tag.getTagId());
            tag.setArticleCount(articleTagRefMapper.countByExample(example));
        }
        return tagList;
    }

    @Override
    public Integer insertTag(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public Integer deleteTag(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateTag(Tag tag) {
        return tagMapper.updateByPrimaryKey(tag);
    }
}
