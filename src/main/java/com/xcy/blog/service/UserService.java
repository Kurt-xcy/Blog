package com.xcy.blog.service;

import com.xcy.blog.VO.UserVO;
import com.xcy.blog.pojo.User;

import java.util.List;


public interface UserService {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User getUserByName(String username);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User getUserById(Integer id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public Integer updUser(User user);

    /**
     * 根据Email查询用户
     * @param email
     * @return
     */
    public User getUserByEmail(String email);

    /**
     *返回用户列表
     * @return
     */
    public List<User> listUser();

    /**
     *返回用户列表VO
     * @return
     */
    public List<UserVO> listUserVO();

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public Integer deleteUser(Integer id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    public Integer insertUser(User user);
}
