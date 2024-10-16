package com.ex.tiggle.custboard.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
import com.ex.tiggle.custboard.model.dto.CustBoard;
import com.ex.tiggle.notice.model.dto.Notice;

public interface CustBoardService {

	// 관리자용
	int selectCustListCount();							//리스트 갯수 조회용
	ArrayList<CustBoard> selectCustList(Paging paging);	//리스트 조회용
	int insertReply(CustBoard reply);					//1:1문의 댓글 등록용
	int updateUpY(int cId);								//답변완료시 참조 Lev1 Y처리
	int deleteCustBoard(CustBoard custBoard);			//게시글 삭제처리
	int updateUpN(int refNo);							//Lev2 삭제완료시 참조 Lev1 N처리
	int updateOrigin(CustBoard custBoard);				//게시글 수정(파일 삭제, 변경하기)
	int updateUpAt(int cId);							//게시글 수정일 업데이트
	
	//검색용(관리자)
	int selectSearchCbNoCount(String keyword);			//번호로 검색 total count
	int selectSearchCbTitleCount(String keyword);		//제목으로 검색 total count
	int selectSearchCbIdCount(String keyword);			//id로 검색 total count
	ArrayList<CustBoard> selectSearchCbNo(Search search);		//번호로 검색
	ArrayList<CustBoard> selectSearchCbTitle(Search search);	//제목으로 검색
	ArrayList<CustBoard> selectSearchCbId(Search search);		//ID로 검색
	
	
	//공동 사용
	CustBoard selectCboardCid(int cId);					//1.(관리자, 일반사용자)글 디테일 뷰 이동 2.(관리자)수정 처리용
	
	//일반사용자용
	int selectUserCbListCount(String id);				//리스트 갯수 조회용(내글 조회만)
	ArrayList<CustBoard> selectUserCbList(Map<String, Object> idNpaging); //내글과 내글에 대한 답변만 조회
	int updateDeleteAt(CustBoard custBoard);			//글 삭제 Y로 업데이트(일반사용자에게 숨김처리)
	int insertInquiry(CustBoard custBoard);				//문의글 등록
	int updateUsOrigin(CustBoard custBoard);			//게시글 수정(파일 삭제, 변경하기)
	
	
	
	
	
	
	
	
}
