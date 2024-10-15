package com.ex.tiggle.exhibition.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.exhibition.model.dto.Exhibition;

@Repository("exhibitionDao")
public class ExhibitionDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertExhibition(Exhibition exhibition) {
		return sqlSessionTemplate.insert("exhibitionMapper.insertExhibition", exhibition);
	}

	// 상세보기 처리를 위한 공지글 1개 조회용
	public Exhibition selectExhibition(int totalid) {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectExhibition", totalid);
	}
		
	public ArrayList<Exhibition> selectList(Paging paging) {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectList", paging);
		return (ArrayList<Exhibition>)list;
	}

	public int selectListCount() {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectListCount");
	}

	public Exhibition selectExhibitionOne(String totalId) {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectExhibitionOne", totalId);
	}

	public int deleteApi() {
		return sqlSessionTemplate.delete("exhibitionMapper.deleteApi");
	}

	public ArrayList<Exhibition> selectListTop8() {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectListTop8");
		return (ArrayList<Exhibition>)list;
	}

	public ArrayList<Exhibition> selectListSameMon() {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectListSameMon");
		return (ArrayList<Exhibition>)list;
	}

	
}
