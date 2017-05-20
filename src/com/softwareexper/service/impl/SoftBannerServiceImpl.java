package com.softwareexper.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftBanner;
import com.softwareexper.service.SoftBannerService;
@Service
@Transactional
public class SoftBannerServiceImpl extends BaseDaoImpl<SoftBanner> implements SoftBannerService{

}
