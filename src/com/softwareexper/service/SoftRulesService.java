package com.softwareexper.service;

import java.util.List;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftRules;
import com.softwareexper.orm.SoftTeacher;

public interface SoftRulesService extends BaseDao<SoftRules>{
	public List<SoftRules> findAllByDateShow();
	public List<SoftRules> findAllByDateUnShow();
}
