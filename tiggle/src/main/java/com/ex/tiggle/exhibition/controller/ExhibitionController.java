package com.ex.tiggle.exhibition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.exhibition.model.service.ExhibitionService;

@Controller
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;

	// 전시 페이지 관련 컨트롤러
	// 전시 페이지로 이동
	@RequestMapping("exhibitionMain.do")
	public String moveExhibitionPage(Exhibition exhibition) {
		return "exhibition/exhibitionMain";
	}

	// 전시 상세 페이지로 이동
	@RequestMapping(value = "exhibitionDetail.do", method = RequestMethod.GET)
	public String moveExhibitionDeteailPage(Exhibition exhibition) {
		return "exhibition/exhibitionDetail";
	}

	// 상세보기 탭 출력

	// 한줄평 탭 출력

	// 오시는길 탭 출력
	
	// 전시회 페이지 출력 
	
	
}
