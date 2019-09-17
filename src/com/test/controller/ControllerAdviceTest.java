package com.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.test.service.RoleService;

/** 
* @ClassName: TestController 
* @Description:@ControllerAdvice和相关注解测试
* @author 王逍遥
* @date 2018年7月16日 上午9:48:58 
*/
@ControllerAdvice(basePackages= {"com.test.controller"})
public class ControllerAdviceTest {
	
	//1.@InitBinder操作HTTP参数：日期转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat, false));
	}
	
	//2.全局异常处理器，处理RuntimeExcetpion异常，当出现RuntimeExcetpion异常时会跳转指定页面defaultException，其他异常则不会
	//RuntimeException在全局异常处理器GlobalExceptionResolver.java中处理，这里将以下内容注释
//	@ExceptionHandler(RuntimeException.class)
//	public String exception(RuntimeException exception,Model model) {
//		return "defaultError";
//	}
	
	//3.@ModelAttribute，被@ModelAttribute注释的方法会在此controller每个方法执行前被执行
		//@ModelAttribute注解的方法有返回值，返回值会被保存在数据模型中；
		//可以通过mv.getModelMap().get(key)或model.asMap().get(key)获取value
		//可以用来保存所有controller公用的数据，或者提前需要预加载的数据

	
	
	
}
