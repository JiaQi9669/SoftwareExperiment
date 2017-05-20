package com.softwareexper.service;

import java.util.List;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftReport;

public interface SoftReportService extends BaseDao<SoftReport>{
	public List<SoftReport> findAllByDateShow();
	public List<SoftReport> findAllByDateUnShow();
}
