package com.xcy.blog.service.impl;

import com.xcy.blog.mapper.UserRoleMapper;
import com.xcy.blog.pojo.UserRole;
import com.xcy.blog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer insertUserRole(int userId, int roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return userRoleMapper.insert(userRole);
    }
}
