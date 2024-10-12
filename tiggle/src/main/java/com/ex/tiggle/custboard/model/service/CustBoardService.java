package com.ex.tiggle.custboard.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.custboard.model.dto.CustBoard;

public interface CustBoardService {

	// start 관리자용
	int selectCustListCount();	//리스트 갯수 조회용
	ArrayList<CustBoard> selectCustList(Paging paging);	//리스트 조회용
	// end 관리자용
}
