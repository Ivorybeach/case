package com.zhitong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.zhitong.interceptor.ResourceInterceptor;

@Configuration
@ComponentScan(value = "com.zhitong.*")
@EnableWebMvc // 启用springmvc
public class WebConfig implements WebMvcConfigurer {

	// 配置静态资源解析
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 指定拦截的url和对应的资源位置
		// 疑问：如果指定location在WEB-INF文件夹之下的话，则不能映射成功，为什么？？？
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		
	}

	// 视图解析器
	@Bean(name = "internalResourceViewResolver")
	public ViewResolver initViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// 配置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ResourceInterceptor()).addPathPatterns("/temp.do");
	}
	
}
