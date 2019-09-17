package com.test.controller;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.pojo.Role;
import com.test.service.ExcelExportService;
import com.test.service.RoleService;
import com.test.util.ExcelView;

//导出Excel视图
@Controller
public class ExcelViewController {

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView export(Model model) {
		ModelAndView mv = new ModelAndView();
		ExcelView ev = new ExcelView(exportService());
		ev.setFileName("AllRoles.xlsx");
		List<Role> roleList = roleService.findAll();
		mv.addObject("roleList", roleList);
		mv.setView(ev);
		return mv;
	}

	//lambda表达式代替匿名内部类
	@SuppressWarnings("unchecked")
	private ExcelExportService exportService() {
		//lambda语法：(parameters) -> expression；parameters表示接受的参数
		//此处返回的应是一个new ExcelExportService
		return (Map<String, Object> model,Workbook workbook) -> {
			List<Role> roleList = (List<Role>) model.get("roleList");
			//生成sheet
			Sheet sheet = workbook.createSheet("所有角色");
			//创建第一行标题行，下标为0
			Row title = sheet.createRow(0);
			//设置每一列标题的列名，总共三列，cell标号从0开始
			title.createCell(0).setCellValue("编号");
			title.createCell(1).setCellValue("名称");
			title.createCell(2).setCellValue("备注");
			//创建行，为每一行放入数据
			for (int i = 0; i < roleList.size(); i++) {
				Role role = roleList.get(i);
				int rowIdx = i + 1;
				//创建第rowIdx行
				Row row = sheet.createRow(rowIdx);
				row.createCell(0).setCellValue(role.getId());
				row.createCell(1).setCellValue(role.getRoleName());
				row.createCell(2).setCellValue(role.getNote());
			}
		};
	}

	//使用匿名内部类
//	@SuppressWarnings("unchecked")
//	private ExcelExportService exportService() {
//		return (new ExcelExportService() {
//			@Override
//			public void makeWorkBook(Map<String, Object> model, Workbook workbook) {
//				List<Role> roleList = (List<Role>) model.get("roleList");
//				//生成sheet
//				Sheet sheet = workbook.createSheet("所有角色");
//				//加载标题
//				Row title = sheet.createRow(0);
//				title.createCell(0).setCellValue("编号");
//				title.createCell(1).setCellValue("名称");
//				title.createCell(2).setCellValue("备注");
//				//
//				for (int i = 0; i < roleList.size(); i++) {
//					Role role = roleList.get(i);
//					int rowIdx = i + 1;
//					Row row = sheet.createRow(rowIdx);
//					row.createCell(0).setCellValue(role.getId());
//					row.createCell(1).setCellValue(role.getRoleName());
//					row.createCell(2).setCellValue(role.getNote());
//			}
//		}
//	});
//	}
}
