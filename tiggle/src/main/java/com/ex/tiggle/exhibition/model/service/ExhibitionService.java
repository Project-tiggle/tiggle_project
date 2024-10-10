package com.ex.tiggle.exhibition.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.exhibition.model.dto.Exhibition;

public interface ExhibitionService {

	int selectListCount();
	
	ArrayList<Exhibition> selectList(Paging paging);

	Exhibition selectListOne(String totalId);

}
