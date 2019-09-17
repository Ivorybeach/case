package com.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//日期类型转换器,Converter接口是spring-core项目提供的
public class StringToDateConverter implements Converter<String,Date>{

	/*这里已经使用@InitBinder和@ControllerAdvice拦截HTTP参数，下面的转换器注释掉
	 */
	@Override
	public Date convert(String source) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			//parse(String str)，将str转换成具体形式的date
//			Date date = simpleDateFormat.parse(source);
//			return date;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return null;
	}

}
