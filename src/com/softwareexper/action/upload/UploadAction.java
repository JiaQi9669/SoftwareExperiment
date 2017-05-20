package com.softwareexper.action.upload;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.softwareexper.tools.DateUtil;

public class UploadAction extends ActionSupport{

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

//	public String execute() throws Exception {
//		uploads();
//		return "success";
//	}

//	//上传
//	public String uploads() throws IOException{
//		addData();
//		return "upload";
//	}
//
//	//		保存到数据库
//	public String addData() throws IOException{
//		//			data_data datas=new data_data();
//		//			datas.setData_class(classService.findByName(claName).get(0));
//		//			datas.setDates(new Date());
//		//			datas.setFriends(getAdmins().getPickName());//getAdmins().getId().toString());
//		//			datas.setMessage(getModel().getMessage());
//		//			datas.setName(getModel().getName());
//		//			datas.setUrl_data(addFile()); 
//		//			datas.setDown_num(0);
//		//			dataService.save(datas);
//		System.out.println(addFile()+"+++++++++++++++++++++++");
//		return "data";
//	}

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
