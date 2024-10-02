package com.ex.tiggle.exhibition.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.exhibition.model.dao.ExhibitionDao;

@Service("exhibitionService")
// 스프링에서는 서비스 인터페이스를 상속받은 후손클래스에 작성하도록 정해놓음.
public class ExhibitionServiceImpl implements ExhibitionService {
	
	// dao 와 연결 처리 : DI (Dependency Injection : 의존성 주입)
	@Autowired
	private ExhibitionDao exhibitionDao;
	
	
}// ExhibitionService end
