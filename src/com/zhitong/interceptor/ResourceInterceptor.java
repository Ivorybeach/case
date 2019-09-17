package com.zhitong.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//拦截学习资源访问，只有提交注册信息之后才可以访问资源
public class ResourceInterceptor extends HandlerInterceptorAdapter{

	//在访问资源handler之前进行拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String infoValue = (String) request.getSession().getAttribute("info");
		System.out.println(infoValue + "----------------------------------");
		if (infoValue!=null) {
			return true;
		}
		//跳转页面
		request.getRequestDispatcher("/common/deny.do").forward(request, response);
		return false;
	}

	
	
}
