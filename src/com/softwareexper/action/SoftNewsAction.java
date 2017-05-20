package com.softwareexper.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.softwareexper.base.BaseAction;
import com.softwareexper.orm.SoftCenter;
import com.softwareexper.orm.SoftNews;
import com.softwareexper.orm.SoftReport;
import com.softwareexper.tools.HqlHelper;
import com.softwareexper.tools.PageBean;

public class SoftNewsAction extends BaseAction<SoftNews>{
	
//	后台部分**************************
//	添加新闻
	public String add() {
		return "add";
	}
//	更新新闻
	public String update() {
		selectPage(true);
		return "update";
	}
//	下架新闻
	public String history() {
		PageBean pageBean=softNewsService.getPageBean(pageNum,10, new HqlHelper(SoftNews.class, "news").
				addOrderByProperty("date", false).
				addWhereCondition("news.view = ?", false));
		pageBean.setCurrentPage(pageNum);
		ValueStack vs = ServletActionContext.getContext().getValueStack();
		vs.set("pageBean", pageBean);
		return "history";
	}
//	跳转修改界面
	public String inster(){
		SoftNews news = softNewsService.getById(getModel().getId());
		ActionContext.getContext().put("news",news);
		return "inster";
	}
//	修改信息
	public String insterwrite(){
		SoftNews news = softNewsService.getById(getModel().getId());
		news.setContext(getModel().getContext());
		news.setTitles(getModel().getTitles());
		try {
			if(!INPUT.equals(addFile())){
			news.setPath(addFile());
			}
		} catch (IOException e) {
			addFieldError("error", "上传失败！");
			return "inster";
//			e.printStackTrace();
		}
		System.out.println(news.getPath()+"--------------------------");
		softNewsService.update(news);
		update();
		return "update";
	}
	
//	前端相关****************************************
//	分页查询-
	private void selectPage(boolean isview){
		PageBean pageBean=softNewsService.getPageBean(pageNum,10, new HqlHelper(SoftNews.class, "center").
				addOrderByProperty("date", false).
				addWhereCondition("center.view = ?", isview));
		pageBean.setCurrentPage(pageNum);
		ValueStack vs = ServletActionContext.getContext().getValueStack();
		vs.set("pageBean", pageBean);
	}
//	获取指定id对象
	public String view() {
		List<SoftNews> list;
		if(softNewsService.getById(getModel().getId()).isView()){
			list=softNewsService.findAllByDateShow();
		}else{
			list=softNewsService.findAllByDateUnShow();
		}
		return viewdeal(list);
	}
	
	private String viewdeal(List<SoftNews>list){
		SoftNews[]news=new SoftNews[3];
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
	
//	设置为显示
	public String show(){
		SoftNews n=softNewsService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(true);
		n.setCount(n.getCount()+1);
		softNewsService.update(n);
		
		selectPage(true);
		return "update";
	}
	
//	设置为不显示
	public String unshow(){
		SoftNews n=softNewsService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(false);
		n.setCount(n.getCount()+1);
		softNewsService.update(n);
		
		selectPage(false);
		return "history";
	}
	
//	添加浏览量
	private void countadd(){
		SoftNews n=softNewsService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(n.isView());
		n.setCount(n.getCount()+1);
		softNewsService.update(n);
	}
	
//	写入数据
	public String write() {
		SoftNews news=new SoftNews();
		news.setTitles(getModel().getTitles());
		System.out.println(getModel().getTitles());
		news.setContext(getModel().getContext());
		System.out.println(getModel().getContext());
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
		System.out.println(news.getPath()+"--------------------------");
		softNewsService.save(news);
		update();
		return "update";
	}
	
	public String index() {
		selectPage(true);
		return "index";
	}
	
}
