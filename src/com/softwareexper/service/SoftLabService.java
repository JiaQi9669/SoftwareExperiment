package com.softwareexper.service;

import java.util.List;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftLab;
import com.softwareexper.orm.SoftNews;

public interface SoftLabService extends BaseDao<SoftLab>{
	public List<SoftLab> findAllByDateShow();
	public List<SoftLab> findAllByDateUnShow();
}
