package com.test.pojo;

import org.springframework.stereotype.Component;

/** 
* @ClassName: Role 
* @Description: 
* @author 王逍遥
* @date 2018.7.12 12:25:35 
*/
@Component
public class Role {
	private Integer id;
	private String roleName;
	private String note;
	public Role() {}
	public Role(Integer id,String roleName,String note) {
		this.id=id;
		this.roleName=roleName;
		this.note=note;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
