package com.ex.tiggle.custboard.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.common.FileNameChange;
import com.ex.tiggle.common.Paging;
import com.ex.tiggle.custboard.model.dto.CustBoard;
import com.ex.tiggle.custboard.model.service.CustBoardService;

@Controller
public class CustBoardController {
	private static final Logger logger = LoggerFactory.getLogger(CustBoardController.class);
	
	@Autowired
    private CustBoardService custBoardService;
	
	//------------------------------------------관리자---------------------------------------------------
	//1:1문의내역 리스트페이지 이동
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
	
	//글 상세보기 페이지 이동
	@RequestMapping("custbDetail.do")
	public String moveCustBoardDetail(
			CustBoard custBoard,
			@RequestParam("cId") int cId,
			@RequestParam("page") int currentPage,
			Model model) {
		custBoard = custBoardService.selectCboardCid(cId);	//입력된 cId정보로, 내용 select
		
		model.addAttribute("cId", cId);
		model.addAttribute("custBoard", custBoard);
		model.addAttribute("currentPage", currentPage);
		return "custboard/custDetailView";
	}

	//댓글 달기 페이지로 이동
	@RequestMapping("custReply.do")
	public String moveCustBoardReply(
			CustBoard custBoard,
			Model model,
			@RequestParam("cId") int cId,
			@RequestParam("page") int currentPage) {
		custBoard = custBoardService.selectCboardCid(cId); //원문 글 내용 불러오기용
		
		model.addAttribute("custBoard", custBoard);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("cId", cId);
		return "custboard/custWriteView";
	}
	
	//
	/* @RequestMapping(value = "custReply.do", method = RequestMethod.POST) */
	public String RegCustBoardReply(
			CustBoard reply,
			Model model,
			@RequestParam("cId") int cId,
			@RequestParam("page") int page,
			@RequestParam(name = "ofile", required = false) MultipartFile mfile,
			HttpServletRequest request) {
		
		// 게시 원글 첨부파일 저장 폴더를 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/custboard_upfiles");
		
		// 첨부파일이 있을 때
		if (!mfile.isEmpty()) {
			// 전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			String renameFileName = null;

			// 저장폴더에는 변경된 이름을 저장 처리함
			// 파일 이름바꾸기함 : 년월일시분초.확장자
			if (fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기
				renameFileName = (FileNameChange.change(fileName, "yyyyMMddHHmmss")) + "_" + fileName;
				// 바뀐 파일명 확인
				logger.info("첨부파일명 확인 : " + renameFileName);

				try {
					// 저장 폴더에 파일명 바꾸어 저장하기
					mfile.transferTo(new File(savePath + "\\" + renameFileName));
				} catch (Exception e) {
					model.addAttribute("message", "첨부파일 저장 실패!");
					return "common/error";
				}
			} // 파일명 바꾸기

			reply.setFileUrl(renameFileName);
		} // 첨부파일이 있을 때
		
		// 1. 새로 등록할 댓글은 원글을 조회해 옴
		CustBoard origin = custBoardService.selectCboardCid(cId);

		// 2. 새로 등록할 댓글의 레벨을 지정함
		reply.setcLev(origin.getcLev() + 1);

		// 3. 참조 원글 번호(boardRef) 지정함
		reply.setRefNo(origin.getRefNo());

		if (custBoardService.insertReply(reply) > 0) {
			return "redirect:adminCustBoard.do?page=" + page;
		} else {
			model.addAttribute("message", cId + "번 글에 대한 댓글 | 대댓글 등록 실패!");
			return "common/error";
		}
	}



}
