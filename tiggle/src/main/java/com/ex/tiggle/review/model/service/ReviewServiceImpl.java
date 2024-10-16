package com.ex.tiggle.review.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.review.model.dao.ReviewDao;
import com.ex.tiggle.review.model.dto.Review;
import com.ex.tiggle.review.model.dto.ReviewPaging;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;

	
	@Override
	public int selectListCount(String totalId) {
//		System.out.print(totalId);
		return reviewDao.selectListCount(totalId);
	
	}

	@Override
	public ArrayList<Review> selectList(ReviewPaging reviewPaging) {
		return reviewDao.selectList(reviewPaging);
	}

	@Override
	public Review selectReivew(Review review) {
		return reviewDao.selectReview(review);
	}

	@Override
	public int insertReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Override
	public int updateReview(Review review) {
		return reviewDao.updateReview(review);
	}

	@Override
	public int deleteReview(int rNum) {
		return reviewDao.deleteReveiw(rNum);
	}

	@Override
	public int insertReviewD(Review reviewd) {
		return reviewDao.insertReviewD(reviewd);
	}
} // ReviewService end
