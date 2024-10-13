package com.ex.tiggle.custboard.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.custboard.model.dto.CustBoard;

public interface CustBoardService {

	// 관리자용
	int selectCustListCount();							//리스트 갯수 조회용
	ArrayList<CustBoard> selectCustList(Paging paging);	//리스트 조회용
	CustBoard selectCboardCid(int cId);					//글 디테일 뷰 불러오기용, 댓글 달기용 원글 불러오기
	int insertReply(CustBoard reply);					//1:1문의 댓글 등록용
}
