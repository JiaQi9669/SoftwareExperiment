package com.softwareexper.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwareexper.base.BaseDaoImpl;
import com.softwareexper.orm.SoftImg;
import com.softwareexper.service.SoftImgService;

@Service
@Transactional
public class SoftImgServiceImpl extends BaseDaoImpl<SoftImg> implements SoftImgService{

}
