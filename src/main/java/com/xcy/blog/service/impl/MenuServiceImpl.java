package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.MenuMapper;
import com.xcy.blog.pojo.Menu;
import com.xcy.blog.pojo.MenuExample;
import com.xcy.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> listMenu() {
        return menuMapper.selectByExample(new MenuExample());
    }

    @Override
    public Integer insertMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public Integer deleteMenu(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Menu getMenuById(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }
}
