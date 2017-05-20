package com.softwareexper.service;

import java.util.List;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftLab;
import com.softwareexper.orm.SoftNews;

public interface SoftNewsService extends  BaseDao<SoftNews>{
	
	public List<SoftNews> findAllByDateShow();
	public List<SoftNews> findAllByDateUnShow();
	
}
