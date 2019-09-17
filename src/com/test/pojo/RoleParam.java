package com.test.pojo;
/** 
* @ClassName: RoleParam 
* @Description: role参数的封装pojo,带一个分页参数
* @author 王逍遥
* @date 2018年7月21日 上午10:30:47 
*/
public class RoleParam {
	private String roleName;
	private String note;
	private PageParams pageParams;
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
	public PageParams getPageParams() {
		return pageParams;
	}
	public void setPageParams(PageParams pageParams) {
		this.pageParams = pageParams;
	}
	
	
}
