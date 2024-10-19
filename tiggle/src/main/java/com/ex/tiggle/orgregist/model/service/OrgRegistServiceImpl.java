package com.ex.tiggle.orgregist.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.orgregist.model.dao.OrgRegistDao;
import com.ex.tiggle.orgregist.model.dto.OrgRegist;

@Service("orgRegistService")
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

	@Override
	public int selectListCount(String uuid) {
		return orgRegistDao.selectListCount(uuid);
	}

	@Override
	public ArrayList<OrgRegist> selectList(Map<String, Object> uuidNpaging) {
		return orgRegistDao.selectList(uuidNpaging);
	}

	@Override
	public OrgRegist selectOrgTotalId(String num) {
		return orgRegistDao.selectOrgTotalId(num);
	}

	@Override
	public int selectApCount() {
		return orgRegistDao.selectApCount();
	}

	@Override
	public ArrayList<OrgRegist> selectApList(Paging paging) {
		return orgRegistDao.selectApList(paging);
	}

	@Override
	public int updateApStatusYn(String totalId) {
		return orgRegistDao.updateApStatusYn(totalId);
	}

	@Override
	public ArrayList<OrgRegist> selectLocation() {
		return orgRegistDao.selectLocation();
	}

	@Override
	public int updateLocation(OrgRegist orgRegist) {
		return orgRegistDao.updateLocation(orgRegist);
	}

	@Override
	public int updateApiApprovalY() {
		return orgRegistDao.updateApiApprovalY();
		
	}

	@Override
	public int updateNotNull() {
		return orgRegistDao.updateNotNull();
	}

}
