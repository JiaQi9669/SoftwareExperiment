package com.softwareexper.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.softwareexper.base.BaseAction;
import com.softwareexper.orm.SoftRules;
import com.softwareexper.tools.HqlHelper;
import com.softwareexper.tools.PageBean;

/**
 * 实验教学
 * @author 李志飞
 *
 */
public class SoftRuleAction extends BaseAction<SoftRules>{

//	中心概括添加
	public String add() {
		return "add";
	}
	
//	更新
	public String update() {
		selectPage(true);
		return "update";
	}
	
//	历史
	public String history() {
		selectPage(false);
		return "history";
	}
	
//	显示详情--附带前后展示
	public String view() {
		List<SoftRules> list;
		if(softRulesService.getById(getModel().getId()).isView()){
			list=softRulesService.findAllByDateShow();
		}else{
			list=softRulesService.findAllByDateUnShow();
		}
		return viewdeal(list);
	}
//	
	private String viewdeal(List<SoftRules> list){
		SoftRules[]news=new SoftRules[3];
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==getModel().getId()){
				if(i-1>=0){
					news[0]=list.get(i-1);
				}else{
					news[0]=null;
				}
				news[1]=list.get(i);
				if(i+1<list.size()){
					news[2]=list.get(i+1);
				}else{
					news[2]=null;
				}
				ActionContext.getContext().put("beans",news[1]);
				ActionContext.getContext().put("up",news[0]);
				ActionContext.getContext().put("down",news[2]);
				countadd();
				return "view";
			}
		}
		ActionContext.getContext().put("beans",null);
		ActionContext.getContext().put("up",null);
		ActionContext.getContext().put("down",null);
		return "view";
	}
//	添加浏览量
	private void countadd(){
		SoftRules n=softRulesService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(n.isView());
		n.setCount(n.getCount()+1);
		n.setPath(n.getPath());
		softRulesService.update(n);
	}
	
//	分页查询
	private void selectPage(boolean isview){
		PageBean pageBean=softRulesService.getPageBean(pageNum,10, new HqlHelper(SoftRules.class, "center").
				addOrderByProperty("date", false).
				addWhereCondition("center.view = ?", isview));
		pageBean.setCurrentPage(pageNum);
		ValueStack vs = ServletActionContext.getContext().getValueStack();
		vs.set("pageBean", pageBean);
	}
	
//	设置为显示
	public String show(){
		SoftRules n=softRulesService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(true);
		n.setCount(n.getCount()+1);
		n.setPath(n.getPath());
		softRulesService.update(n);
		
		selectPage(true);
		return "update";
	}
	
//	设置为不显示
	public String unshow(){
		SoftRules n=softRulesService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(false);
		n.setCount(n.getCount()+1);
		n.setPath(n.getPath());
		softRulesService.update(n);
		
		selectPage(false);
		return "history";
	}
//	跳转修改页面
	public String inster(){
		SoftRules rules = softRulesService.getById(getModel().getId());
		ActionContext.getContext().put("rules",rules);
		return "inster";
	}
	
//	修改信息
	public String insterwrite(){
		SoftRules rules = softRulesService.getById(getModel().getId());
		rules.setTitles(getModel().getTitles());
		rules.setContext(getModel().getContext());
		try {
			if(!INPUT.equals(addFile())){
			rules.setPath(addFile());
			}
		} catch (IOException e) {
			addFieldError("error", "上传失败！");
			return "inster";
		}
		softRulesService.update(rules);
		update();
		return "update";
	}
	
//	写入数据
	public String write() {
		SoftRules news=new SoftRules();
		news.setTitles(getModel().getTitles());
		news.setContext(getModel().getContext());
		news.setDate(new Date());
		news.setView(true);
		news.setCount(0);
		try {
			news.setPath(addFile());
		} catch (IOException e) {
			addFieldError("error", "上传失败！");
			return "write";
//			e.printStackTrace();
		}
		softRulesService.save(news);
		update();
		return "update";
	}
	
	public String all(){
		selectPage(true);
		return "all";
	}
	public String desc(){
		view();
		return "desc";
	}
}
