package com.ex.tiggle.notice.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
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

	@Override
	public Notice selectNotice(int nNo) {
		return noticeDao.selectNotice(nNo);
	}//공지사항 상세 내용보기

	@Override
	public int updateAddReadCount(int nNo) {
		return noticeDao.updateAddReadCount(nNo);
	}//조회수 1증가 처리

	@Override
	public int insertNotice(Notice notice) {
		return noticeDao.insertNotice(notice);
	}//새 공지글 등록

	@Override
	public int updateNotice(Notice notice) {
		return noticeDao.updateNotice(notice);
	}//공지글 수정

	@Override
	public int updateDeleteNotice(int nNo) {
		return noticeDao.updateDeleteNotice(nNo);
	}//공지글 삭제(실제 활성화여부 = N)

	
	//공지글 검색용
	@Override
	public int selectSearchNNoCount(String keyword) {
		return noticeDao.selectSearchNNoCount(keyword);
	}

	@Override
	public int selectSearchNTitleCount(String keyword) {
		return noticeDao.selectSearchNTitleCount(keyword);
	}

	@Override
	public int selectSearchNWriterCount(String keyword) {
		return noticeDao.selectSearchNWriterCount(keyword);
	}

	@Override
	public ArrayList<Notice> selectSearchNNo(Search search) {
		return noticeDao.selectSearchNNo(search);
	}

	@Override
	public ArrayList<Notice> selectSearchNTitle(Search search) {
		return noticeDao.selectSearchNTitle(search);
	}

	@Override
	public ArrayList<Notice> selectSearchNWriter(Search search) {
		return noticeDao.selectSearchNWriter(search);
	}
	
	
	
}// NoticeService end
