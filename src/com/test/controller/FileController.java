package com.test.controller;

import java.io.File;

import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class FileController {

	@RequestMapping("/uploadMultipartFile")
	//@RequestParam注解是必须的
	public ModelAndView uploadMultipartFile(@RequestParam(value="file",required=false) MultipartFile multipartFile) {
		ModelAndView mv = new ModelAndView();
		if (multipartFile == null) {
			System.err.println("multipartFile is null !!!!");
		}
		//获取原始文件名
		String fileName = multipartFile.getOriginalFilename();
		multipartFile.getContentType();
		//目标文件,destination file
		File dest = new File(fileName);
		try {
			//Transfer the received file to the given destination file
			multipartFile.transferTo(dest);
			mv.addObject("success", true);
			mv.addObject("msg", "上传文件成功！");
		} catch (IllegalStateException | IOException e) {
			mv.addObject("success", false);
			mv.addObject("msg", "上传文件失败！");
			e.printStackTrace();
		}
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	
	@RequestMapping("/uploadPart")
	public ModelAndView uploadPart(@RequestParam(value="file",required=false) Part part) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		String fileName = part.getName();
		try {
			//A convenience method to write this uploaded item to disk.
			part.write(fileName);
			mv.addObject("success", true);
			mv.addObject("msg", "上传成功！");
		} catch (IOException e) {
			mv.addObject("success", false);
			mv.addObject("msg", "上传文件失败！");
			e.printStackTrace();
		}
		return mv;
	}
}
