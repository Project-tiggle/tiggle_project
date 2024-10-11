package com.ex.tiggle.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
import com.ex.tiggle.member.model.dto.Member;
import com.ex.tiggle.member.model.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder; //패스워드 암호화
	
	@Autowired
    private JavaMailSender mailSender; //회원가입 이메일 인증
	
	//뷰페이지 내보내기용 메서드 --------------------------------------------------
	//메인 페이지 내보내기용
	@RequestMapping(value="main.do", method=RequestMethod.POST)
	public String moveMain() {
		return "common/main";
	}//moveMain() end
	
	
	//로그인 페이지 내보내기용
	@RequestMapping(value="loginPage.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveLoginPage() {
		return "member/loginPage";
	}//moveLoginPage() end
	
	
	//회원가입(이용약관) 페이지 내보내기용
	@RequestMapping(value="TOSPage.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveTOSPage() {
		return "member/TOSPage";
	}//moveTOSPage() end
	
	
	//일반사용자 회원가입 페이지 내보내기용
	@RequestMapping(value="enrollPage.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveEnrollPage(
			@RequestParam(name="marketingYN", required=false) String marketingYN, Model model) {
	    logger.info("마케팅 동의 값 확인: " + marketingYN);
	    model.addAttribute("marketingYN", marketingYN);
	    
	    return "member/enrollPage";
	}//moveEnrollPage() end
	
	
	//전시관계자 회원가입 페이지 내보내기용
	@RequestMapping(value="orgEnrollPage.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveOrgEnrollPage(
			@RequestParam(name="marketingYN", required=false) String marketingYN, Model model) {
		logger.info("마케팅 동의 값 확인: " + marketingYN);
	    model.addAttribute("marketingYN", marketingYN);
		
		return "member/orgEnrollPage";
	}//moveOrgEnrollPage() end
	
	
	//회원탈퇴 페이지 내보내기용
	@RequestMapping(value = "delMemPage.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String moveDeleteMemberPage(HttpSession session, Model model) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		logger.info("delMemPage.do : " + loginMember);
		
		if(loginMember != null) {
			model.addAttribute("member", loginMember);
			return "member/deleteMemberPage";
		}else {
			model.addAttribute("message", "로그인 세션이 존재하지 않습니다.<br> 로그인 후 다시 시도해주세요.");
			return "common/error";
		}
	}//moveDeleteMemberPage() end
	
	
	
	//요청 받아서 모델쪽 서비스로 넘기고 결과받는 메서드 --------------------------------------------------
	//로그인 처리용
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(
			Member member, HttpSession session, SessionStatus status, Model model) {
		logger.info("login : " + member);
		
		Member loginMember = memberService.selectLogin(member);
		
		//로그인
		if (loginMember != null && this.bcryptPasswordEncoder.matches(member.getPwd(), loginMember.getPwd())) { //로그인 성공시
			session.setAttribute("loginMember", loginMember);
			
			member.setUuid(loginMember.getUuid());
			
			if (memberService.updateUpdatedAt(member) > 0) { //최근 접속일 업데이트 성공시
				status.setComplete();
				return "common/main";
			} else {
				model.addAttribute("message", "로그인에 실패하였습니다.<br> 아이디 또는 패스워드를 다시 확인하세요.");
				return "common/error";
			}
			
		} else { //로그인 실패시
			model.addAttribute("message", "로그인에 실패하였습니다.<br> 아이디 또는 패스워드를 다시 확인하세요.");
			return "common/error";
		}
		
	}//loginMethod() end
	
	
	//로그아웃 처리용
	@RequestMapping("logout.do")
	public String logoutMethod(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		// request 에 기록된 세션ID를 가지고, sessionScope (세션저장소)에 가서
		// 해당 ID와 일치하는 세션객체를 찾아서 반환받음
		// false 이면 세션객체가 있으면 해당 객체를 리턴받고, 없으면 null 리턴

		if (session != null) { // 세션객체가 있다면
			session.invalidate(); // 세션객체 없앰
			return "common/main";
		} else { // 세션객체가 없다면
			model.addAttribute("message", "로그인 세션이 존재하지 않습니다.");
			return "common/error";
		}

	}// logoutMethod() end
	
	
	//회원가입 처리용
	@RequestMapping(value="enroll.do", method=RequestMethod.POST)
	public String memberInsertMethod(Member member, Model model,
			@RequestParam("marketingYN") String marketingYN) {
		logger.info("enroll.do : " + member); //전송온 값 확인
		
		// marketingYN 값이 null일 경우 'N'으로 설정
	    if (marketingYN == null || marketingYN.isEmpty()) {
	        marketingYN = "N"; // 기본값 'N' 설정
	    }
		
		// 마케팅 동의 값을 Member 객체에 설정
	    member.setMarketingYN(marketingYN); // 마케팅 동의 여부 저장
		
		//패스워드 암호화 처리
		member.setPwd(bcryptPasswordEncoder.encode(member.getPwd()));
		logger.info("after encode : " + member.getPwd() 
					+ ", length : " + member.getPwd().length());
		
		//uuid 생성
		member.setUuid(UUID.randomUUID().toString());
		logger.info("uuid : " + member.getUuid());
		
		if(memberService.insertMember(member) > 0) {
			return "member/loginPage";
		}else {
			model.addAttribute("message", "회원가입에 실패하였습니다.<br> 확인하고 다시 가입해 주세요.");
			return "common/error";
		}
	}//memberInsertMethod() end	
	
	
	//전시관계자 회원가입 처리용
	@RequestMapping(value="orgEnroll.do", method=RequestMethod.POST)
	public String orgMemberInsertMethod(Member member, Model model,
			@RequestParam("marketingYN") String marketingYN) {
		logger.info("enroll.do : " + member); //전송온 값 확인
		
		// marketingYN 값이 null일 경우 'N'으로 설정
		if (marketingYN == null || marketingYN.isEmpty()) {
			marketingYN = "N"; // 기본값 'N' 설정
		}
		
		// 마케팅 동의 값을 Member 객체에 설정
		member.setMarketingYN(marketingYN); // 마케팅 동의 여부 저장
		
		//패스워드 암호화 처리
		member.setPwd(bcryptPasswordEncoder.encode(member.getPwd()));
		logger.info("after encode : " + member.getPwd() 
					+ ", length : " + member.getPwd().length());
		
		//uuid 생성
		member.setUuid(UUID.randomUUID().toString());
		logger.info("uuid : " + member.getUuid());
		
		if(memberService.insertOrgMember(member) > 0) {
			return "member/loginPage";
		}else {
			model.addAttribute("message", "회원가입에 실패하였습니다.<br> 확인하고 다시 가입해 주세요.");
			return "common/error";
		}
	}//orgMemberInsertMethod() end
	
	
	//아이디 중복 체크(ajax)
	@RequestMapping(value="idchk.do", method=RequestMethod.POST)
	public void dupCheckIdMethod(
			@RequestParam("id") String id, HttpServletResponse response) throws IOException {
		int idCount = memberService.selectCheckId(id);
		String returnStr = null;
		
		if(idCount == 0) {
			returnStr = "ok";
		}else {
			returnStr = "dup";
		}
		
		//response 를 이용해서 클라이언트와 출력스트림을 열어서 문자열값 내보냄
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.append(returnStr);
		out.flush();
		out.close();
		
	}//dupCheckIdMethod() end
	
	
	//회원가입 이메일 인증(ajax)
	@RequestMapping(value="mailCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public String mailCheck(
			@RequestParam(value = "email", required = false) String email,
	        @RequestParam(value = "orgEmail", required = false) String orgEmail) {
		// 이메일이 null이거나 비어있으면 orgEmail을 사용
	    if (email == null || email.isEmpty()) {
	        email = orgEmail;  // orgEmail을 사용
	    }

	    // email과 orgEmail 둘 다 null 또는 비어있을 경우 처리
	    if (email == null || email.isEmpty()) {
	        return "error";  // 두 이메일 모두 없는 경우 에러 처리
	    }
		
	    int certifyCode = (int)((Math.random()* (999999 - 100000 + 1)) + 100000);
	    
		String from = "tiggle2024@naver.com";
		String to = email;
		String title = "[인증번호] '티글' 회원가입시 필요한 인증번호 입니다.";
		String content = "[인증번호] " + certifyCode + " 입니다.<br> 인증번호 확인란에 기입해주십시오.";
		String mailNum = "";
		
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			
			mailHelper.setFrom(from);
	        mailHelper.setTo(to);
	        mailHelper.setSubject(title);
	        mailHelper.setText(content, true);       
	        
	        mailSender.send(mail);
	        mailNum = Integer.toString(certifyCode);
			
		} catch (Exception e) {
			e.printStackTrace();
			mailNum = "error";
		}//try~catch end
		
		return mailNum;
	}//mailCheck() end
	
	
	//내정보 보기 페이지 처리용
	@RequestMapping("myInfo.do")
	public String moveMyInfoPage(@RequestParam("uuid") String uuid, Model model) {
		logger.info("myInfo.do : " + uuid);
		
		Member member = memberService.selectMember(uuid);
		
		if(member != null) { //전송온 uuid로 회원조회 성공시
			model.addAttribute("member", member);
			return "member/myInfoPage";
		}else {
			model.addAttribute("message", "해당하는 회원이 없습니다.<br> 다시 로그인 해주세요.");
			return "common/error";
		}

	}// moveMyInfoPage() end
	
	
	//내정보 수정 페이지 처리용 - USER
	@RequestMapping(value="myUpdate.do", method=RequestMethod.POST)
	public String memberUpdateMethod(Member member, Model model,
			@RequestParam("uuid") String uuid, 
			@RequestParam("originalPwd") String originalPwd,
			@RequestParam(name="marketingYN", required=false) String marketingYN) {
		logger.info("myupdate.do : " + member);
		
		if(member.getPwd() != null && member.getPwd().length() > 0) { //패스워드 변경시
			member.setPwd(bcryptPasswordEncoder.encode(member.getPwd()));
			logger.info("after encode : " + member.getPwd());			
		}else { //암호 변경안됨
			member.setPwd(originalPwd); //원래 패스워드로 기록저장
		}
		
		// 마케팅 동의 처리
	    if(marketingYN == null) {
	        marketingYN = "N"; // 체크박스가 체크되지 않으면 "N"
	    }
	    member.setMarketingYN(marketingYN);
		
		if(memberService.updateMember(member) > 0) { //내정보 수정 성공시
			return "member/myInfoPage";
		}else {
			model.addAttribute("message", "회원 정보 수정에 실패하였습니다.<br> 확인 후 다시 수정해주세요.");
			return "common/error";
		}
	}//memberUpdateMethod() end
	
	
	//내정보 수정 페이지 처리용 - ORGANIZER
	@RequestMapping(value="orgMyUpdate.do", method=RequestMethod.POST)
	public String orgMemberUpdateMethod(Member member, Model model,
			@RequestParam("uuid") String uuid, 
			@RequestParam("originalPwd") String originalPwd,
			@RequestParam(name="marketingYN", required=false) String marketingYN) {
		logger.info("orgMyUpdate.do : " + member);
		
		if(member.getPwd() != null && member.getPwd().length() > 0) { //패스워드 변경시
			member.setPwd(bcryptPasswordEncoder.encode(member.getPwd()));
			logger.info("after encode : " + member.getPwd());			
		}else { //암호 변경안됨
			member.setPwd(originalPwd); //원래 패스워드로 기록저장
		}
		
		// 마케팅 동의 처리
	    if(marketingYN == null) {
	        marketingYN = "N"; // 체크박스가 체크되지 않으면 "N"
	    }
	    member.setMarketingYN(marketingYN);
		
		if(memberService.updateOrgMember(member) > 0) { //내정보 수정 성공시
			return "member/myInfoPage";
		}else {
			model.addAttribute("message", "회원 정보 수정에 실패하였습니다.<br> 확인 후 다시 수정해주세요.");
			return "common/error";
		}
	}//memberUpdateMethod() end

	
	//회원탈퇴용(USER, ORGANIZER 모두 가능) - 실제 탈퇴X, 로그인 가능 여부를 X로 변경
	@RequestMapping("deleteMember.do")
	public String deleteMemberMethod(Member member,
			@RequestParam("uuid") String uuid, 
			@RequestParam("deletedReason") String deletedReason,
			Model model) throws UnsupportedEncodingException {
		logger.info("uuid :" + uuid + ", deletedReaon : " + deletedReason);
		
		member.setDeletedReason(deletedReason);
		
		if(memberService.updateDeleteMember(member) > 0) { //회원 탈퇴 요청시 자동 로그아웃 처리됨
			return "redirect:logout.do";
		}else {
			model.addAttribute("message", "회원 탈퇴를 실패하였습니다.");
			return "common/error";
		}
	}//deleteMemberMethod()
	
	
	
	
	
	//관리자용 **************************************************
	//관리자페이지 내보내기용 - 일반사용자 목록
	@RequestMapping("ulist.do")
	public ModelAndView userListPage(ModelAndView mv,
	        @RequestParam(name = "page", required = false) String page,
	        @RequestParam(name = "limit", required = false) String slimit) {
		// page: 출력할 페이지, limit: 한 페이지에 출력할 목록 갯수

	    // 페이징 처리
	    int currentPage = 1;
	    if (page != null) {
	        currentPage = Integer.parseInt(page);
	    }

	    // 한 페이지에 출력할 공지 갯수 10개로 지정
	    int limit = 10;
	    if (slimit != null) {
	        limit = Integer.parseInt(slimit);
	    }

    	// 총 목록갯수 조회
	    int listCount = memberService.selectUserMembersCount();
    	
    	// 페이지 관련 항목 계산 처리
    	Paging paging = new Paging(listCount, limit, currentPage, "ulist.do");
    	paging.calculate();
    	
        // 일반 사용자 목록 조회
    	ArrayList<Member> list = memberService.selectUserMembers(paging);
	    
        if (list != null && list.size() > 0) {
	        mv.addObject("memberList", list);
	        mv.addObject("paging", paging);
	        mv.addObject("currentPage", currentPage);
	        mv.setViewName("member/userListPage");
	    } else {
	        mv.addObject("message", currentPage + " 페이지 회원 목록 조회 실패!");
	        mv.setViewName("common/error");
	    }

	    return mv;
	}//userListPage() end
	
	
	//관리자페이지 내보내기용 - 전시관계자 목록
	@RequestMapping("olist.do")
	public ModelAndView orgListPage(ModelAndView mv,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {
		// page: 출력할 페이지, limit: 한 페이지에 출력할 목록 갯수
		
		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}
		
		// 총 목록갯수 조회
		int listCount = memberService.selectOrgMembersCount();
		
		// 페이지 관련 항목 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "olist.do");
		paging.calculate();
		
		// 일반 사용자 목록 조회
		ArrayList<Member> list = memberService.selectOrgMembers(paging);
		
		if (list != null && list.size() > 0) {
			mv.addObject("memberList", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.setViewName("member/orgListPage");
		} else {
			mv.addObject("message", currentPage + " 페이지 회원 목록 조회 실패!");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//orgListPage() end
	
	
	//회원정보 수정페이지 내보내기용(관리자용) - 일반사용자, 전시관계자 모두 처리
	@RequestMapping(value="mEditPage.do", method=RequestMethod.POST)
	public String moveMemberEditPage(@RequestParam("uuid") String uuid, Model model) {
		logger.info("mEditPage.do : " + uuid);
		
		Member member = memberService.selectAllMember(uuid);
		
		if(member != null) { //전송온 uuid로 회원조회 성공시
			model.addAttribute("member", member);
			return "member/memberListUpdatePage";
		}else {
			model.addAttribute("message", "해당하는 회원이 없습니다.<br> 다시 확인해주세요.");
			return "common/error";
		}
		
	}//moveMemberEditPage() end

	
	//회원 정보 수정 (관리자용) - 회원정보에서 필요한 부분 대부분 볼 수 있을 때
	@RequestMapping(value="mEdit.do", method=RequestMethod.POST)
	public String memberEditMethod(Member member, Model model,
			@RequestParam("originalPwd") String originalPwd) {
		logger.info("mEdit.do : " + member);
		
		if(member.getPwd() != null && member.getPwd().length() > 0) { //패스워드 변경시
			member.setPwd(bcryptPasswordEncoder.encode(member.getPwd()));
			logger.info("after encode : " + member.getPwd());			
		}else { //암호 변경안됨
			member.setPwd(originalPwd); //원래 패스워드로 기록저장
		}
		
		if(memberService.updateMemberInfo(member) > 0) { //USER 정보 수정 성공시
			return "member/memberListUpdatePage";
		}else {
			model.addAttribute("message", "회원 정보 수정에 실패하였습니다.<br> 확인 후 다시 수정해주세요.");
			return "common/error";
		}
	}//memberEditMethod() end
	
	
	//USER 검색용(관리자용)
	@RequestMapping(value="userSearch.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView userSearchMethod(ModelAndView mv, HttpServletRequest request) {
		String keyword = request.getParameter("keyword").trim();
		String sOption = request.getParameter("sOption");
		Search search = new Search();
		
		if((sOption == null || sOption.trim().isEmpty()) && (keyword == null || keyword.trim().isEmpty())) {
			mv.setViewName("redirect:ulist.do?page=1");
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
			case "id": 		listCount = memberService.selectSearchIdCount(keyword); break;
			case "name": 	listCount = memberService.selectSearchNameCount(keyword); break;
			case "nickname": listCount = memberService.selectSearchNicknameCount(keyword); break;
			case "email":	 listCount = memberService.selectSearchEmailCount(keyword); break;
			default: listCount = 0; break;
		}
		
		//페이징 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "userSearch.do");
		paging.calculate();
		
		//겸색별 목록 조회 요청
		ArrayList<Member> list = null;
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		switch(sOption) {
			case "id": search.setKeyword(keyword);
				list = memberService.selectSearchId(search); break;
			case "name": search.setKeyword(keyword); 
				list = memberService.selectSearchName(search); break;
			case "nickname": search.setKeyword(keyword); 
				list = memberService.selectSearchNickname(search); break;
			case "email": search.setKeyword(keyword); 
				list = memberService.selectSearchEmail(search); break;
		}
		
		if(list != null && list.size() > 0) {
			mv.addObject("memberList", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.setViewName("member/userListPage");
			
			if (sOption !=null || keyword != null) {
			    mv.addObject("sOption", sOption);
			    mv.addObject("keyword", keyword);
			}
			
		}else {
			mv.addObject("message", "회원 검색 결과가 존재하지 않습니다.");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//USER 검색용
	
	
	//ORGANIZER 검색용(관리자용)
	@RequestMapping(value="orgSearch.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView orgSearchMethod(ModelAndView mv, HttpServletRequest request) {
		String keyword = request.getParameter("keyword").trim();
		String sOption = request.getParameter("sOption");
		Search search = new Search();
		
		if((sOption == null || sOption.trim().isEmpty()) && (keyword == null || keyword.trim().isEmpty())) {
			mv.setViewName("redirect:olist.do?page=1");
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
			case "id": 		listCount = memberService.selectOrgSearchIdCount(keyword); break;
			case "orgName": 	listCount = memberService.selectOrgSearchOrgNameCount(keyword); break;
			case "orgEmail": listCount = memberService.selectOrgSearchOrgEmailCount(keyword); break;
			case "name":	 listCount = memberService.selectOrgSearchNameCount(keyword); break;
			default: listCount = 0; break;
		}
		
		//페이징 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "orgSearch.do");
		paging.calculate();
		
		//겸색별 목록 조회 요청
		ArrayList<Member> list = null;
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		switch(sOption) {
			case "id": search.setKeyword(keyword);
			list = memberService.selectOrgSearchId(search); break;
			case "orgName": search.setKeyword(keyword); 
			list = memberService.selectOrgSearchOrgName(search); break;
			case "orgEmail": search.setKeyword(keyword); 
			list = memberService.selectOrgSearchOrgEmail(search); break;
			case "name": search.setKeyword(keyword); 
			list = memberService.selectOrgSearchName(search); break;
		}
		
		if(list != null && list.size() > 0) {
			mv.addObject("memberList", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.setViewName("member/orgListPage");
			
			if (sOption !=null || keyword != null) {
				mv.addObject("sOption", sOption);
				mv.addObject("keyword", keyword);
			}
			
		}else {
			mv.addObject("message", "회원 검색 결과가 존재하지 않습니다.");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//ORGANIZER 검색용
	
	
	
	
	
	
	
	
	
	
	//하는중 **************************************************
	@RequestMapping("mlist.do")
	public ModelAndView moveAdminPageMethod(ModelAndView mv,
	        @RequestParam(name = "page", required = false) String page,
	        @RequestParam(name = "limit", required = false) String slimit) {
	    // page: 출력할 페이지, limit: 한 페이지에 출력할 목록 갯수

	    // 페이징 처리
	    int currentPage = 1;
	    if (page != null) {
	        currentPage = Integer.parseInt(page);
	    }

	    // 한 페이지에 출력할 공지 갯수 10개로 지정
	    int limit = 10;
	    if (slimit != null) {
	        limit = Integer.parseInt(slimit);
	    }

    	// 총 목록갯수 조회
	    int listCount = memberService.selectUserMembersCount();
    	
    	// 페이지 관련 항목 계산 처리
    	Paging paging = new Paging(listCount, limit, currentPage, "mlist.do");
    	paging.calculate();
    	
        // 일반 사용자 목록 조회
    	ArrayList<Member> list = memberService.selectUserMembers(paging);
	    
        if (list != null && list.size() > 0) {
	        mv.addObject("memberList", list);
	        mv.addObject("paging", paging);
	        mv.addObject("currentPage", currentPage);
	        mv.setViewName("member/memberListPage");
	    } else {
	        mv.addObject("message", currentPage + " 페이지 회원 목록 조회 실패!");
	        mv.setViewName("common/error");
	    }

	    return mv;
	}//memberListMethod()
	
	
	//멤버유형벌 회원정보 보기
	@RequestMapping("/mlist")
	public ModelAndView memberListMethod(ModelAndView mv,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit,
			@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "keyword", required = false) String keyword) {
		// page: 출력할 페이지, limit: 한 페이지에 출력할 목록 갯수
		
		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}
		
		Paging paging = null;
		int listCount = 0;
		
		// 서비스로 목록 조회 요청하고 결과 받기
		ArrayList<Member> list = null;
		
		if ("div".equals(action) && "USER".equals(keyword)) {
			// 총 목록갯수 조회
			listCount = memberService.selectUserMembersCount();
			
			// 페이지 관련 항목 계산 처리
			paging = new Paging(listCount, limit, currentPage, "mlist.do");
			paging.calculate();
			
			// 일반 사용자 목록 조회
			list = memberService.selectUserMembers(paging);
		}
		
		if ("div".equals(action) && "ORGANIZER".equals(keyword)) {
			// 총 목록갯수 조회
			listCount = memberService.selectOrgMembersCount();
			
			// 페이지 관련 항목 계산 처리
			paging = new Paging(listCount, limit, currentPage, "mlist.do");
			paging.calculate();
			
			// 전시관계자 목록 조회
			list = memberService.selectOrgMembers(paging);
		}
		
		if (list != null && list.size() > 0) {
			mv.addObject("memberList", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.setViewName("member/memberListPage");
		} else {
			mv.addObject("message", currentPage + " 페이지 회원 목록 조회 실패!");
			mv.setViewName("common/error");
		}
		
		return mv;
	}//memberListMethod()
	
	
}//MemberController end
