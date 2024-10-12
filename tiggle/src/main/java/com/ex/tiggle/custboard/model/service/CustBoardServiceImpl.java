package com.ex.tiggle.custboard.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.custboard.model.dao.CustBoardDao;
import com.ex.tiggle.custboard.model.dto.CustBoard;

@Service("custBoardService")
public class CustBoardServiceImpl implements CustBoardService {
	@Autowired
	private CustBoardDao custBoardDao;

	@Override
	public int selectCustListCount() {
		return custBoardDao.selectCustListCount();
	}

	@Override
	public ArrayList<CustBoard> selectCustList(Paging paging) {
		return custBoardDao.selectCustList(paging);
	}
}
