package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.test.pojo.Role;
import com.test.pojo.Validation;
import com.test.service.RoleService;

/**
 * @ClassName: RoleController
 * @Description: 重定向、转发测试、validation测试
 * @author 王逍遥
 * @date 2018年7月16日 上午10:32:47
 */
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	// 测试重定向,RedirectAttributes可以传递参数，包括pojo
	@RequestMapping("/testRedirect")
	public String testRedirect(String roleName, String note, RedirectAttributes ra) {
		roleName = "wangxiaoyao";
		note = "duanchangren";
		// addFlashAttribute()是将参数保存到session，重定向后读取然后清除
		ra.addFlashAttribute("note", note);
		ra.addFlashAttribute("roleName", roleName);
		// 或者：mv.setViewName("redirect:./showResult");
		return "redirect:./showResult";
	}

	// 展示重定向结果
	@RequestMapping("/showResult")
	@ResponseBody
	public ModelAndView showResult(String roleName, String note, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	// 转发测试，转发似乎不能传递参数
	// 但是可以将属性保存在request或session中，转发之后取出属性
	@RequestMapping("/testForward")
	public String testForward(HttpServletRequest request) {
		request.setAttribute("hehe", "haha");
		return "forward:./showForwardResult";
	}

	// 展示转发结果
	@RequestMapping("/showForwardResult")
	@ResponseBody
	public ModelAndView showForwardResult(@RequestAttribute("hehe") String hehe, String roleName, String note,
			Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hehe", hehe);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	// 根据id获取role
	@RequestMapping("/test02")
	public ModelAndView test02(@RequestParam(value = "id", defaultValue = "1") Long id) {

		Role role = roleService.getRoleById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("role", role);
		// modelAndView.setViewName("test02");
		// 设置视图类型为json，需要jackson2包
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}

	// 添加role
	@RequestMapping("/test03")
	public ModelAndView test03() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("test03");
		return modelAndView;
	}

	// 表单提交
	@RequestMapping("/testSubmit03")
	public ModelAndView testSubmit03(Role role) {
		ModelAndView mv = new ModelAndView();
		roleService.addRole(role);
		mv.setViewName("testSubmit");
		return mv;
	}

	// 页面跳转,只响应get请求
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String getPage(@PathVariable String page) {
		return page;
	}

	//这是一个错误方法，完全用来测试全局异常处理器
	@RequestMapping(value = "/roleErrorSubmit", method = RequestMethod.POST)
	public void roleErrorSubmit() {
		Role role = roleService.getRoleById(111L);
		if (role == null) {
			throw new RuntimeException();
		}
	}
}
