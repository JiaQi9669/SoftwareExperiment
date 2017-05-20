package com.softwareexper.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.softwareexper.base.BaseAction;
import com.softwareexper.orm.SoftCenter;
import com.softwareexper.orm.SoftCenter;
import com.softwareexper.orm.SoftNews;
import com.softwareexper.tools.HqlHelper;
import com.softwareexper.tools.PageBean;

/**
 * 中心概括
 * @author 李志飞
 *
 */
public class SoftCenterAction extends BaseAction<SoftCenter>{

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
	
//	进入修改信息
	public String inster(){
		SoftCenter center = softCenterService.getById(getModel().getId());
		ActionContext.getContext().put("center",center);
		return "inster";
	}
//	修改信息
	public String newwrite(){
		SoftCenter center = softCenterService.getById(getModel().getId());
		center.setContext(getModel().getContext());
		center.setTitles(getModel().getTitles());
		softCenterService.update(center);
		update();
		return "update";
	}
	
//	显示详情--附带前后展示
	public String view() {
		List<SoftCenter> list;
		if(getModel().getId()!=null){
			if(softCenterService.getById(getModel().getId()).isView()){
				list=softCenterService.findAllByDateShow();
			}else{
				list=softCenterService.findAllByDateUnShow();
			}
		}else{
			list=softCenterService.findAllByDateShow();
		}
		return viewdeal(list);
	}
//	
	private String viewdeal(List<SoftCenter> list){
		SoftCenter[]news=new SoftCenter[3];
		if(getModel().getId()!=null){
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
		}else{
			ActionContext.getContext().put("beans",list.get(0));
			ActionContext.getContext().put("up",list.get(0));
			ActionContext.getContext().put("down",list.get(1));
			return "view";
		}
		ActionContext.getContext().put("beans",null);
		ActionContext.getContext().put("up",null);
		ActionContext.getContext().put("down",null);
		return "view";
	}
//	添加浏览量
	private void countadd(){
		SoftCenter n=softCenterService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(n.isView());
		n.setCount(n.getCount()+1);
		n.setPath(n.getPath());
		softCenterService.update(n);
	}
	
//	分页查询-
	private void selectPage(boolean isview){
		PageBean pageBean=softCenterService.getPageBean(pageNum,10, new HqlHelper(SoftCenter.class, "center").
				addOrderByProperty("date", false).
				addWhereCondition("center.view = ?", isview));
		pageBean.setCurrentPage(pageNum);
		ValueStack vs = ServletActionContext.getContext().getValueStack();
		vs.set("pageBean", pageBean);
	}
	
//	设置为显示
	public String show(){
		SoftCenter n=softCenterService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(true);
		n.setCount(n.getCount()+1);
		n.setPath(n.getPath());
		softCenterService.update(n);
		
		selectPage(true);
		return "update";
	}
	
//	设置为不显示
	public String unshow(){
		SoftCenter n=softCenterService.getById(getModel().getId());
		n.setId(n.getId());
		n.setTitles(n.getTitles());
		n.setDate(n.getDate());
		n.setContext(n.getContext());
		n.setView(false);
		n.setCount(n.getCount()+1);
		n.setPath(n.getPath());
		softCenterService.update(n);
		
		selectPage(false);
		return "history";
	}
	
//	写入数据
	public String write() {
		SoftCenter news=new SoftCenter();
		news.setTitles(getModel().getTitles());
		news.setContext(getModel().getContext());
		news.setDate(new Date());
		news.setView(true);
		news.setCount(0);
		news.setPath(null);//暂时为空
		softCenterService.save(news);
		update();
		return "update";
	}
	/**
	 * 王志汤：首部
	 * @return
	 */
	//前端界面连接
	public String indexs(){
		view();
		selectPage(true);
		return "indexs";
	}
	//查找信息
	public String finds(){
		view();
		selectPage(true);
		return "indexs";
	}
}
