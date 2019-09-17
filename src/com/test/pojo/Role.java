package com.test.pojo;

public class Role {
	private int id;
	private String roleName;
	private String note;
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(int id,String roleName,String note) {
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
