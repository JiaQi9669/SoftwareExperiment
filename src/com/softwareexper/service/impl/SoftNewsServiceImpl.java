package com.softwareexper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftNews;
import com.softwareexper.service.SoftNewsService;

@Service
@Transactional
public class SoftNewsServiceImpl extends BaseDaoImpl<SoftNews> implements SoftNewsService{

	@Override
	public List<SoftNews> findAllByDateShow() {
		return (List<SoftNews>)getSession().createQuery("FROM SoftNews n where n.view = true order by n.date desc").list();
	}
	@Override
	public List<SoftNews> findAllByDateUnShow() {
		return (List<SoftNews>)getSession().createQuery("FROM SoftNews n where n.view = false order by n.date desc").list();
	}
	
}
