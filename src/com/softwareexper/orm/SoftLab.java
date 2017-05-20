package com.softwareexper.orm;

import java.util.Date;

public class SoftLab implements java.io.Serializable{
//	id
	private Integer id;
//	标题名
	private String titles;
//	内容
	private String context;
//	发布时间
	private Date date;
//	是否显示
	private boolean view =true;//0显示 1不显示
//	浏览量
	private Integer count;
//	图片URL
//	private String image;
	
	public SoftLab() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public void setView(boolean view) {
		this.view = view;
	}
	
	public boolean isView() {
		return view;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
}
