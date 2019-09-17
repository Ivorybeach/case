package com.test.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.AopConfig;
import com.test.service.RoleService;

public class Main {
	

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		
		RoleService roleService = ctx.getBean(RoleService.class);
		
		roleService.printRole();
		
		ctx.close();
		
		
	}
	
}
