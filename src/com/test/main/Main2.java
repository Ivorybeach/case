package com.test.main;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pojo.Role;
import com.test.service.RoleListService;
import com.test.service.RoleService;

public class Main2 {
	public static void main(String[] args) {
		//正确：
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleListService roleListService = ctx.getBean(RoleListService.class);
		
		//自调用失效：
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//RoleService roleService = ctx.getBean(RoleService.class);
		List<Role> roleList = new ArrayList<Role>();
		Role role1 = new Role(981, "hehe", "haha");
		Role role2 = new Role(9381, "xixi", "heihei");
		roleList.add(role1);
		roleList.add(role2);
		int count = roleListService.insertRoleList(roleList);
		System.out.println(count+"-------------------------------");
		ctx.close();
	}
}
