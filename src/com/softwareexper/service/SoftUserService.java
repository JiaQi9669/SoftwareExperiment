package com.softwareexper.service;

import com.softwareexper.base.BaseDao;
import com.softwareexper.orm.SoftUser;

public interface SoftUserService extends BaseDao<SoftUser>{

	SoftUser userLogin(String username,String password);
}
