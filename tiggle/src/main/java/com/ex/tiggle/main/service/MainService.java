package com.ex.tiggle.main.service;

import java.util.ArrayList;

import com.ex.tiggle.notice.model.dto.Notice;

public interface MainService {

	ArrayList<Notice> selectNTop3(); //메인 공지사항(ajax)
	
	
	
}//MainService end