package com.ex.tiggle.map.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.map.model.dto.NearbyMap;

@Repository("nearbyMapDao")
public class NearbyMapDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int selectTotalCount() {
		return sqlSessionTemplate.selectOne("mapMapper.selectTotalCount"); 
	}

	public ArrayList<NearbyMap> selectLocList() {
		List<NearbyMap> list = sqlSessionTemplate.selectList("mapMapper.selectLocList");
		return (ArrayList<NearbyMap>)list; 
	}
}