package com.xcy.blog.shiro.realm;


import com.xcy.blog.mapper.*;
import com.xcy.blog.pojo.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;


public class MyRealm extends AuthorizingRealm {



	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermissionMapper permissionMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	/**
	 * 登录之后用于授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(username);
		User user = userMapper.selectByExample(userExample).get(0);

		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(user.getUserId());
		List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);

		HashSet<String> set = new HashSet();
		for (UserRole userRole : userRoleList){
			set.add(roleMapper.selectByPrimaryKey(userRole.getRoleId()).getRoleName());
		}

		authorizationInfo.setRoles(set);

		RolePermissionExample rolePermissionExample = new RolePermissionExample();
		HashSet<String> set2 = new HashSet();
		for (UserRole userRole : userRoleList){
			rolePermissionExample.createCriteria().andRoleIdEqualTo(userRole.getRoleId());
			List<RolePermission> rolePermissionList = rolePermissionMapper.selectByExample(rolePermissionExample);
			for (RolePermission rolePermission:rolePermissionList){
				set2.add(permissionMapper.selectByPrimaryKey(rolePermission.getPermissionId()).getPermissionName());
			}
		}
		authorizationInfo.setStringPermissions(set2);
		return authorizationInfo;
	}

	/**
	 * 用于验证身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(username);
		User user = userMapper.selectByExample(userExample).get(0);
		if (null != user) {
			AuthenticationInfo info = new SimpleAuthenticationInfo(
					user.getUserName(), user.getUserPass(), "xx");
			return info;
		}
		return null;
	}

}