package com.zhitong.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Information implements Serializable{
    /**
	 * 使用JSR303注解
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message="姓名不可为空！")
    private String name;
	
	@NotNull(message="院系不可为空！")
    private String institution;

	@Pattern(regexp="^[1][3,4,5,7,8][0-9]{9}$",message="手机号码格式错误！")
	@NotNull(message="手机号码不可为空！")
    private String phone;
	
	@Pattern(regexp="[1-9][0-9]{4,}",message="QQ号码格式错误！")
	@NotNull(message="QQ不可为空！")
    private String qq;

    private String group_;

    private String sex;

    private String introduction;

    @NotNull(message="专业不可为空！")
    private String major;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }


    public String getGroup_() {
		return group_;
	}

	public void setGroup_(String group_) {
		this.group_ = group_;
	}

	public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }
}