package com.zhitong.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.zhitong.pojo.Information;
import com.zhitong.service.InfoService;

//定义excel视图类
public class ExcelView extends AbstractXlsView{

	@Autowired
	InfoService infoService;
	
	private String fileName;
	
	private ExcelUtil excelUtil;
	
	public ExcelView() {
	}
	public ExcelView(ExcelUtil excelUtil) {
		this.excelUtil=excelUtil;
	}
	public ExcelView(String fileName,ExcelUtil excelUtil) {
		this.fileName=fileName;
		this.excelUtil=excelUtil;
	}
	
	//构建excel文档
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.addHeader("Content-Disposition","attachment;filename="+fileName);
		excelUtil.makeWorkBook(model, workbook);
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ExcelUtil getExcelUtil() {
		return excelUtil;
	}
	public void setExcelUtil(ExcelUtil excelUtil) {
		this.excelUtil = excelUtil;
	}
	
}
