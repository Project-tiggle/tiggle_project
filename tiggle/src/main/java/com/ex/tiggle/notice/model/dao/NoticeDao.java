package com.ex.tiggle.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
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

	
	
}//NoticeDao end
