package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.pojo.Role;
import com.test.service.RoleListService;
import com.test.service.RoleService;

public class RoleListServiceImpl implements RoleListService{

	@Autowired
	RoleService roleService;
	
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRES_NEW)
	@Override
	public int insertRoleList(List<Role> roleList) {
		int count = roleList.size();
		for (Role role : roleList) {
			roleService.addRole(role);
		}
		return count;
	}

}
