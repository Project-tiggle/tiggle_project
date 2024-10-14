package com.ex.tiggle.reserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.exhibition.model.service.ExhibitionService;
import com.ex.tiggle.reserve.model.dto.Reserve;
import com.ex.tiggle.reserve.model.service.ReserveService;

@Controller
public class ReserveController {
	@Autowired
	private ReserveService reserveService;
	
	@Autowired
	private ExhibitionService exhibitionService;
	
	// 한줄평 등록 팝업 띄우는 메소드
	@RequestMapping("remove.do")
	public String moveReservePage(
			@RequestParam("no") String totalId, Model model) {
		Exhibition exhibition = exhibitionService.selectListOne(totalId);
		
		model.addAttribute("exhibition", exhibition);
		
		return "reserve/reserveMain";
	}
	
	
	@RequestMapping("payment.do") public String movePaymentPage(
	
	@RequestParam("no") String totalId, Model model) { Exhibition exhibition =
	exhibitionService.selectListOne(totalId);
		model.addAttribute("exhibition", exhibition);	
		return "reserve/paykeyin"; 
	}
		
	// 현재 열려있는 페이지의 정보를 가져와서 예매창에 출력
//	@RequestMapping(value = "reserveExhibition.do")
//	public ModelAndView exhibitionDetailMethod(@RequestParam("no") String totalId , ModelAndView mv) {
//		
//		Reserve reserve = reserveService.selectListOne(totalId);
//		
//		if (reserve != null) {
//			mv.addObject("reserve", reserve);
//			mv.setViewName("reserve/reserveForm");
//			
//			}
//		
//		
//		return mv;
//	}
	
	
}
