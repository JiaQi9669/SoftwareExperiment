package com.softwareexper.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;


/**
 * 用户地址
 * @author 李志飞
 *
 */
public class SoftUser implements java.io.Serializable {
	private Integer id;//id
	private String username;//用户名
	private String password;//密码
	private Date loginDate;//登录日期
	private String ipaddress;//登录ip
	private String tureName;//真实姓名
	private String rule;
	
	public SoftUser(){
	}
	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getTureName() {
		return tureName;
	}

	public void setTureName(String tureName) {
		this.tureName = tureName;
	}

	public String toString() {
		return "SoftUser [id=" + id + ", username=" + username + ", password="
				+ password + ", loginDate=" + loginDate + ", ipaddress="
				+ ipaddress + ", tureName=" + tureName + "]";
	}
	


	
	
	
}
