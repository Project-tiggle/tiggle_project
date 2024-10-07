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
	
	@Override
	public int updateMember(OrgRegist orgRegist) {
		return orgRegistDao.updateMember(orgRegist);
	}

	@Override
	public OrgRegist selectOrgRegistByUuid(String uuid) {
		return orgRegistDao.selectOrgRegistByUuid(uuid);
	}

	@Override
	public int updateOrgRegist(OrgRegist orgRegist) {
		 return orgRegistDao.updateOrgRegist(orgRegist);
	}

	@Override
	public int deleteOrgRegist(String totalId) {
		return orgRegistDao.deleteOrgRegist(totalId);
	}

	@Override
	public int selectMaxTotalId() {
		return orgRegistDao.selectMaxTotalId();
	}

}
