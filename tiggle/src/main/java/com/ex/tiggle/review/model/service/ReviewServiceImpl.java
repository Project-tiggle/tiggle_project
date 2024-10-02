package com.ex.tiggle.review.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.review.model.dao.ReviewDao;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;
} // ReviewService end
