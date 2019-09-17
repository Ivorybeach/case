package com.zhitong.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//字符编码过滤器，解决post中文乱码问题
@WebFilter(filterName="characterEncodingFilter",urlPatterns="/*")
public class CharacterEncodingFilter implements Filter {

	//初始化filter
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//设置请求和响应编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		chain.doFilter(request,response);
	}

	//销毁filter
	@Override
	public void destroy() {
	}

}
