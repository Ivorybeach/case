package com.zhitong.util;

import java.util.List;

//分页工具
public class PageParam {
	//当前页，默认为1
	private Integer currentPage=1;
	
	//每页显示的行数，默认为10
	private Integer pageCount=10;
	
	//总记录数
	private Integer totalCount;
	
	//总页数，总页数 = 总记录数/每页显示的行数（+1）
	private Integer totalPage;
	
	//分页查询到的数据
//	private List<T> data;

	public Integer getTotalPage() {
		if (totalCount % pageCount == 0) {
			totalPage = totalCount / pageCount;
		}else {
			totalPage = totalCount / pageCount + 1;
		}
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

//	public List<T> getData() {
//		return data;
//	}
//
//	public void setData(List<T> data) {
//		this.data = data;
//	}
	
	
}
