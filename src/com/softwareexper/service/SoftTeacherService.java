package com.softwareexper.service;

import java.util.List;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftLab;
import com.softwareexper.orm.SoftTeacher;

public interface SoftTeacherService extends BaseDao<SoftTeacher>{
	public List<SoftTeacher> findAllByDateShow();
	public List<SoftTeacher> findAllByDateUnShow();
}
