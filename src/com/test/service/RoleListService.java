package com.test.service;

import java.util.List;

import com.test.pojo.Role;

public interface RoleListService {
	
	//插入多个role，与RoleService分开写避免@Transactional自调用失效问题
	int insertRoleList(List<Role> roleList);
}
