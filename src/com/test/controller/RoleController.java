package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.pojo.Role;
import com.test.service.RoleService;

//service的错误使用实例
@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	//要求：在errorUserServices()方法中插入两个role，要求这两次插入role在同一个事务中，即：
	//要么role1,role2同时插入成功，要么同时失败
	//查看日志，两个addRole()不在同一个事务中
	//因为@Transactional标注的方法，执行时会开启一个事务，事务执行完毕，关闭事务
	public void errorUserServices() {
		Role role1 = new Role(3434,"hehe","haha");
		Role role2 = new Role(33434,"hehe","haha");
		roleService.addRole(role1);
		roleService.addRole(role2);
	} 
}
