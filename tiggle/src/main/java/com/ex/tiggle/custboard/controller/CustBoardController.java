package com.ex.tiggle.custboard.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.custboard.model.dto.CustBoard;
import com.ex.tiggle.custboard.model.service.CustBoardService;

@Controller
public class CustBoardController {
	private static final Logger logger = LoggerFactory.getLogger(CustBoardController.class);
	
	@Autowired
    private CustBoardService custBoardService;
	
	@RequestMapping("adminCustBoard.do")
	public ModelAndView moveAdCustBoard(
			ModelAndView mv,
			CustBoard custBoard,
	    	@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {
		// page : 출력할 페이지, limit : 한 페이지에 출력할 목록 갯수
		
		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 출력할 등록 목록 10개 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		// 총 목록갯수 조회해서 총 페이지 수 계산함
		int listCount = custBoardService.selectCustListCount();
		// 페이지 관련 항목 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "adminCustBoard.do");
		paging.calculate();

		// 서비스롤 목록 조회 요청하고 결과 받기
		ArrayList<CustBoard> list = custBoardService.selectCustList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);

			mv.setViewName("custboard/adminCustView");
		} else {
			mv.setViewName("custboard/adminCustView");
		}

		return mv;
	}
}
