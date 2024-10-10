package com.ex.tiggle.exhibition.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.exhibition.model.dao.ExhibitionDao;
import com.ex.tiggle.exhibition.model.dto.Exhibition;

@Service("exhibitionService")
// 스프링에서는 서비스 인터페이스를 상속받은 후손클래스에 작성하도록 정해놓음.
public class ExhibitionServiceImpl implements ExhibitionService {
	
	// dao 와 연결 처리 : DI (Dependency Injection : 의존성 주입)
	@Autowired
	private ExhibitionDao exhibitionDao;

	@Override
	public int selectListCount() {
		return exhibitionDao.selectListCount();
	}

	@Override
	public ArrayList<Exhibition> selectList(Paging paging) {
		return exhibitionDao.selectList(paging);
	}

	@Override
	public Exhibition selectListOne(String totalId) {
		return exhibitionDao.selectListOne(totalId);
	}
	
	
}// ExhibitionService end
