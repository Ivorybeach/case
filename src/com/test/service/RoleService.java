package com.test.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.test.pojo.Role;
import com.test.pojo.RoleParam;

/**
 * @ClassName: RoleService
 * @Description:
 * @author 王逍遥
 * @date 2018年7月12日 下午1:49:27
 */
@Service
public interface RoleService {

	// 根据id获取参数
	public Role getRoleById(Long id);

	// 插入role
	public int addRole(Role role);

	// 获取多个role
	public List<Role> findRoles(RoleParam roleParam);

	// 获取所有role
	public List<Role> findAll();
}
