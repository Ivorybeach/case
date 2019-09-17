package com.test.mapper;

import org.apache.ibatis.annotations.Param;

import com.test.pojo.Role;

public interface RoleMapper {

	//查询
	public Role findRole(@Param("roleName") String roleName,@Param("note")String note);
	
	//插入
	public int insertRole(Role role);
	
	
	
}
