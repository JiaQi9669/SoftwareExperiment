package com.softwareexper.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftUser;
import com.softwareexper.service.SoftUserService;
@Service
@Transactional
public class SoftUserServiceImpl extends BaseDaoImpl<SoftUser> implements SoftUserService{
	public SoftUser userLogin(String username, String password) {
		String hql ="FROM SoftUser s WHERE s.username=? AND s.password=?";
		return (SoftUser) getSession().createQuery(hql).setParameter(0, username).setParameter(1, password).uniqueResult();
	}
}
