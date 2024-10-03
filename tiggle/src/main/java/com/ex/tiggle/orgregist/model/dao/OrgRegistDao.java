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

}
