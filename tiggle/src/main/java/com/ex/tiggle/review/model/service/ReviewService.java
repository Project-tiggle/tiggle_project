package com.ex.tiggle.review.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.review.model.dto.Review;
import com.ex.tiggle.review.model.dto.ReviewPaging;

public interface ReviewService {


	int selectListCount(String totalId);
	ArrayList<Review> selectList(ReviewPaging reviewPaging);
	Review selectReivew(Review review);
	
	int reviewWriterCount(Review review);
	
	// dml 
	int insertReview(Review review);
	int insertReviewD(Review reviewd);
	int updateReview(Review review);
	int deleteReview(int rNum);
}
