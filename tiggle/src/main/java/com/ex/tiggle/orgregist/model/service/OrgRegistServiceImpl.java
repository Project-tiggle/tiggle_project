package com.ex.tiggle.orgregist.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.orgregist.model.dao.OrgRegistDao;
import com.ex.tiggle.orgregist.model.dto.OrgRegist;

@Service
public class OrgRegistServiceImpl implements OrgRegistService {

    @Autowired
    private OrgRegistDao orgRegistDao;

	@Override
	public int insertOrgRegist(OrgRegist orgRegist) {
		return orgRegistDao.insertOrgRegist(orgRegist);
	}

}
