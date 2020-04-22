package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.LinkMapper;
import com.xcy.blog.pojo.Link;
import com.xcy.blog.pojo.LinkExample;
import com.xcy.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    @Override
    public List<Link> listLink() {
        return linkMapper.selectByExample(new LinkExample());
    }

    @Override
    public Integer insertLink(Link link) {
        return linkMapper.insert(link);
    }

    @Override
    public Integer deleteLink(Integer id) {
        return linkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Link getLinkById(Integer id) {
        return linkMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateLink(Link link) {
        return linkMapper.updateByPrimaryKey(link);
    }
}
