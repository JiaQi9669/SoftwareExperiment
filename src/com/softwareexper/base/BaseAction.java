package com.softwareexper.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.softwareexper.orm.SoftUser;
import com.softwareexper.service.SoftBannerService;
import com.softwareexper.service.SoftCenterService;
import com.softwareexper.service.SoftDeviceService;
import com.softwareexper.service.SoftImgService;
import com.softwareexper.service.SoftLabService;
import com.softwareexper.service.SoftNewsService;
import com.softwareexper.service.SoftReportService;
import com.softwareexper.service.SoftRulesService;
import com.softwareexper.service.SoftTeacherService;
import com.softwareexper.service.SoftUserService;
import com.softwareexper.tools.DateUtil;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	protected T model;
	public BaseAction(){
		try{
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			model = clazz.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	protected int pageNum = 1;

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	//获取模型驱动
	public T getModel(){
		return model;
	}
	
//	全局变量用以接收用户信息
	protected SoftUser getAdmins() {
		return (SoftUser)ActionContext.getContext().getSession().get("admins");
	}
	protected void setAdmins(SoftUser admins) {
//		ActionContext.getContext().getSession().clear();
		ActionContext.getContext().getSession().put("admins", admins);
	}
	
	
	/**
	 * 注入所有的service
	 */
	@Resource
	protected SoftUserService softUserService;
	@Resource
	protected SoftBannerService softBannerService;
	@Resource
	protected SoftImgService softImgService;
	@Resource
	protected SoftNewsService softNewsService;
	@Resource
	protected SoftCenterService softCenterService;
	@Resource
	protected SoftLabService softLabService;
	@Resource
	protected SoftTeacherService teacherService;
	@Resource
	protected SoftReportService softReportService;
	@Resource
	protected SoftRulesService softRulesService;
	@Resource
	protected SoftDeviceService softDeviceService;
	
	
//	文件上传*********************************
//	接收的添加文件属性**************************************************
	protected String userName;
	public void setUserName(String userName){
		this.userName = userName;
	}
	// 对应表单：<input type="file" name="file">
	protected File file;
	public void setFile(File file) {
		this.file = file;
	}
	// 文件名
	protected String fileFileName;
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	// 文件的类型(MIME)
	protected String fileContentType;
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	//		添加功能，添加成功返回path路径，否则返回null
	
	/**
	 * 图片添加功能
	 * @return
	 * @throws IOException
	 */
	protected String addFile() throws IOException{
		String filalPath;
		File destFile = null;

		// 获取上传的目录路径
		String path = ServletActionContext.getServletContext().getRealPath("/uploads/files");
		// 创建目标文件对象
		if(!"".equals(userName)&&!(userName==null)){//带有文件命名上传的情况下
			String types;
			try{
				String[] tempType=fileFileName.split("\\.");
				types=tempType[tempType.length-1];
			}catch (NullPointerException e) {
				addFieldError("nullfile", "未提交数据，请选择！");
				return INPUT;
			}
			//				检查文件重名
			userName=checkFile(userName,new File(path));

			destFile = new File(path,userName+"."+types);
			filalPath=userName+"."+types;

		}else{//上传的未命名文件
			try{
				if(!fileFileName.equals("")&&fileFileName!=null){//默认名称
					//						检测文件重名
					fileFileName=checkFile(fileFileName,new File(path));

					destFile = new File(path,fileFileName);
					filalPath=fileFileName;
				}else{
					throw new NullPointerException();
				}
			}catch (NullPointerException e) {
				addFieldError("nullfile", "未提交数据，请选择！");
				return INPUT;
			}
		}
		// 把上传的文件，拷贝到目标文件中
		FileUtils.copyFile(file, destFile);
		return filalPath;
	}

	/**
	 * 检查文件是否重名，重名再加表示
	 * @param filename
	 * @param rootfile
	 * @return
	 */
	protected String checkFile(String filename,File rootfile){
		
		String[] files=rootfile.list();
		for(String str:files){
			String temp=str.split("\\.")[0];
			if(temp.equals(filename)){
				return filename+DateUtil.getDateUUID();
			}
		}
		return filename;
	}
}
