package com.ex.tiggle.exhibition.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.exhibition.model.dto.Exhibition;

@Repository("exhibitionDao")
public class ExhibitionDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Exhibition insertExhibition(Exhibition exhibition) {
		return sqlSessionTemplate.selectOne("exhibitionMapper.insertExhibition", exhibition);
	}
}
