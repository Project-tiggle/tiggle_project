package com.ex.tiggle.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
import com.ex.tiggle.notice.model.dto.Notice;

@Repository("noticeDao")
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectNoticeListCount() {
		return sqlSessionTemplate.selectOne("noticeMapper.selectNoticeListCount");
	}//공지사항 총 목록갯수

	public ArrayList<Notice> selectNoticeList(Paging paging) {
		List<Notice> list = sqlSessionTemplate.selectList("noticeMapper.selectNoticeList", paging);
		return (ArrayList<Notice>)list;
	}//공지사항 총 목록

	public Notice selectNotice(int nNo) {
		return sqlSessionTemplate.selectOne("noticeMapper.selectNotice", nNo);
	}//공지사항 상세 내용보기

	public int updateAddReadCount(int nNo) {
		return sqlSessionTemplate.update("noticeMapper.updateAddReadCount", nNo);
	}//조회수 1증가 처리

	public int insertNotice(Notice notice) {
		return sqlSessionTemplate.insert("noticeMapper.insertNotice", notice);
	}//새 공지글 등록

	public int updateNotice(Notice notice) {
		return sqlSessionTemplate.update("noticeMapper.updateNotice", notice);
	}//공지글 수정

	public int updateDeleteNotice(int nNo) {
		return sqlSessionTemplate.update("noticeMapper.updateDeleteNotice", nNo);
	}//공지글 삭제(실제 활성화여부 = N)

	
	//공지글 검색용
	public int selectSearchNNoCount(String keyword) {
		return sqlSessionTemplate.selectOne("noticeMapper.selectSearchNNoCount", keyword);
	}

	public int selectSearchNTitleCount(String keyword) {
		return sqlSessionTemplate.selectOne("noticeMapper.selectSearchNTitleCount", keyword);
	}

	public int selectSearchNWriterCount(String keyword) {
		return sqlSessionTemplate.selectOne("noticeMapper.selectSearchNWriterCount", keyword);
	}

	public ArrayList<Notice> selectSearchNNo(Search search) {
		List<Notice> list = sqlSessionTemplate.selectList("noticeMapper.selectSearchNNo", search);
		return (ArrayList<Notice>)list;
	}

	public ArrayList<Notice> selectSearchNTitle(Search search) {
		List<Notice> list = sqlSessionTemplate.selectList("noticeMapper.selectSearchNTitle", search);
		return (ArrayList<Notice>)list;
	}

	public ArrayList<Notice> selectSearchNWriter(Search search) {
		List<Notice> list = sqlSessionTemplate.selectList("noticeMapper.selectSearchNWriter", search);
		return (ArrayList<Notice>)list;
	}

	
	
}//NoticeDao end
