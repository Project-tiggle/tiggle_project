package com.ex.tiggle.map.model.service;

import java.util.ArrayList;

import com.ex.tiggle.map.model.dto.NearbyMap;

public interface NearbyMapService {

	int selectTotalCount(); // 등록승인Y 행사 전체 카운트 조회용

	ArrayList<NearbyMap> selectLocList();	// 등록승인Y 전체 데이터 가져오기

}
