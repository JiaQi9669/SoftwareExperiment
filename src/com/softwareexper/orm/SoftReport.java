package com.softwareexper.orm;

import java.util.Date;

public class SoftReport implements java.io.Serializable{
	private Integer id;//id
	private String titles;//标题
	private String context;//内容
	private String path;//文件路径
	private Date date;//日期
	private Integer count;//浏览量
	private boolean view =true;//0显示 1不显示
	
	public SoftReport() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}
	
	public String getTitles() {
		return titles;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}
}
