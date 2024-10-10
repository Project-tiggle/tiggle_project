package com.ex.tiggle.notice.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.notice.model.dao.NoticeDao;
import com.ex.tiggle.notice.model.dto.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public int selectNoticeListCount() {
		return noticeDao.selectNoticeListCount();
	}//공지사항 총 목록갯수

	@Override
	public ArrayList<Notice> selectNoticeList(Paging paging) {
		return noticeDao.selectNoticeList(paging);
	}//공지사항 총 목록
	
	
	
}// NoticeService end
