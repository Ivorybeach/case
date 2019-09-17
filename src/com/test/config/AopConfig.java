package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.test.aspectJ.RoleAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.test.*")
public class AopConfig {

	@Bean
	public RoleAspect getRoleAspect() {
		return new RoleAspect();
	}
	
}
