package com.ex.tiggle.review.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.review.model.service.ReviewService;
import com.ex.tiggle.common.Paging;
import com.ex.tiggle.exhibition.controller.ExhibitionController;
import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.exhibition.model.service.ExhibitionService;
import com.ex.tiggle.notice.controller.NoticeController;
import com.ex.tiggle.review.model.dto.Review;
import com.ex.tiggle.review.model.dto.ReviewPaging;

@Controller
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ExhibitionService exhibitionService;
	
	
	// 한줄평 등록 팝업 띄우는 메소드
	@RequestMapping("rvmove.do")
	public String moveReviewPage(
			@RequestParam("no") String totalId, Model model) {
			Exhibition exhibition = exhibitionService.selectExhibitionOne(totalId);
			model.addAttribute("exhibition", exhibition);
			
			return "review/reviewWriteForm";
	}
	
	// 한줄평 수정 팝업 띄우는 메소드 
	@RequestMapping("rvmoveup.do")
	public ModelAndView moveUpdatePage(@RequestParam("uuid") String uuid, ModelAndView mv) {
		// 수정페이지에서 출력할 공지글 조회해 봄
		Review reivew = reviewService.selectReivew(uuid);

		if (reivew != null) {
			mv.addObject("review", reivew);
			mv.setViewName("review/reviewUpdateForm");
		} else {
			mv.addObject("message", "한줄평 수정 권한이 없습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	
	// 한줄평 목록 띄우는 메소드
	@RequestMapping("reviewList.do")
	public ModelAndView reviewListMethod(ModelAndView mv, @RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit, 
			@RequestParam("totalId") String totalId ) {
		// page : 출력할 페이지, limit : 한 페이지에 출력할 목록 갯수

		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 출력할 한줄평 갯수 10개로 지정
		int limit = 25;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		// 총 목록갯수 조회해서 총 페이지 수 계산
		int listCount = reviewService.selectListCount(totalId);

		// 페이지 관련 항목 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "reviewList.do");
		paging.calculate();
		
		ReviewPaging reviewPaging = new ReviewPaging();
		reviewPaging.setTotalId(totalId);
		reviewPaging.setStartRow(paging.getStartRow());
		reviewPaging.setEndRow(paging.getEndRow());
		
		// 서비스로 목록 조회 요청하고 결과 받기
		ArrayList<Review> list = reviewService.selectList(reviewPaging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);

			mv.setViewName("review/exhibitionDetail");
		} else {
			mv.addObject("message", "목록 조회 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	// 새 게시글 등록 요청 처리용
	@RequestMapping(value = "rinsert.do", method = RequestMethod.POST)
	public String reviewInsertMethod(Review review, Model model, HttpServletRequest request) {
		logger.info("rinsert.do : " + review);

		if (reviewService.insertReview(review) > 0) {
			// 새 공지글 등록 성공시 목록 페이지 내보내기 요청
			return "redirect:/exhibitionDetail.do?no=" + review.getTotalId();
		} else {
			model.addAttribute("massage", "새 게시글 등록 실패!");
			return "common/error";
		}
	}

	// 한줄평 수정 요청 처리용
	@RequestMapping(value = "rupdate.do", method = RequestMethod.POST)
	public String reviewUpdateMethod(Review review, Model model, HttpServletRequest request,
			@RequestParam(name="page", required=false) String page,
			@RequestParam(name = "deleteFlag", required = false) String delFlag
			) {
		logger.info("rupdate.do : " + review); // 전송온 값 확인

		int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		model.addAttribute("message", review.getrNum() + "번 게시글 원글 수정 실패!");
			return "common/error";
		}
	} 

	

