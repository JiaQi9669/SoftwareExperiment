package com.softwareexper.service;

import java.util.List;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftCenter;
import com.softwareexper.orm.SoftNews;

public interface SoftCenterService extends  BaseDao<SoftCenter>{
	public List<SoftCenter> findAllByDateShow();
	public List<SoftCenter> findAllByDateUnShow();
}
