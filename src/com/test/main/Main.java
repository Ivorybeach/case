package com.test.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pojo.Role;
import com.test.service.RoleService;

//查询，测试读/写提交隔离级别
//可查看日志输出，transactional sqlSession，说明事务生效；
public class Main {
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleService roleService = ctx.getBean(RoleService.class);
		Role role = roleService.getRoleById(1L);
		System.out.println(role.getRoleName()+"--------------------");
		ctx.close();
		
	}
}
