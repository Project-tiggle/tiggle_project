package com.ex.tiggle.orgregist.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.orgregist.model.dao.OrgregistDao;

@Service("orgregistService")
public class OrgregistServiceImpl implements OrgregistService {
	@Autowired
	private OrgregistDao orgregistDao;
}
