package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.pojo.Role;

/**
 * @ClassName: RoleService
 * @Description:
 * @author ����ң
 * @date 2018��7��12�� ����1:49:27
 */
@Service
public interface RoleService {

	// 根据id获取参数
	public Role getRoleById(Long id);

	// 插入role
	public int addRole(Role role);

	// 获取所有role
	public List<Role> findAll();

	// 插入多个role
	int insertRoleList(List<Role> roleList);
}
