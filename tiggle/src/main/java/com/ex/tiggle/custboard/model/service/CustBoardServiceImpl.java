package com.ex.tiggle.custboard.model.service;

import java.util.ArrayList;
import java.util.Map;

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

	@Override
	public CustBoard selectCboardCid(int cId) {
		return custBoardDao.selectCboardCid(cId);
	}

	@Override
	public int insertReply(CustBoard reply) {
		return custBoardDao.insertReply(reply);
	}

	@Override
	public int updateUpY(int cId) {
		return custBoardDao.updateUpY(cId);
	}

	@Override
	public int deleteCustBoard(CustBoard custBoard) {
		return custBoardDao.deleteCustBoard(custBoard);
	}

	@Override
	public int updateUpN(int refNo) {
		return custBoardDao.updateUpN(refNo);
		
	}

	@Override
	public int updateOrigin(CustBoard custBoard) {
		return custBoardDao.updateOrigin(custBoard);
	}

	@Override
	public int updateUpAt(int cId) {
		return custBoardDao.updateUpAt(cId);
	}

	@Override
	public int selectUserCbListCount(String id) {
		return custBoardDao.selectUserCbListCount(id);
	}

	@Override
	public ArrayList<CustBoard> selectUserCbList(Map<String, Object> idNpaging) {
		return custBoardDao.selectUserCbList(idNpaging);
	}

	@Override
	public int updateDeleteAt(CustBoard custBoard) {
		return custBoardDao.updateDeleteAt(custBoard);
	}


}
