package com.ex.tiggle.notice.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
import com.ex.tiggle.notice.model.dto.Notice;

public interface NoticeService {
	//공지사항 총 목록갯수
	int selectNoticeListCount();
	//공지사항 총 목록
	ArrayList<Notice> selectNoticeList(Paging paging);
	
	//공지사항 상세 내용보기
	Notice selectNotice(int nNo);
	//조회수 1증가 처리
	int updateAddReadCount(int nNo);
	
	//새 공지글 등록
	int insertNotice(Notice notice);
	//공지글 수정
	int updateNotice(Notice notice);
	//공지글 삭제(실제 활성화여부 = N)
	int updateDeleteNotice(int nNo);
	
	//공지글 검색용
	int selectSearchNNoCount(String keyword);
	int selectSearchNTitleCount(String keyword);
	int selectSearchNWriterCount(String keyword);
	ArrayList<Notice> selectSearchNNo(Search search);
	ArrayList<Notice> selectSearchNTitle(Search search);
	ArrayList<Notice> selectSearchNWriter(Search search);
	
	
	
}//NoticeService
