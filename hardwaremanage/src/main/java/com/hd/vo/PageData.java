package com.hd.vo;

import java.io.Serializable;
import java.util.List;

public class PageData<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<T> data;
	private long iTotalDisplayRecords; //过滤后记录数
	private long iTotalRecords; //返回总记录数
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public long getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	
	
}
