package com.ex.tiggle.orgregist.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        return sqlSessionTemplate.selectOne("selectOrgRegistByUuid", uuid);
    }

    // 데이터를 수정하는 메서드
    public int updateOrgRegist(OrgRegist orgRegist) {
        return sqlSessionTemplate.update("updateOrgRegist", orgRegist);
    }

    // 데이터를 삭제하는 메서드
    public int deleteOrgRegist(String uuid) {
        return sqlSessionTemplate.delete("deleteOrgRegist", uuid);
    }

	public int selectMaxTotalId() {
		return sqlSessionTemplate.selectOne("selectMaxTotalId");
	}

}
