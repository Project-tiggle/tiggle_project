package com.ex.tiggle.review.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.review.model.dto.Review;
import com.ex.tiggle.review.model.dto.ReviewPaging;

@Repository("reviewDao")
public class ReviewDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewDao.class);		
	

	public int selectListCount(String totalId) {
		// System.out.print(totalId);
		return sqlSessionTemplate.selectOne("reviewMapper.selectListCount", totalId);
	}

	public ArrayList<Review> selectList(ReviewPaging reviewPaging) {
//		System.out.print(reviewPaging.toString());
		List<Review> list = sqlSessionTemplate.selectList("reviewMapper.selectList", reviewPaging);
		return (ArrayList<Review>)list;
	}

	public Review selectReview(Review review) {
		return sqlSessionTemplate.selectOne("reviewMapper.selectReview", review);
	}

	public int insertReview(Review review) {
		return sqlSessionTemplate.insert("reviewMapper.insertReview", review);
	}

	public int insertReviewD(Review review) {
		return sqlSessionTemplate.insert("reviewMapper.insertReviewD", review);
	}


	public int updateReview(Review review) {
		logger.info("DAO review =" + review);
		return sqlSessionTemplate.update("reviewMapper.updateReview", review);
	}


	public int deleteReveiw(int rNum) {
		return sqlSessionTemplate.update("reviewMapper.deleteReview", rNum);
	}
	
	public int reviewWriterCount(Review review) {
		return sqlSessionTemplate.selectOne("reviewMapper.reviewWriterCount", review);
	}
	
}
