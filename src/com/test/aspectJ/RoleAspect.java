package com.test.aspectJ;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect	//标志切面
public class RoleAspect {
	
	//定义一次pointcut，在其他通知中引用之
	@Pointcut("execution(* com.test.service.impl.RoleServiceImpl.printRole(..))")
	public void print() {}
	
	
	@Before("print()")
	public void before() {
		System.out.println("this is before printRole() =====================");
	}
	
	@After("print()")
	public void after() {
		System.out.println("this is after printRole() =====================");
	}
	
	@AfterReturning("print()")
	public void afterReturning() {
		System.out.println("this is afterReturning printRole() =====================");
	}
	
	@AfterThrowing("print()")
	public void afterThrowing() {
		System.out.println("this is afterThrowing printRole() =====================");
	}
	
	//环绕通知，可以同时实现前置和后置通知
	
	//不使用@PointCut注解
//	@Before("execution(* com.test.service.impl.RoleServiceImpl.printRole(..))")
//	public void before() {
//		System.out.println("this is before printRole() =====================");
//	}
//	
//	@After("execution(* com.test.service.impl.RoleServiceImpl.printRole(..))")
//	public void after() {
//		System.out.println("this is after printRole() =====================");
//	}
//	
//	@AfterReturning("execution (* com.test.service.impl.RoleServiceImpl.printRole(..))")
//	public void afterReturning() {
//		System.out.println("this is afterReturning printRole() =====================");
//	}
//	
//	@AfterThrowing("execution (* com.test.service.impl.RoleServiceImpl.printRole(..))")
//	public void afterThrowing() {
//		System.out.println("this is afterThrowing printRole() =====================");
//	}
//	
//	
	
}
