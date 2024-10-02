package com.ex.tiggle.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.ex.tiggle.member.model.dto.Member;
import com.ex.tiggle.member.model.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
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
	
	
	//요청 받아서 모델쪽 서비스로 넘기고 결과받는 메서드 --------------------------------------------------
	//로그인 처리용
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(
			Member member, HttpSession session, SessionStatus status, Model model) {
		logger.info("login : " + member);
		
		//암호화 전
		Member loginMember = memberService.selectMember(member); 
		logger.info("loginMember : " + loginMember);
		
		//로그인
		if (loginMember != null) { //로그인 성공시
			session.setAttribute("loginMember", loginMember);
			status.setComplete();
			return "common/main";
		} else { //로그인 실패시
			model.addAttribute("message", "로그인에 실패하였습니다.<br> 아이디 또는 패스워드를 다시 확인하세요.");
			return "common/error";
		}
		
	}//loginMethod() end
	
	
}//MemberController end
