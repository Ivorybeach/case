package com.test.service;

import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

//生成excel文件规则
@Service
public interface ExcelExportService {
	public void makeWorkBook(Map<String, Object> model,Workbook workbook);
}
