package com.ex.tiggle.review.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.review.model.dto.Review;
import com.ex.tiggle.review.model.dto.ReviewPaging;

@Repository("reviewDao")
public class ReviewDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	

	public int selectListCount(String totalId) {
		// System.out.print(totalId);
		return sqlSessionTemplate.selectOne("reviewMapper.selectListCount", totalId);
	}


	public ArrayList<Review> selectList(ReviewPaging reviewPaging) {
//		System.out.print(reviewPaging.toString());
		List<Review> list = sqlSessionTemplate.selectList("reviewMapper.selectList", reviewPaging);
		return (ArrayList<Review>)list;
	}


	public Review selectReview(String uuid) {
		return sqlSessionTemplate.selectOne("reviewMapper.selectReview", uuid);
	}


	public int insertReview(Review review) {
		return sqlSessionTemplate.insert("reviewMapper.insertReview", review);
	}

}
