package com.softwareexper.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.softwareexper.base.BaseAction;
import com.softwareexper.orm.SoftUser;

/**
 * 登录相关
 * @author 李志飞
 *
 */
public class UserAction extends BaseAction<SoftUser>{
	
	public String left(){
		return "left";
	}
	/*public String main(){
		SoftUser user = null;
		return "main";
	}*/
	public String top(){
		return "top";
	}
	public String index(){
		return "index";
	}
	public String toLogin(){
		return "toLogin";
	}
	
	public String login(){
		SoftUser user = null;
		try{
			user = softUserService.userLogin(getModel().getUsername(), getModel().getPassword());
			System.out.println(user.toString()+"================="+user.getRule());
		}catch (Exception e) {
			return "file";
		}
		if(null!=user){
			if(user.getPassword().equals(getModel().getPassword())){
				setAdmins(user);
				return "main";
			}else{
				return "file";
			}
		}
		return "file";
	}
	public String add(){
		return "add";
	}
	public String update(){
		return "update";
	}
	public String updatewrite(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		SoftUser user = (SoftUser) session.getAttribute("admins");
		user.setPassword(getModel().getPassword());
		softUserService.update(user);
		return "updatewrite";
	}
	public String addwrite(){
		SoftUser user = new SoftUser();
		user.setUsername(getModel().getUsername());
		user.setPassword(getModel().getPassword());
		System.out.println(user);
		softUserService.save(user);
		return "addwrite";
	}
}
