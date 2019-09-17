package com.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.pojo.Validation;
import com.test.util.TransactionValidator;


@Controller
public class ValidationController {

	//JSR303注解验证
	@RequestMapping("/validationSubmit")
	public ModelAndView validationSubmit(@Valid Validation va,Errors errors) {
		System.out.println(va.getDate()+"--------------");
		System.out.println(va.getPrice());
		if (errors.hasErrors()) {
			List<FieldError> listErrors = errors.getFieldErrors();
			for (FieldError error : listErrors) {
				System.err.println(error.getDefaultMessage());
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("role");
		return mv;
	}
	
	//spring提供的Validator验证
	
	//绑定具体的validator
	//如果JSR和Validator同时使用，@InitBinder注解下，Validator会覆盖JSR
//	@InitBinder
//	public void initBinder(DataBinder binder) {
//		binder.setValidator(new TransactionValidator());
//	}
//	//
//	@RequestMapping("/validator")
//	public ModelAndView validator(@Valid Validation va,Errors errors) {
//		ModelAndView mv = new ModelAndView();
//		if (errors.hasErrors()) {
//			List<FieldError> errorList = errors.getFieldErrors();
//			for (FieldError error : errorList) {
//				System.out.println(error.getField()+"---"+error.getDefaultMessage()+"---"+error.getCode());
//			}
//		}
//		mv.setViewName("role");
//		return mv;
//	}
//	
}
