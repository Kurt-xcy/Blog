package com.xcy.blog.service.impl;

import com.xcy.blog.VO.UserVO;
import com.xcy.blog.mapper.ArticleMapper;
import com.xcy.blog.mapper.RoleMapper;
import com.xcy.blog.mapper.UserMapper;
import com.xcy.blog.mapper.UserRoleMapper;
import com.xcy.blog.pojo.*;
import com.xcy.blog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User getUserByName(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updUser(User user) {
        UserExample example = new UserExample();
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserByEmail(String email) {
        UserExample example = new UserExample();
        example.createCriteria().andUserEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<User> listUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<UserVO> listUserVO() {
        List<User> listuser = listUser();
        List<UserVO> listuserVO = new ArrayList<>();
        for(User user:listuser){
            UserVO userVO = new UserVO(user);
            ArticleExample example = new ArticleExample();
            example.createCriteria().andArticleUserIdEqualTo(user.getUserId());
            userVO.setArticleCount(articleMapper.countByExample(example));

            //根据userid查找role
            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(userVO.getUserId());
            List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
            Role role = roleMapper.selectByPrimaryKey(userRoleList.get(0).getRoleId());
            userVO.setRole(role.getRoleName());
            listuserVO.add(userVO);
        }
        return listuserVO;
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insert(user);
    }


}
