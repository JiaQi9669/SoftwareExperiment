package com.softwareexper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftReport;
import com.softwareexper.service.SoftReportService;

@Service
@Transactional
public class SoftReportServiceImpl extends BaseDaoImpl<SoftReport> implements SoftReportService{
	@Override
	public List<SoftReport> findAllByDateShow() {
		return (List<SoftReport>)getSession().createQuery("FROM SoftReport n where n.view = true order by n.date desc").list();
	}
	@Override
	public List<SoftReport> findAllByDateUnShow() {
		return (List<SoftReport>)getSession().createQuery("FROM SoftReport n where n.view = false order by n.date desc").list();
	}
}
