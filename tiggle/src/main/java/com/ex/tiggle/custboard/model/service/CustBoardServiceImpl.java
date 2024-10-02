package com.ex.tiggle.custboard.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.custboard.model.dao.CustBoardDao;

@Service("custBoardService")
public class CustBoardServiceImpl implements CustBoardService {
	@Autowired
	private CustBoardDao custBoardDao;
} // CustBoardService end
