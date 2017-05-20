package com.softwareexper.action.views;

import org.apache.poi.ss.formula.functions.T;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.softwareexper.base.BaseAction;
import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftCenter;
import com.softwareexper.orm.SoftDevice;
import com.softwareexper.orm.SoftLab;
import com.softwareexper.orm.SoftNews;
import com.softwareexper.orm.SoftReport;
import com.softwareexper.orm.SoftRules;
import com.softwareexper.orm.SoftTeacher;
import com.softwareexper.tools.HqlHelper;
import com.softwareexper.tools.PageBean;

public class SoftIndexAction extends BaseAction<SoftRules>{
	
//	首页
	public String index() {
		view();
		return "index";
	}
	
//	中兴概括
	public String centre() {
		return "centre";
	}
	
//	新闻
	public String news() {
		return "news";
	}
	
//	实验教学
	public String labs() {
		return "labs";
	}
	
//	规章制度
	public String rule() {
		return "rule";
	}
	
//	设备器材
	public String device() {
		return "device";
	}
	
//	申报材料
	public String report() {
		return "report";
	}
	
//	师资队伍
	public String teacher() {
		return "teacher";
	}
	
//	后台管理-登录**************
	public String login() {
		return "login";
	}
	
//	首页数据
	public String view(){
		ValueStack vs = ServletActionContext.getContext().getValueStack();
		
		vs.set("pageBeanNews", bean(softNewsService,SoftNews.class));
//		vs.set("pageBeanCenters", bean(softCenterService,SoftCenter.class));
		vs.set("pageBeanLabs", bean(softLabService,SoftLab.class));
		vs.set("pageBeanRules", bean(softRulesService,SoftRules.class));
		vs.set("pageBeanDevices", bean(softDeviceService,SoftDevice.class));
		vs.set("pageBeanReports", bean(softReportService,SoftReport.class));
//		vs.set("pageBeanTeachers", bean(teacherService,SoftTeacher.class));
		return "view";
	}
	
//	通用分页
	private PageBean bean(BaseDao baseDao,Class clazz){
		PageBean pageBean=baseDao.getPageBean(pageNum, 10,new HqlHelper(clazz, "n").
				addOrderByProperty("date", false).
				addWhereCondition("n.view = ?", true));
		pageBean.setCurrentPage(pageNum);
		return pageBean;
	}
	
	public String exit() {
		return "exit";
	}
	
}
