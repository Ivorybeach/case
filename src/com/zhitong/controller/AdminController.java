package com.zhitong.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.zhitong.pojo.Admin;
import com.zhitong.pojo.Information;
import com.zhitong.service.AdminService;
import com.zhitong.service.InfoService;
import com.zhitong.util.ExcelUtil;
import com.zhitong.util.ExcelView;
import com.zhitong.util.IdUtil;
import com.zhitong.util.PyUtil;

import javafx.beans.binding.SetExpression;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	InfoService infoService;

	// 登录
	@RequestMapping("/loginSubmit")
	public String login(String adminName, String password, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Admin admin = adminService.selectAdmin(adminName, password);
		if (admin == null) {
			return null;
		}
		session.setAttribute("admin", admin);
		mv.addObject("admin", admin);
		mv.setView(new MappingJackson2JsonView());
		return "forward:/admin/index.do";
	}

	// 注册
	@RequestMapping("/registSubmit")
	public ModelAndView regist(Admin admin) {
		admin.setId(IdUtil.getId());
		ModelAndView mv = new ModelAndView();
		adminService.addAdmin(admin);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	// Mr.Cat登录
	@RequestMapping(value = "/catLogin")
	@ResponseBody
	public String catLogin(@RequestParam(value = "image", required = false) MultipartFile multipartFile) {
		ModelAndView mv = new ModelAndView();
		if (multipartFile == null) {
			throw new RuntimeException();
		}
		// 获取原始文件名
		String fileName = multipartFile.getOriginalFilename();
		System.out.println(fileName);
		// 目标文件,destination file
		File dest = new File(fileName + ".jpg");
		try {
			// 保存图片到虚拟目录：http://localhost:8080/pic
			multipartFile.transferTo(dest);
			// 调用python脚本
			// falg：1表示猫脸，2表示人脸，0不是猫脸不是人脸
			String flag = PyUtil.exePy();
			// 以json的形式传到前台，前台有function进行接收，在前台判断人脸还是猫脸
			return flag;
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException();
		}
	}

	// Mr.Cat登录成功，跳转到index
	@RequestMapping("/catLoginSucess")
	public String catLoginSucess(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String adminName="Mr.cat";
		String password="Mr.cat";
		Admin admin = adminService.selectAdmin(adminName, password);
		if (admin == null) {
			return null;
		}
		session.setAttribute("admin", admin);
		mv.addObject("admin", admin);
		mv.setView(new MappingJackson2JsonView());
		return "forward:/admin/index.do";
	}
	
	// 更新用户信息
	// 没有考虑admin中提交的参数为null或""的情况
	// 只能用JSR 304注解去验证，然后将error message发送到前台
	@RequestMapping("/updateAdmin")
	public String updateAdmin(Admin admin) {
		ModelAndView mv = new ModelAndView();
		adminService.updateAdmin(admin);
		mv.addObject("admin", admin);
		return "forward:/admin/index.do";
	}

	// 上传头像
	@RequestMapping("/uploadProfilePic")
	public ModelAndView uploadProfilePic(@RequestParam(value = "picFile") MultipartFile multipartFile, Long id,
			@SessionAttribute("admin") Admin admin) {
		ModelAndView mv = new ModelAndView();
		if (multipartFile == null) {
			System.err.println("multipartFile is null !!!!");
		}
		// 获取原始文件名，避免中文，应当对文件名进行处理：
		String fileName = multipartFile.getOriginalFilename();
		multipartFile.getContentType();
		// 目标文件,destination file
		File dest = new File(fileName);
		try {
			// Transfer the received file to the given destination file
			multipartFile.transferTo(dest);
			// 存入路径到数据库
			adminService.updatePicpath("http://localhost:8080/pic/" + fileName, id);
			// 更改保存在session中的admin.picpath属性
			admin.setPicpath("http://localhost:8080/pic/" + fileName);
			mv.setViewName("admin/index");
		} catch (IllegalStateException | IOException e) {
			mv.addObject("success", false);
			mv.addObject("msg", "上传文件失败！");
			e.printStackTrace();
		}
		// mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	// 导出所有录入信息到Excel
	@RequestMapping("/exportInfoExcel")
	public ModelAndView exportInfoExcel() {
		ModelAndView mv = new ModelAndView();
		ExcelView ev = new ExcelView("info.xls", exportService());
		mv.setView(ev);
		return mv;
	}

	private ExcelUtil exportService() {
		return new ExcelUtil() {
			@Override
			public void makeWorkBook(Map<String, Object> model, Workbook workbook) {
				List<Information> infoList = infoService.findAll();
				// 创建sheet
				Sheet sheet = workbook.createSheet("录入信息");
				// 创建标题行,下标从0开始，第一行
				Row titleRow = sheet.createRow(0);
				// 设置标题行内容
				titleRow.createCell(0).setCellValue("id");
				titleRow.createCell(1).setCellValue("姓名");
				titleRow.createCell(2).setCellValue("学院");
				titleRow.createCell(3).setCellValue("手机");
				titleRow.createCell(4).setCellValue("QQ号码");
				titleRow.createCell(5).setCellValue("组向");
				titleRow.createCell(6).setCellValue("性别");
				titleRow.createCell(7).setCellValue("介绍");
				titleRow.createCell(8).setCellValue("专业");
				for (int i = 0; i < infoList.size(); i++) {
					Information info = infoList.get(i);
					int rowIndex = i + 1;
					// 创建第rowIndex行
					Row row = sheet.createRow(rowIndex);
					// 为第rowIndex行添加数据
					row.createCell(0).setCellValue(info.getId());
					row.createCell(1).setCellValue(info.getName());
					row.createCell(2).setCellValue(info.getInstitution());
					row.createCell(3).setCellValue(info.getPhone());
					row.createCell(4).setCellValue(info.getPhone());
					row.createCell(5).setCellValue(info.getGroup_());
					row.createCell(6).setCellValue(info.getSex());
					row.createCell(7).setCellValue(info.getIntroduction());
					row.createCell(8).setCellValue(info.getMajor());
				}
			}
		};
	}

	// 表单不带数据提交，用作两脚兽和其他跳转页面
	@RequestMapping("/pageForm")
	public String pageForm() {
		return "admin/login";
	}

	// 表单不带数据提交，用作两脚兽和其他跳转页面
	@RequestMapping("/pageForm2")
	public String pageForm2() {
		return "admin/login";
	}

}
