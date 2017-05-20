package com.softwareexper.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftDevice;
import com.softwareexper.service.SoftDeviceService;

@Service
@Transactional
public class SoftDeviceServiceImpl extends BaseDaoImpl<SoftDevice> implements SoftDeviceService{
	@Override
	public List<SoftDevice> findAllByDateShow() {
		return (List<SoftDevice>)getSession().createQuery("FROM SoftDevice n where n.view = true order by n.date desc").list();
	}
	@Override
	public List<SoftDevice> findAllByDateUnShow() {
		return (List<SoftDevice>)getSession().createQuery("FROM SoftDevice n where n.view = false order by n.date desc").list();
	}
}
