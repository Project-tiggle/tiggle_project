package com.ex.tiggle.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ex.tiggle.review.model.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
}
