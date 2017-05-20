package com.softwareexper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftNews;
import com.softwareexper.orm.SoftTeacher;
import com.softwareexper.service.SoftTeacherService;

@Service
@Transactional
public class SoftTeacherServiceImpl extends BaseDaoImpl<SoftTeacher> implements SoftTeacherService{
	@Override
	public List<SoftTeacher> findAllByDateShow() {
		return (List<SoftTeacher>)getSession().createQuery("FROM SoftTeacher n where n.view = true order by n.date desc").list();
	}
	@Override
	public List<SoftTeacher> findAllByDateUnShow() {
		return (List<SoftTeacher>)getSession().createQuery("FROM SoftTeacher n where n.view = false order by n.date desc").list();
	}
}
