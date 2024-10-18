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
	

	// 상세보기 처리를 위한 전시 데이터 1개 조회용
	public Exhibition selectExhibition(int totalid) {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectExhibition", totalid);
	}
	// 페이징 처리용 전시 리스트 조회 메소드
	public ArrayList<Exhibition> selectList(Paging paging) {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectList", paging);
		return (ArrayList<Exhibition>)list;
	}
	
	
	public int selectListCount() {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectListCount");
	}
	public int insertExhibition(Exhibition exhibition) {
		return sqlSessionTemplate.insert("exhibitionMapper.insertExhibition", exhibition);
	}

	public Exhibition selectExhibitionOne(String totalId) {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectExhibitionOne", totalId);
	}
	
	// Api 데이터 업데이트 전, 삭제용 메소드
	public int deleteApi() {
		return sqlSessionTemplate.delete("exhibitionMapper.deleteApi");
	}

	// 공통 메인에 띄울 전시 리스트 용 메소드 
	public ArrayList<Exhibition> selectListTop10() {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectListTop10");
		return (ArrayList<Exhibition>)list;
	}
	public ArrayList<Exhibition> selectListSameMon() {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectListSameMon");
		return (ArrayList<Exhibition>)list;
	}
	
	// 조회수 증가 메소드
	public int updateAddReadCount(String totalId) {
		return sqlSessionTemplate.update("exhibitionMapper.updateAddReadCount", totalId);
	}
 
	// 전시 검색용 메소드
	public int selectSearchTitleCount(String keyword) {
		return sqlSessionTemplate.selectOne("exhibitionMapper.selectSearchTitleCount", keyword);
	}
	public ArrayList<Exhibition> selectSearchTitle(Search search) {
		List<Exhibition> list = sqlSessionTemplate.selectList("exhibitionMapper.selectSearchTitle", search);
		logger.info("Dao =" + list.size());
		return (ArrayList<Exhibition>)list;
	}

	
}
