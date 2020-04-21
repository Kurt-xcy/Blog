package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.TagMapper;
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
    @Override
    public List<Tag> listTag() {
        return tagMapper.selectByExample(new TagExample());
    }
}
