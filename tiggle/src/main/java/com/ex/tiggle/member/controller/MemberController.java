package com.ex.tiggle.member.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.ex.tiggle.member.model.dto.Member;
import com.ex.tiggle.member.model.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder; //패스워드 암호화
	
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
	
	
	//회원가입(이용약관) 페이지 내보내기용
	@RequestMapping(value="enrollPage.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveEnrollPage() {
		return "member/enrollPage";
	}//moveEnrollPage() end
	
	
	//요청 받아서 모델쪽 서비스로 넘기고 결과받는 메서드 --------------------------------------------------
	//로그인 처리용
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(
			Member member, HttpSession session, SessionStatus status, Model model) {
		logger.info("login : " + member);
		
		//암호화 전
		Member loginMember = memberService.selectMember(member); 
		
		//로그인
		if (loginMember != null && this.bcryptPasswordEncoder.matches(member.getPwd(), loginMember.getPwd())) { //로그인 성공시
			session.setAttribute("loginMember", loginMember);
			status.setComplete();
			return "common/main";
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
	public String memberInsertMethod(Member member, Model model) {
		logger.info("enroll.do : " + member); //전송온 값 확인
		
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
	
	
}//MemberController end
