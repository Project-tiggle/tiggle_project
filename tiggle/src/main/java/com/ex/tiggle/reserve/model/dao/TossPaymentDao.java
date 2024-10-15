package com.ex.tiggle.reserve.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TossPaymentDao")
public class TossPaymentDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	
}
