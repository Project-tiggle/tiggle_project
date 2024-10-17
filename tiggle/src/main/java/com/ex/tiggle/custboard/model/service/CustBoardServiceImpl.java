package com.ex.tiggle.custboard.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
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

	@Override
	public int insertInquiry(CustBoard custBoard) {
		return custBoardDao.insertInquiry(custBoard);
	}

	@Override
	public int updateUsOrigin(CustBoard custBoard) {
		return custBoardDao.updateUsOrigin(custBoard);
	}

	@Override
	public int selectSearchCbNoCount(String keyword) {
		return custBoardDao.selectSearchCbNoCount(keyword);
	}

	@Override
	public int selectSearchCbTitleCount(String keyword) {
		return custBoardDao.selectSearchCbTitleCount(keyword);
	}

	@Override
	public int selectSearchCbIdCount(String keyword) {
		return custBoardDao.selectSearchCbIdCount(keyword);
	}

	@Override
	public ArrayList<CustBoard> selectSearchCbNo(Search search) {
		return custBoardDao.selectSearchCbNo(search);
	}

	@Override
	public ArrayList<CustBoard> selectSearchCbTitle(Search search) {
		return custBoardDao.selectSearchCbTitle(search);
	}

	@Override
	public ArrayList<CustBoard> selectSearchCbId(Search search) {
		return custBoardDao.selectSearchCbId(search);
	}

	@Override
	public int selectNoCustListCount() {
		return custBoardDao.selectNoCustListCount();
	}

	@Override
	public ArrayList<CustBoard> selectNoCustList(Paging paging) {
		return custBoardDao.selectNoCustList(paging);
	}

	@Override
	public int selectNoMemSearchNoCount(String keyword) {
		return custBoardDao.selectNoMemSearchNoCount(keyword);
	}

	@Override
	public int selectNoMemSearchTitleCount(String keyword) {
		return custBoardDao.selectNoMemSearchTitleCount(keyword);
	}

	@Override
	public int selectNoMemSearchIdCount(String keyword) {
		return custBoardDao.selectNoMemSearchIdCount(keyword);
	}

	@Override
	public ArrayList<CustBoard> selectNoMemSearchNo(Search search) {
		return custBoardDao.selectNoMemSearchNo(search);
	}

	@Override
	public ArrayList<CustBoard> selectNoMemSearchTitle(Search search) {
		return custBoardDao.selectNoMemSearchTitle(search);
	}

	@Override
	public ArrayList<CustBoard> selectNoMemSearchId(Search search) {
		return custBoardDao.selectNoMemSearchId(search);
	}


}
