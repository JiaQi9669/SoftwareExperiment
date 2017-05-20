package com.softwareexper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftLab;
import com.softwareexper.orm.SoftNews;
import com.softwareexper.service.SoftLabService;

@Service
@Transactional
public class SoftLabServiceImpl extends BaseDaoImpl<SoftLab> implements SoftLabService{
	@Override
	public List<SoftLab> findAllByDateShow() {
		return (List<SoftLab>)getSession().createQuery("FROM SoftLab n where n.view = true order by n.date desc").list();
	}
	@Override
	public List<SoftLab> findAllByDateUnShow() {
		return (List<SoftLab>)getSession().createQuery("FROM SoftLab n where n.view = false order by n.date desc").list();
	}
}
