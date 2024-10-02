package com.ex.tiggle.notice.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.notice.model.dao.NoticeDao;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
}// NoticeService end
