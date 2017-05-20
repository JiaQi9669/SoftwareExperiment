package com.softwareexper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftCenter;
import com.softwareexper.service.SoftCenterService;

@Service
@Transactional
public class SoftCenterServiceImpl extends BaseDaoImpl<SoftCenter> implements SoftCenterService{

	public List<SoftCenter> findAllByDateShow() {
		return (List<SoftCenter>)getSession().createQuery("FROM SoftCenter n where n.view = true order by n.date desc").list();
	}
	public List<SoftCenter> findAllByDateUnShow() {
		return (List<SoftCenter>)getSession().createQuery("FROM SoftCenter n where n.view = false order by n.date desc").list();
	}
	
}
