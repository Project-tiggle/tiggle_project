package com.ex.tiggle.exhibition.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.exhibition.model.service.ExhibitionService;

@Controller
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;

	// 전시 페이지 관련 컨트롤러
	// 전시 페이지로 이동
	@RequestMapping("exhibitionMain.do")
		public ModelAndView exhibitionListMethod(ModelAndView mv, @RequestParam(name = "page", required = false) String page,
				@RequestParam(name = "limit", required = false) String slimit) {
			// page : 출력할 페이지, limit : 한 페이지에 출력할 목록 갯수

			// 페이징 처리
			int currentPage = 1;
			if (page != null) {
				currentPage = Integer.parseInt(page);

			}

			// 한 페이지에 출력할 공지 갯수 10개로 지정
			int limit = 25;
			if (slimit != null) {
				limit = Integer.parseInt(slimit);
			}

			// 총 목록갯수 조회해서 총 페이지 수 계산
			int listCount = exhibitionService.selectListCount();

			// 페이지 관련 항목 계산 처리
			Paging paging = new Paging(listCount, limit, currentPage, "exhibitionMain.do");
			paging.calculate();

			// 서비스로 목록 조회 요청하고 결과 받기
			ArrayList<Exhibition> list = exhibitionService.selectList(paging);

			if (list != null && list.size() > 0) {
				mv.addObject("list", list);
				mv.addObject("paging", paging);
				mv.addObject("currentPage", currentPage);

				mv.setViewName("exhibition/exhibitionMain");
			} else {
				mv.addObject("message", "목록 조회 실패!");
				mv.setViewName("common/error");
			}

			return mv;
		}
	
	

	// 클릭한 포스터와 같은 전시의 내용을 담은 상세 정보 페이지로 이동
	@RequestMapping(value = "exhibitionDetail.do")
	public ModelAndView exhibitionDetailMethod(@RequestParam("no") String totalId , ModelAndView mv) {
		
		Exhibition exhibition = exhibitionService.selectListOne(totalId);
		
		if (exhibition != null) {
			mv.addObject("exhibition", exhibition);
			mv.setViewName("exhibition/exhibitionDetail");
			
			}
		
		
		return mv;
	}

	// 상세보기 탭 출력

	// 한줄평 탭 출력

	// 오시는길 탭 출력
	
	// 전시회 페이지 출력 
	
	
	
}
