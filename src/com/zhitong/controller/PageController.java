package com.zhitong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/{page}")
	public String getPage(@PathVariable String page) {
		return page;
	}
	
	@RequestMapping("/common/{page}")
	public String getCommonPage(@PathVariable String page) {
		return "/common/"+page;
	}
	
	@RequestMapping("/other/{page}")
	public String getOtherPage(@PathVariable String page) {
		return "/other/"+page;
	}
	
	@RequestMapping("/admin/{page}")
	public String getAdminPage(@PathVariable String page) {
		return "admin/"+page;
	}
	
}
