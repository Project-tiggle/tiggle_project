package com.ex.tiggle.review.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.review.model.dto.Review;

@Repository("reviewDao")
public class ReviewDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public  Review selectReview(int reviewNo) {
		return sqlSessionTemplate.selectOne("reviewMapper.selectReview", reviewNo);
	}

}
