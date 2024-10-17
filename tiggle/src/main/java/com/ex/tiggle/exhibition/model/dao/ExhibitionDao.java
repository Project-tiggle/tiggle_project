package com.ex.tiggle.exhibition.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
import com.ex.tiggle.exhibition.controller.ExhibitionController;
import com.ex.tiggle.exhibition.model.dto.Exhibition;

@Repository("exhibitionDao")
public class ExhibitionDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(ExhibitionDao.class);
	
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

	public ArrayList<Exhibition> selectListTop10() {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectListTop10");
		return (ArrayList<Exhibition>)list;
	}

	public ArrayList<Exhibition> selectListSameMon() {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectListSameMon");
		return (ArrayList<Exhibition>)list;
	}

	public int updateAddReadCount(String totalId) {
		return sqlSessionTemplate.update("exhibitionMapper.updateAddReadCount", totalId);
	}

	public int selectSearchTitleCount(String keyword) {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectSearchTitleCount", keyword);
	}

	public ArrayList<Exhibition> selectSearchTitle(Search search) {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectSearchTitle", search);
		logger.info("Dao =" + list.size());
		return (ArrayList<Exhibition>)list;
	}

	
}
