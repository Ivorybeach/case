package com.test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.test.pojo.Role;
import com.test.pojo.RoleParam;
import com.test.service.RoleService;

/** 
* @ClassName: ParamController 
* @Description: 练习传递各种形式的参数
* @author 王逍遥
* @date 2018年7月21日 上午10:20:24 
*/
@Controller
@RequestMapping("/param")
public class ParamController {

	@Autowired
	private RoleService roleService;
	
	//最普通的传参方式，记得多个参数mapper要加@param注解
	//此处没有用到mybatis框架，省略@param参数
	@RequestMapping("/commonParam")
	public ModelAndView commonParam(String roleName,String note) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleName::::"+roleName);
		System.out.println("note::::"+note);
		mv.setViewName("role");
		return mv;
	}
	
	//pojo传参,保持HTTP和pojo属性名一致
	@RequestMapping("/pojoParam")
	public ModelAndView pojoParam(RoleParam roleParam) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleName::::"+roleParam.getRoleName());
		System.out.println("note::::" + roleParam.getNote());
		mv.setViewName("role");
		return mv;
	}
	
	//@RequestParam注解，在request域中获取参数，当HTTP与pojo,参数名不一致时使用
	@RequestMapping("/requestParam")
	public ModelAndView requestParam(@RequestParam(value="role_name",defaultValue="xixi")String roleName,String note) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleName::::"+roleName);
		System.out.println("note::::"+note);
		mv.setViewName("role2");
		return mv;
	}
	
	//@pathVariable从url地址中获得参数，RESTful风格
	//注意此处url为/getRole/id	,需要更改拦截设置
	@RequestMapping("/getRole/{id}")
	public ModelAndView getRole(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Role role = roleService.getRoleById(id);
		mv.addObject("role", role);
		mv.setViewName("test02");
		return mv;
	}
	
	
	//json传递参数，未成功	 role3.jsp
	@RequestMapping("/findRole")
	public ModelAndView findRole(@RequestBody(required=false) RoleParam roleParam){
		ModelAndView mv = new ModelAndView();
		List<Role> roleList = roleService.findRoles(roleParam);
		mv.addObject("roleList", roleList);
		mv.setView(new MappingJackson2JsonView());
		//mv.setViewName("roleList");
		return mv;
	}
	
	//json传递数组
	
	
	//表单序列化传递参数 ,未成功  role4.jsp
	@RequestMapping("/commonParamPojo2")
	public ModelAndView commonParamPojo2(String roleName,String note) {
		ModelAndView mv= new ModelAndView();
		System.out.println(roleName);
		System.out.println(note);
		mv.setViewName("role4");
		return mv;
		
	}
	
	//页面跳转,只响应get请求
	@RequestMapping(value="/{page}",method=RequestMethod.GET)
	public String getPage(@PathVariable String page) {
		return page;
	}

}
