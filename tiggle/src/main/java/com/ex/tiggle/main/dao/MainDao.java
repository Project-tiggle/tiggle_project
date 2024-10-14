package com.ex.tiggle.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.notice.model.dto.Notice;

@Repository("mainDao")
public class MainDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<Notice> selectNTop3() {
		List<Notice> list = sqlSessionTemplate.selectList("noticeMapper.selectNTop3");
		return (ArrayList<Notice>)list;
	}//메인 공지사항(ajax)
	
	
	
}//MainDao end