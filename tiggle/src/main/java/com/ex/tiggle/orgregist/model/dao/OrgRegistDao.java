package com.ex.tiggle.orgregist.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.orgregist.model.dto.OrgRegist;

@Repository("orgregistDao")
public class OrgRegistDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertOrgRegist(OrgRegist orgRegist) {
		return sqlSessionTemplate.insert("orgRegistMapper.insertOrgRegist", orgRegist);
	}
	
	public int updateMember(OrgRegist orgRegist) {
		return sqlSessionTemplate.update("orgRegistMapper.updateMember", orgRegist);
	}
	
	public OrgRegist selectOrgRegistByUuid(String uuid) {
        return sqlSessionTemplate.selectOne("orgRegistMapper.selectOrgRegistByUuid", uuid);
    }

    public int updateOrgRegist(OrgRegist orgRegist) {
        return sqlSessionTemplate.update("orgRegistMapper.updateOrgRegist", orgRegist);
    }

    public int deleteOrgRegist(String totalId) {
        return sqlSessionTemplate.delete("orgRegistMapper.deleteOrgRegist", totalId);
    }

	public int selectMaxTotalId() {
		return sqlSessionTemplate.selectOne("orgRegistMapper.selectMaxTotalId");
	}

	public int selectListCount(String uuid) {
		return sqlSessionTemplate.selectOne("orgRegistMapper.selectListCount", uuid);
	}

	public ArrayList<OrgRegist> selectList(Map<String, Object> uuidNpaging) {
		List<OrgRegist> list = sqlSessionTemplate.selectList("orgRegistMapper.selectList", uuidNpaging);
		return (ArrayList<OrgRegist>)list; 
	}

	public OrgRegist selectOrgTotalId(String num) {
		return sqlSessionTemplate.selectOne("orgRegistMapper.selectOrgTotalId", num);
	}

	public int selectApCount() {
		return sqlSessionTemplate.selectOne("orgRegistMapper.selectApCount");
	}

	public ArrayList<OrgRegist> selectApList(Paging paging) {
		List<OrgRegist> list = sqlSessionTemplate.selectList("orgRegistMapper.selectApList", paging);
		return (ArrayList<OrgRegist>)list;
	}

	public int apStatusYn(String totalId) {
		return sqlSessionTemplate.update("orgRegistMapper.apStatusYn", totalId);
	}

	public ArrayList<OrgRegist> selectLocation() {
		List<OrgRegist> list = sqlSessionTemplate.selectList("orgRegistMapper.selectLocation");
		return (ArrayList<OrgRegist>)list;
	}

	public int updateLocation(OrgRegist orgRegist) {
		return sqlSessionTemplate.update("orgRegistMapper.updateLocation", orgRegist);
	}

	public int updateApiApprovalY() {
		return sqlSessionTemplate.update("orgRegistMapper.updateApiApprovalY");
	}

	public int updateNotNull() {
		return sqlSessionTemplate.update("orgRegistMapper.updateNotNull");
	}

}
