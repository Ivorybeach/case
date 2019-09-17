package com.zhitong.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//AbstractAnnotationConfigDispatcherServletInitializer,使用java配置文件注册dispatcherServlet
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	//spring配置
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
		
	}

	//dispatcherServlet配置
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	//拦截请求
	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.do"};
	}

	//获取过滤器
	@Override
	protected Filter[] getServletFilters() {
		//字符编码过滤器
		return new Filter[]{new CharacterEncodingFilter()};
	}

	//文件上传
	@Override
	protected void customizeRegistration(Dynamic dynamic) {
		//真实路径，对应的虚拟目录为http://localhost:8080/pic/
		String filePath = "H:\\pic";
		dynamic.setMultipartConfig(new MultipartConfigElement(filePath));
	}
	
	
	
	
}
