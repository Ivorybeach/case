package com.test.pojo;


import java.util.Date;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/** 
* @ClassName: Validation 
* @Description: 测试JSR303注解验证pojo
* @author 王逍遥
* @date 2018年8月1日 上午8:25:48 
*/

public class Validation {
	@NotNull(message="编号不可为空！")
	private Long id;
	
	
	@Future	//只能是将来日期
	//要求前台的日期格式必须是"yyyy-MM-dd"形式，才能将前台的string请求，转换为java的Date类型
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	
	@NotNull(message="价格不可为空！")
	private Double price;
	
	@Pattern(regexp="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message="邮箱格式错误！")
	private String email;

	@NotNull(message="数量不可为空！")
	private Integer quantity;
	
	@DecimalMin(value="0.1")//最小0.1
	@DecimalMax(value="2000.0")//最大2000
	private Double amount;
	
	@NotNull
	@Size(min=1,max=3)
	private String note;
	
	@NotNull(message="号码不可为空！")
	@Pattern(regexp="^[1][3,4,5,7,8][0-9]{9}$",message="手机号码格式错误！")
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

	
}
