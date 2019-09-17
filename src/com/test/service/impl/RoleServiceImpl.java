package com.test.service.impl;

import org.springframework.stereotype.Component;

import com.test.pojo.Role;
import com.test.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService{

	@Override
	public void printRole() {
		Role role = new Role("hehe","haha");
		System.out.println(role.getName()+"---------------");
		System.out.println(role.getNote()+"---------------");
		
	}

}
