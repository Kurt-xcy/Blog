package com.xcy.blog.service;

import com.xcy.blog.pojo.Link;

import java.util.List;

public interface LinkService {
    /**
     * 查询所有连接
     * @return
     */
    public List<Link> listLink();

    /**
     * 新增链接
     * @param link
     * @return
     */
    public Integer insertLink(Link link);

    /**
     * 删除链接
     * @param id
     * @return
     */
    public Integer deleteLink(Integer id);

    /**
     * 根据id获取链接
     * @param id
     * @return
     */
    public Link getLinkById(Integer id);

    /**
     * 更新链接
     * @param link
     * @return
     */
    public Integer updateLink(Link link);
}
