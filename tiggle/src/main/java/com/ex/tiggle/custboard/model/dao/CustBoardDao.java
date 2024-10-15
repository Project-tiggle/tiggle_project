package com.ex.tiggle.custboard.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.custboard.model.dto.CustBoard;

@Repository("custBoardDao")
public class CustBoardDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectCustListCount() {
		return sqlSessionTemplate.selectOne("custBoardMapper.selectCustListCount");
	}

	public ArrayList<CustBoard> selectCustList(Paging paging) {
		List<CustBoard> list = sqlSessionTemplate.selectList("custBoardMapper.selectCustList", paging);
		return (ArrayList<CustBoard>)list;
	}

	public CustBoard selectCboardCid(int cId) {
		return sqlSessionTemplate.selectOne("custBoardMapper.selectCboardCid", cId);
	}

	public int insertReply(CustBoard reply) {
		return sqlSessionTemplate.insert("custBoardMapper.insertReply", reply);
	}

	public int updateUpY(int cId) {
		return sqlSessionTemplate.update("custBoardMapper.updateUpY", cId);
	}

	public int deleteCustBoard(CustBoard custBoard) {
		return sqlSessionTemplate.delete("custBoardMapper.deleteCustBoard", custBoard);
	}

	public int updateUpN(int refNo) {
		return sqlSessionTemplate.update("custBoardMapper.updateUpN", refNo);
	}

	public int updateOrigin(CustBoard custBoard) {
		return sqlSessionTemplate.update("custBoardMapper.updateOrigin", custBoard);
	}

	public int updateUpAt(int cId) {
		return sqlSessionTemplate.update("custBoardMapper.updateUpAt", cId);
	}

	public int selectUserCbListCount(String id) {
		return sqlSessionTemplate.selectOne("custBoardMapper.selectUserCbListCount", id);
	}

	public ArrayList<CustBoard> selectUserCbList(Map<String, Object> idNpaging) {
		List<CustBoard> list = sqlSessionTemplate.selectList("custBoardMapper.selectUserCbList", idNpaging);
		return (ArrayList<CustBoard>)list;
	}

	public int updateDeleteAt(CustBoard custBoard) {
		return sqlSessionTemplate.update("custBoardMapper.updateDeleteAt", custBoard);
	}

	public int insertInquiry(CustBoard custBoard) {
		return sqlSessionTemplate.insert("custBoardMapper.insertInquiry", custBoard);
	}

	public int updateUsOrigin(CustBoard custBoard) {
		return sqlSessionTemplate.update("custBoardMapper.updateUsOrigin", custBoard);
	}

}
