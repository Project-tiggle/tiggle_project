package com.ex.tiggle.review.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.review.model.dao.ReviewDao;
import com.ex.tiggle.review.model.dto.Review;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public Review selectReivew(int reviewNo) {
		return reviewDao.selectReview(reviewNo);
	}
} // ReviewService end
