package com.softwareexper.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;



public class SoftImg implements java.io.Serializable {
	private Integer id;
	private String imgpath;
	private String name;
	
	
	public SoftImg(){
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getImgpath() {
		return imgpath;
	}


	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
