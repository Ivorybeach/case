package com.test.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.pojo.Role;

/**
 * @ClassName: RoleMapper
 * @Description:
 * @author 王逍遥
 * @date 2018年7月12日 下午12:25:09
 */

public interface RoleMapper {

	// 根据id获取角色
	public Role getRole(Long id);

	// 插入角色
	public int addRole(Role role);

	// 获取所有角色
	public List<Role> findAll();
}