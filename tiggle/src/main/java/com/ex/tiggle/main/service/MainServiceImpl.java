package com.ex.tiggle.main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.main.dao.MainDao;
import com.ex.tiggle.notice.model.dto.Notice;

@Service("mainService")
public class MainServiceImpl implements MainService {
	@Autowired
	private	MainDao mainDao;

	@Override
	public ArrayList<Notice> selectNTop3() {
		return mainDao.selectNTop3();
	}//메인 공지사항(ajax)
	
	
	
}//MainService end
