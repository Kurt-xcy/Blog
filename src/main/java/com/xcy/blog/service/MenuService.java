package com.xcy.blog.service;

import com.xcy.blog.pojo.Menu;

import java.util.List;

public interface MenuService {
    /**
     *
     * 查询所有菜单
     * @return
     */
    public List<Menu> listMenu();

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    public Integer insertMenu(Menu menu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    public Integer deleteMenu(Integer id);

    /**
     * 获取菜单
     * @param id
     * @return
     */
    public Menu getMenuById(Integer id);

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    public Integer updateMenu(Menu menu);
}
