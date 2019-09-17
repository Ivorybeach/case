package com.test.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.test.pojo.Validation;

//Validator为spring提供的验证器，可以用于复杂逻辑校验
public class TransactionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//要验证的类
		return Validation.class.equals(clazz);

	}
 
	//验证逻辑
	@Override
	public void validate(Object obj, Errors errors) {
		Validation va = (Validation) obj;
		System.out.println(va.getAmount());
		System.out.println(va.getPrice());
		System.out.println(va.getQuantity());
		//dis = amount-price*quantity
		double dis = va.getAmount() - va.getPrice() * va.getQuantity();
		//如果差值dis大于0.01，则认为错误
		if (Math.abs(dis) > 0.01) {
			//加入错误信息
			//rejectValue("field","errorCode","message")在field范围内加入rejectValue;field必须是验证类Validation中的字段
			errors.rejectValue("amount", "303","交易金额和购买数量与价格不匹配");
		}
	}

}
