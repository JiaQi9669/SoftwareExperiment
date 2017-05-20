package com.softwareexper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftRules;
import com.softwareexper.orm.SoftTeacher;
import com.softwareexper.service.SoftRulesService;

@Service
@Transactional
public class SoftRulesImpl extends BaseDaoImpl<SoftRules> implements SoftRulesService{
	@Override
	public List<SoftRules> findAllByDateShow() {
		return (List<SoftRules>)getSession().createQuery("FROM SoftRules n where n.view = true order by n.date desc").list();
	}
	@Override
	public List<SoftRules> findAllByDateUnShow() {
		return (List<SoftRules>)getSession().createQuery("FROM SoftRules n where n.view = false order by n.date desc").list();
	}
}
