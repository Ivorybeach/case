package com.test.util;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.test.service.ExcelExportService;

//Excel视图类
public class ExcelView extends AbstractXlsView{

	//excel文件名
	private String fileName;
	
	//封装excel视图的生成规则
	private ExcelExportService excelExportService;
	
	//此构造方法用于生成excel视图，而参数excelExportService中封装了excel视图的生成规则
	public ExcelView(ExcelExportService excelExportService) {
		this.excelExportService=excelExportService;
	}
	
	public ExcelView(String fileName,ExcelExportService excelExportService) {
		this.fileName=fileName;
		this.excelExportService=excelExportService;
	}
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (excelExportService==null) {
			throw new RuntimeException("导出服务接口不能为null");
		}
		//文件名不能为空，为空则使用请求路径中的字符串为名
		if (!StringUtils.isEmpty(fileName)) {
			System.out.println("文件名为空");
		}
		
		excelExportService.makeWorkBook(model, workbook);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ExcelExportService getExcelExportService() {
		return excelExportService;
	}

	public void setExcelExportService(ExcelExportService excelExportService) {
		this.excelExportService = excelExportService;
	}
	
	
}
