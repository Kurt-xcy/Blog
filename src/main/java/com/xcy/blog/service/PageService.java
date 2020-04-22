package com.xcy.blog.service;

import com.xcy.blog.pojo.Page;

import java.util.List;

public interface PageService {
    /**
     * 查询所有页面
     * @return
     */
    public List<Page> listPage();

    /**
     * 根据pagekey查询页面
     * @param pageKey
     * @return
     */
    public Page getPageByKey(String pageKey);

    /**
     * 新增页面
     * @param page
     * @return
     */
    public Integer insertPage(Page page);

    /**
     *
     * 删除页面
     * @param id
     * @return
     */
    public Integer deletePage(Integer id);

    /**
     * 根据id查询页面
     * @param id
     * @return
     */
    public Page getPageById(Integer id);

    /**
     * 更新页面
     * @param page
     * @return
     */
    public Integer updatePage(Page page);

}
