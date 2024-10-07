package com.ex.tiggle.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.review.model.service.ReviewService;
import com.ex.tiggle.review.model.dto.Review;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	// 한줄평 등록 팝업 띄우는 메소드
	@RequestMapping("rmove.do")
	public String moveReviewPage() {
		return "review/reviewWriteForm";
	}
	
	// 한줄평 수정 팝업 띄우는 메소드 
	@RequestMapping("nmoveup.do")
	public ModelAndView moveUpdatePage(@RequestParam("no") int reivewNo, ModelAndView mv) {
		// 수정페이지에서 출력할 공지글 조회해 봄
		Review reivew = reviewService.selectReivew(reivewNo);

		if (reivew != null) {
			mv.addObject("review", reivew);
			mv.setViewName("review/reviewUpdateView");
		} else {
			mv.addObject("message", "한줄평 수정 권한이 없습니다.");
			mv.setViewName("common/error");
		}

		return mv;
	}
	
	
	// 한줄평 목록 띄우는 메소드
	
	
}
