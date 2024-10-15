package com.ex.tiggle.exhibition.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.exhibition.model.dto.Exhibition;

public interface ExhibitionService {

	int selectListCount();
	
	Exhibition selectExhibitionOne(String totalId);
	ArrayList<Exhibition> selectList(Paging paging);

	// DML
	int insertExhibition(Exhibition exhibition);

	// 메인페이지 출력용 메서드
	ArrayList<Exhibition> selectListTop8();
	ArrayList<Exhibition> selectListSameMon();

	// DB 데이터 업데이트시 실행할 메서드
	int deleteApi();
}
