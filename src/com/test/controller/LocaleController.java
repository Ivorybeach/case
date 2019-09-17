package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//²âÊÔ¹ú¼Ê»¯controller
@Controller
@RequestMapping("/message")
public class LocaleController {
	
	@RequestMapping("/msgPage")
	public String msgPage(Model model) {
		return "msgPage";
	}
}
