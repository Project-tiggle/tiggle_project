package com.ex.tiggle.reserve.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.reserve.model.dao.ReserveDao;
import com.ex.tiggle.reserve.model.dto.Reserve;

@Service("reserveService")
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	private ReserveDao reserveDao;

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Reserve selectListOne(String totalId) {
		return sqlSessionTemplate.selectOne(totalId);
	}
	
	
}// ReserveService end
