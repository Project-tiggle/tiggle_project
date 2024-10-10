package com.ex.tiggle.notice.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.notice.model.dto.Notice;

public interface NoticeService {
	//공지사항 총 목록갯수
	int selectNoticeListCount();
	//공지사항 총 목록
	ArrayList<Notice> selectNoticeList(Paging paging);

	
	
}//NoticeService
