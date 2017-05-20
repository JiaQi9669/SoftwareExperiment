package com.softwareexper.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理端基础页面
 * @author 李志飞
 *
 */
public class AdminBaseAction extends ActionSupport{

	public String left(){
		return "left";
	}
	public String main(){
		return "main";
	}
	public String top(){
		return "top";
	}
	public String index(){
		return "index";
	}
	public String toLogin(){
		return "toLogin";
	}
	
}
