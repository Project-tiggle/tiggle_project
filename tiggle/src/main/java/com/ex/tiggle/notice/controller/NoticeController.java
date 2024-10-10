package com.ex.tiggle.notice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.notice.model.dto.Notice;
import com.ex.tiggle.notice.model.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//공지사항 페이지 내보내기용
	@RequestMapping("nlist.do")
	public ModelAndView moveNoticePage(ModelAndView mv,
			@RequestParam(name="page", required=false) String page, 
			@RequestParam(name="limit", required=false) String slimit) {
		//page : 출력할 페이지, limit : 한 페이지에 출력할 목록 갯수 
		
		//페이징 처리
		int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		//한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if(slimit != null) {
			limit = Integer.parseInt(slimit);
		}
		
		//총 목록갯수 조회해서 총 페이지 수 계산함
		int listCount = noticeService.selectNoticeListCount();
		//페이지 관련 항목 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "nlist.do");
		paging.calculate();
		
		//서비스로 목록 조회 요청하고 결과 받기
		ArrayList<Notice> list = noticeService.selectNoticeList(paging);
		
		if(list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			
			mv.setViewName("notice/noticeListView");
		}else {
			mv.addObject("message", "공지사항 목록 조회에 실패하였습니다.");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//moveNoticePage() end
	
	
} // NoticeController end