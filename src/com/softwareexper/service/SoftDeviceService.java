package com.softwareexper.service;

import java.util.List;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftDevice;

public interface SoftDeviceService extends BaseDao<SoftDevice>{
	public List<SoftDevice> findAllByDateShow();
	public List<SoftDevice> findAllByDateUnShow();
}
