package com.zhitong.util;

import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

//必须使用接口
public interface ExcelUtil {

	//定义工作簿
	public void makeWorkBook(Map<String,Object> model,Workbook workbook);
	
}
