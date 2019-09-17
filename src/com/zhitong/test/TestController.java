package com.zhitong.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.zhitong.pojo.Information;
import com.zhitong.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping("/getInfo")
	public ModelAndView getInfo() {
		ModelAndView mv = new ModelAndView();
		Information info = testService.findInfo();
		mv.addObject(info);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	
}
