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
		
		
		String originalFileName = null;// 원래 파일 이름 내보내기용
		if(custBoard.getFileUrl() != null && custBoard.getFileUrl().length() > 0) {
			originalFileName = custBoard.getFileUrl().substring(custBoard.getFileUrl().indexOf('_') + 1);
		}
		
		model.addAttribute("cId", cId);
		model.addAttribute("custBoard", custBoard);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("originalFileName", originalFileName);
		
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
		return "custboard/custReplyView";
	}
	
	//관리자 댓글 등록용
	@RequestMapping(value = "cBoardReply.do", method = RequestMethod.POST)
	public String RegCustBoardReply(
			CustBoard reply,
			Model model,
			@RequestParam("uuid") String uuid,
			@RequestParam("page") int page,
			@RequestParam("cId") int cId,
			@RequestParam(name = "cfile", required = false) MultipartFile mfile,
			HttpServletRequest request) {
		logger.info("CustBoard : " + reply);
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
		
		// 새로 등록할 댓글은 원글을 조회해 옴
		CustBoard origin = custBoardService.selectCboardCid(cId);
		// 새로 등록할 댓글의 레벨을 지정함
		reply.setcLev(origin.getcLev() + 1);
		// 참조 원글 번호(boardRef) 지정함
		reply.setRefNo(origin.getRefNo());
		reply.setUuid(uuid);	//현재 로그인한 관리자 uuid 셋팅
		reply.setcCategory(origin.getcCategory());	//원글 그대로 카테고리 셋팅		

		if (custBoardService.insertReply(reply) > 0) {
			custBoardService.updateUpY(cId);	//답변완료메세지용 원글 업데이트
			return "redirect:adminCustBoard.do?page=" + page;
		} else {
			model.addAttribute("message", cId +" 번글 답변 등록 실패!");
			return "common/error";
		}
	}

	// 첨부파일 다운로드 요청 처리용 메소드
	// 공통모듈로 작성된 FileDownloadView 클래스를 이용함 => 반드시 리턴타입이 ModelAndView 여야 함
	@RequestMapping("custfDown.do")
	public ModelAndView filedownMethod(
			HttpServletRequest request,
			ModelAndView mv,
			@RequestParam("sfile") String saveFileName) {

		// 게시글 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/custboard_upfiles");
		// 저장 폴더에서 읽을 파일에 대한 File 객체 생성
		File downFile = new File(savePath + "\\" + saveFileName);
		// 파일 다운시 브라우저로 내보낼 원래 파일에 대한 File 객체 생성함
		String originalFileName = saveFileName.substring(saveFileName.indexOf('_') + 1);
		File originFile = new File(originalFileName);

		// 파일 다운 처리용 뷰클래스 id 명과 다운로드할 File 객체를 ModelAndView 에 담아서 리턴함
		mv.setViewName("filedown"); // 뷰클래스의 id명 기입
		mv.addObject("originFile", originFile);
		mv.addObject("renameFile", downFile);	
		
		return mv;
	}

	// 게시글 (원글, 댓글) 삭제 요청 처리용
	@RequestMapping("custDelete.do")
	public String boardDeleteMethod(
			CustBoard custBoard,
			Model model,
			HttpServletRequest request) {

		if (custBoardService.deleteCustBoard(custBoard) > 0) { // 게시글 삭제 성공시
			if (custBoard.getcLev() == 2) {
				custBoardService.updateUpN(custBoard.getRefNo());
			}
			// 게시글 삭제 성공시 저장 폴더에 있는 첨부파일도 삭제 처리함
			if (custBoard.getFileUrl() != null && custBoard.getFileUrl().length() > 0) {
				// 게시글 첨부파일 저장 폴더 경로 지정
				String savePath = request.getSession().getServletContext().getRealPath("resources/custboard_upfiles");
				// 저장 폴더에서 파일 삭제함
				new File(savePath + "\\" + custBoard.getFileUrl()).delete();
			}

			return "redirect:adminCustBoard.do";
		} else {
			model.addAttribute("message", custBoard.getcId() + "번 게시글 삭제 실패!");
			return "common/error";
		}
	}

	// 게시글(원글, 댓글) 수정페이지로 이동 처리용
	@RequestMapping("custUpView.do")
	public String moveBoardUpdatePage(
			@RequestParam("cId") int cId,
			@RequestParam("page") int currentPage,
			Model model) {
		// 수정페이지에 전달해서 출력할 board 정보 조회함
		CustBoard custBoard = custBoardService.selectCboardCid(cId);

		if (custBoard != null) {
			model.addAttribute("custBoard", custBoard);
			model.addAttribute("currentPage", currentPage);

			return "custboard/custEditView";
		} else {
			model.addAttribute("message", cId + "번 게시글 수정페이지로 이동 실패!");
			return "common/error";
		}
	}
	
	// 게시글 수정 요청 처리용 (파일 업로드 기능 사용)
	@RequestMapping(value = "cBoardUpdate.do", method = RequestMethod.POST)
	public String originUpdateMethod(
			CustBoard custBoard,
			Model model,
			HttpServletRequest request,
			@RequestParam(name = "saveFile", required = false) String saveFile,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "deleteFlag", required = false) String delFlag,
			@RequestParam(name = "cfile", required = false) MultipartFile mfile) {
		logger.info("cBoardUpdate.do : " + custBoard); // 전송온 값 확인

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 첨부파일 관련 변경 사항 처리
		// 게시원글 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/custboard_upfiles");

		// 1. 원래 첨부파일이 있는데 '파일삭제'를 선택한 경우
		// 또는 원래 첨부파일이 있는데 새로운 첨부파일로 변경 업로드된 경우
		// => 이전 파일과 파일정보 삭제함
		if (custBoard.getFileUrl() != null && (delFlag != null && delFlag.equals("yes"))) {
			// 저장 폴더에서 이전 파일은 삭제함
			new File(savePath + "\\" + saveFile).delete();
			// board 안의 파일 정보도 삭제함
			custBoard.setFileUrl(null);
		}

		// 2. 새로운 첨부파일이 있을 때 또는 변경 첨부파일이 있을 때 (공지글 첨부파일은 1개임)
		if (!mfile.isEmpty()) {
			// 전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			String renameFileName = null;

			// 저장폴더에는 변경된 이름을 저장 처리함
			// 파일 이름바꾸기함 : 년월일시분초.확장자
			if (fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기
				renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss") + "_" + fileName;
				// 바뀐 파일명 확인
				logger.info("첨부파일명 확인 : " + renameFileName);

				try {
					// 저장 폴더에 파일명 바꾸어 저장하기
					mfile.transferTo(new File(savePath + "\\" + renameFileName));
					new File(savePath + "\\" + saveFile).delete();	// 기존파일 삭제
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "첨부파일 저장 실패!");
					return "common/error";
				}
			} // 파일명 바꾸기

			custBoard.setFileUrl(renameFileName);
		} // 첨부파일이 있을 때

		if (custBoardService.updateOrigin(custBoard) > 0
				&& custBoardService.updateUpAt(custBoard.getcId()) > 0) { // 게시원글 수정 성공시
			
			model.addAttribute("cId", custBoard.getcId());
			model.addAttribute("page", currentPage);

			return "redirect:adminCustBoard.do";
		} else {
			model.addAttribute("message", custBoard.getcId() + "번 게시 원글 수정 실패!");
			return "common/error";
		}
	}

	
	//------------------------------------------일반사용자---------------------------------------------------
	// 푸터에서 1:1문의 이동용
	@RequestMapping("userCustBoard.do")
	public ModelAndView moveUserCustBoard(
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

			mv.setViewName("custboard/userCustView");
		} else {
			mv.setViewName("custboard/userCustView");
		}

		return mv;
	}
	
	
	
	
	
	
	
}
