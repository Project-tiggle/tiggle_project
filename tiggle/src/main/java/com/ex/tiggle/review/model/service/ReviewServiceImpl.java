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
	public Review selectReivew(String uuid) {
		return reviewDao.selectReview(uuid);
	}

	@Override
	public int insertReview(Review review) {
		return reviewDao.insertReview(review);
	}
} // ReviewService end
