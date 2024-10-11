package com.ex.tiggle.notice.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.ex.tiggle.common.Search;
import com.ex.tiggle.member.model.dto.Member;
import com.ex.tiggle.notice.model.dto.Notice;
import com.ex.tiggle.notice.model.service.NoticeService;

@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	//뷰 페이지 이동 처리용 메서드 --------------------------------------------------
	//공지글 등록 페이지로 이동
	@RequestMapping("moveNWrite.do")
	public String moveNoticeWritePage() {
		return "notice/noticeWriteView";
	}//moveNoticeWritePage() end
	
	//공지글 수정 페이지로 이동 처리용
	@RequestMapping("nmoveup.do")
	public ModelAndView moveNoticeUpdatePage(
			@RequestParam("no") int nNo, ModelAndView mv) {
		//수정페이지에 출력할 공지글 조회해 봄
		Notice notice = noticeService.selectNotice(nNo);
		
		if(notice != null) {
			mv.addObject("notice", notice);
			mv.setViewName("notice/noticeNUpdatePage");
		}else {
			mv.addObject("message", nNo + "번 공지글 수정페이지로 이동 실패하였습니다.<br> 확인 후 다시 시도해주세요.");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//moveNoticeUpdatePage() end
	
	
	
	//요청 처리용 메서드 --------------------------------------------------
	//공지사항 페이지 내보내기 요청 처리용
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
	
	
	//공지사항 상세 내용보기 요청 처리용
	@RequestMapping("ndetail.do")
	public ModelAndView noticeDetailMethod(
			@RequestParam("no") int nNo,
			ModelAndView mv, HttpSession session) {
		logger.info("ndetail.do : " + nNo);
		
		Notice notice = noticeService.selectNotice(nNo);
		
		//조회수 1증가 처리
		noticeService.updateAddReadCount(nNo);
		
		if(notice != null) {
			mv.addObject("notice", notice);
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			if(loginMember != null && loginMember.getMemberType().equals("ADMIN")) {
				mv.setViewName("notice/noticeAdminDetail");
			}else {
				mv.setViewName("notice/noticeDetailView");
			}
			
		}else {
			mv.addObject("message", nNo + " 번 공지글 상세보기 요청에 실패하였습니다.<br> 다시 시도해주세요.");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//noticeDetailMethod() end
	
	
	//첨부파일 다운로드 요청 처리용 메서드
	//공통모듈로 작성된 FileDownloadView 클래스를 이용함 => 반드시 리턴타입이 ModelAndView 여야 함
	@RequestMapping("nfdown.do")
	public ModelAndView filedownMethod(
			HttpServletRequest request, ModelAndView mv, 
			@RequestParam("ofile") String originalFileName, 
			@RequestParam("rfile") String renameFileName) {
		
		//공지사항 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");
		//저장 폴더에서 읽을 파일에 대한 File 객체 생성
		File downFile = new File(savePath + "\\" + renameFileName);
		//파일 다운시 브라우저로 내보낼 원래 파일에 대한 File 객체 생성함
		File originFile = new File(originalFileName);
		
		//파일 다운 처리용 뷰클래스 id 명과 다운로드할 File 객체를 ModelAndView 에 담아서 리턴함
		mv.setViewName("filedown"); //뷰클래스의 id명 가입
		mv.addObject("originFile", originFile);
		mv.addObject("renameFile", downFile);
		
		return mv;
		
	};//filedownMethod() end
	
	
	//새 공지글 등록 요청 처리용 (파일 업로드 기능 추가)
	@RequestMapping(value="ninsert.do", method=RequestMethod.POST)
	public String noticeInsertMethod(Notice notice, Model model, 
			@RequestParam(name="ofile", required=false) MultipartFile mfile, 
			HttpServletRequest request) {
		logger.info("ninsert.do : " + notice);
		
		//공지사항 첨부파일 저장 폴더를 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");
		
		//첨부파일이 있을 때
		if(!mfile.isEmpty()) {
			//전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			String renameFileName = null;
			
			//저장폴더에는 변경된 이름을 저장 처리함
			//파일 이름바꾸기함 : 년월일시분초.확장자
			if(fileName != null && fileName.length() > 0) {
				//바꿀 파일명에 대한 문자열 만들기
				renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
				//바뀐 파일명 확인
				logger.info("첨부파일명 확인 : " + renameFileName);
				
				try {
					//저장 폴더에 파일명 바꿔 저장하기
					mfile.transferTo(new File(savePath + "\\" + renameFileName));
					
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "첨부파일을 저장에 실패하였습니다.<br> 확인 후 다시 시도해주세요.");
					return "common/error";
				}
				
			}//파일 이름 변경 if 문
			
			//notice 객체에 첨부파일 정보 저장 처리
			notice.setnOriginalFilePath(fileName);
			notice.setnRenameFilePath(renameFileName);
			
		}//if(!mfile.isEmpty()) end : 첨부파일이 있을 때
		
		if(noticeService.insertNotice(notice) > 0) {
			//새 공지글 등록 성공시 목록 페이지 내보내기 요청
			return "redirect:nlist.do";
			
		}else {
			model.addAttribute("message", "새 공지글 등록에 실패하였습니다.<br> 확인 후 다시 시도해주세요.");
			return "common/error";
		}
	}//noticeInsertMethod() end
	
	
	//공지글 수정 요청 처리용(파일 업로드 기능 사용)
	@RequestMapping(value="nupdate.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String noticeUpdateMethod(Notice notice, Model model, HttpServletRequest request, 
			@RequestParam(name="deleteFlag", required=false) String delFlag, 
			@RequestParam(name="upfile", required=false) MultipartFile mfile) {
		logger.info("nupdate.do : " + notice); //전송온 값 확인
		
		//첨부파일 관련 변경 사항 처리
		//공지사항 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");
		
		//1. 원래 첨부파일이 있는데 '파일삭제'를 선택한 경우
		//	 또는 원래 첨부파일이 있는데 새로운 첨부파일로 변경 업로드된 경우
		//=> 이전 파일과 파일정보 삭제함
		if(notice.getnOriginalFilePath() != null && (delFlag != null && delFlag.equals("yes")) || !mfile.isEmpty()) {
			//저장 폴더에서 이전 파일은 삭제함
			new File(savePath + "\\" + notice.getnRenameFilePath()).delete();
			//notice 안의 파일 정보도 삭제함
			notice.setnOriginalFilePath(null);
			notice.setnRenameFilePath(null);
		}
		
		//2. 새로운 첨부파일이 있을 때 또는 변경 첨부파일이 있을 때 (공지글 첨부파일은 1개임)
		//	 즉, upfile 이름으로 전송온 파일이 있다면
		if(!mfile.isEmpty()) {
			//전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			String renameFileName = null;
			
			//저장폴더에는 변경된 이름을 저장 처리함
			//파일 이름바꾸기함 : 년월일시분초.확장자
			if(fileName != null && fileName.length() > 0) {
				//바꿀 파일명에 대한 문자열 만들기
				renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
				//바뀐 파일명 확인
				logger.info("첨부파일명 확인 : " + renameFileName);
				
				try {
					//저장 폴더에 파일명 바꿔 저장하기
					mfile.transferTo(new File(savePath + "\\" + renameFileName));
					
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "첨부파일을 저장에 실패하였습니다.<br> 확인 후 다시 시도해주세요.");
					return "common/error";
				}
				
			}//파일 이름 변경 if 문
			
			//notice 객체에 첨부파일 정보 저장 처리
			notice.setnOriginalFilePath(fileName);
			notice.setnRenameFilePath(renameFileName);
			
		}//if(!mfile.isEmpty()) end : 첨부파일이 있을 때
		
		//첨부파일 관련 변경사항 처리 end
		
		if (noticeService.updateNotice(notice) > 0) { //공지글 수정 성공시
			return "redirect:ndetail.do?no=" + notice.getnNo();
		}else {
			model.addAttribute("message", notice.getnNo() + "번 공지글 수정에 실패하였습니다.<br> 확인 후 다시 시도해주세요.");
			return "common/error";
		}
		
	}//noticeUpdateMethod() end
	
	
	//공지글 삭제 요청 처리용
	@RequestMapping("ndelete.do")
	public String noticeDelete(
			@RequestParam("no") int nNo,
			@RequestParam(name="rfile", required=false) String renameFileName,
			HttpServletRequest request, Model model) {
		
		if(noticeService.updateDeleteNotice(nNo) > 0) { //공지글 삭제 성공시 = 공지글 활성화 여부를 N으로 수정(실제 삭제X)
			return "redirect:nlist.do";
		}else {
			model.addAttribute("message", nNo + "번 공지글 삭제를 실패하였습니다.<br> 확인 후 다시 시도해주세요.");
			return "common/error";
		}
		
	}//noticeDelete() end
	
	
	//USER 검색용(관리자용)
	@RequestMapping(value="nSearch.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView noticeSearchMethod(ModelAndView mv, HttpServletRequest request) {
		String keyword = request.getParameter("keyword").trim();
		String sOption = request.getParameter("sOption");
		Search search = new Search();
		
		if((sOption == null || sOption.trim().isEmpty()) && (keyword == null || keyword.trim().isEmpty())) {
			mv.setViewName("redirect:nlist.do?page=1");
			return mv;
		}
		
		//검색 결과에 대한 페이징 처리
		int currentPage = 1;
		//페이지로 전송온 값이 있다면
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//한 페이지에 출력할 목록 갯수 지정
		int limit = 10;
		//페이지로 전송온 값이 있다면
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		//총 페이지수 계산을 위해 겸색 결과가 적용된 총 목록 갯수 조회
		int listCount = 0;
		switch(sOption) {
			case "nNo": 		listCount = noticeService.selectSearchNNoCount(keyword); break;
			case "nTitle": 	listCount = noticeService.selectSearchNTitleCount(keyword); break;
			case "nWriter": listCount = noticeService.selectSearchNWriterCount(keyword); break;
			default: listCount = 0; break;
		}
		
		//페이징 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "nSearch.do");
		paging.calculate();
		
		//겸색별 목록 조회 요청
		ArrayList<Notice> list = null;
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		switch(sOption) {
			case "nNo": search.setKeyword(keyword);
				list = noticeService.selectSearchNNo(search); break;
			case "nTitle": search.setKeyword(keyword); 
				list = noticeService.selectSearchNTitle(search); break;
			case "nWriter": search.setKeyword(keyword); 
				list = noticeService.selectSearchNWriter(search); break;
		}
		
		if(list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.setViewName("notice/noticeListView");
			
			if (sOption !=null || keyword != null) {
			    mv.addObject("sOption", sOption);
			    mv.addObject("keyword", keyword);
			}
			
		}else {
			mv.addObject("message", sOption + "에 대한 " + keyword + " 검색 결과가 존재하지 않습니다.<br> 확인 후 다시 검색해보세요.");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//USER 검색용
	
	
} // NoticeController end