package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.PageMapper;
import com.xcy.blog.pojo.Page;
import com.xcy.blog.pojo.PageExample;
import com.xcy.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageMapper pageMapper;
    @Override
    public List<Page> listPage() {
        return pageMapper.selectByExample(new PageExample());
    }

    @Override
    public Page getPageByKey(String pageKey) {
        PageExample example = new PageExample();
        example.createCriteria().andPageKeyEqualTo(pageKey);
        List<Page> pageList = pageMapper.selectByExample(example);
        if (pageList.size()>0){
            return pageList.get(0);
        }
        return null;
    }

    @Override
    public Integer insertPage(Page page) {
        return pageMapper.insert(page);
    }

    @Override
    public Integer deletePage(Integer id) {
        return pageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page getPageById(Integer id) {
        return pageMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updatePage(Page page) {
        return pageMapper.updateByPrimaryKey(page);
    }
}
