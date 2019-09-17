package com.zhitong.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.zhitong.mapper.InfoMapper;
import com.zhitong.pojo.Information;
import com.zhitong.service.InfoService;
import com.zhitong.util.IdUtil;
import com.zhitong.util.PageParam;

@Controller
@RequestMapping("/info")
public class InfoController {

	@Autowired
	InfoService infoService;
	@Autowired
	InfoMapper infoMapper;
	
	//添加info
	@RequestMapping("/addInfo")
	public ModelAndView addInfo(@Valid Information info,Errors errors,HttpSession sesson) {
		info.setId(IdUtil.getId());
		if (errors.hasErrors()) {
			List<FieldError> listErrors = errors.getFieldErrors();
			for (FieldError error : listErrors) {
				//这里应当发送到前台显示，暂缓
				System.err.println(error.getField()+"----"+error.getDefaultMessage());
			}
			ModelAndView mv = new ModelAndView();
			//信息出现错误，重新填写
			//此处数据没有回填
			mv.setViewName("join");
			return mv;
		}
		infoService.addInfo(info);
		//信息提交成功后添加标识
		sesson.setAttribute("info", "info");
		ModelAndView mv = new ModelAndView();
		//信息提交成功，返回首页
		mv.setViewName("redirect:/index.do");
		return mv;
	}
	
	//查询单条info，用作测试
	@RequestMapping("/getInfo")
	public ModelAndView getInfo(Information info) {
		ModelAndView mv = new ModelAndView();
		Information info2 = infoService.getInfo(info);
		mv.addObject("info2", info2);
		mv.setViewName("/admin/table-basic");
		return mv;
	}
	
	//查询所有
	@RequestMapping("/getAllInfo")
	public ModelAndView getAllInfo() {
		ModelAndView mv = new ModelAndView();
		List<Information> infoList = infoService.findAll();
		mv.addObject("infoList", infoList);
		mv.setViewName("/admin/table-basic");
		return mv;
	}
	
	//分页查询
	@RequestMapping("/getAllByPage")
	@ResponseBody
	//要传递currentPage过来
	public ModelAndView getAllByPage(PageParam pageParam) {
		ModelAndView mv = new ModelAndView();
		int totalCount = infoMapper.getCount();
		pageParam.setTotalCount(totalCount);
		List<Information> infoList = infoMapper.findAllByPage(pageParam.getCurrentPage(), pageParam.getPageCount());
		mv.addObject("infoList", infoList);
		mv.addObject("pageParam", pageParam);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	//接收JSON参数
	
}