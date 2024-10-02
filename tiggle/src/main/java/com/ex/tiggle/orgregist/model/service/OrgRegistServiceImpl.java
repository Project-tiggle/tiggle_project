package com.ex.tiggle.orgregist.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.orgregist.model.dao.OrgRegistDao;

@Service("orgregistService")
public class OrgRegistServiceImpl implements OrgRegistService {
	@Autowired
	private OrgRegistDao orgregistDao;
}
