package com.xcy.blog.service;

public interface UserRoleService {
    /**
     * 插入用户角色表
     * @param userId
     * @param roleId
     * @return
     */
    public Integer insertUserRole(int userId,int roleId);
}
