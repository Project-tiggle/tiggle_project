package com.ex.tiggle.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
	public String moveDeleteMemberPage(Member member, HttpSession session, Model model) {
		logger.info("delMemPage.do : " + member);
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember != null) {
			model.addAttribute("member", loginMember);
			return "member/deleteMemberPage";
		}else {
			model.addAttribute("message", "로그인 세션이 존재하지 않습니다.<br> 로그인 후 다시 시도해주세요.");
			return "common/error";
		}
		
	}//moveDeleteMemberPage() end
	
	
	//moveDeleteMemberPage() end
	
	
	//요청 받아서 모델쪽 서비스로 넘기고 결과받는 메서드 --------------------------------------------------
	//로그인 처리용
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(
			Member member, HttpSession session, SessionStatus status, Model model) {
		logger.info("login : " + member);
		
		//암호화 전
		Member loginMember = memberService.selectLogin(member); 
		
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
	@RequestMapping(value="myupdate.do", method=RequestMethod.POST)
	public String memberUpdateMethod(Member member, Model model,
			@RequestParam("uuid") String uuid, 
			@RequestParam("originalPwd") String originalPwd) {
		logger.info("myupdate.do : " + member);
		
		if(member.getPwd() != null && member.getPwd().length() > 0) { //패스워드 변경시
			member.setPwd(bcryptPasswordEncoder.encode(member.getPwd()));
			logger.info("after encode : " + member.getPwd());			
		}else { //암호 변경안됨
			member.setPwd(originalPwd); //원래 패스워드로 기록저장
		}
		
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
			@RequestParam("originalPwd") String originalPwd) {
		logger.info("orgMyUpdate.do : " + member);
		
		if(member.getPwd() != null && member.getPwd().length() > 0) { //패스워드 변경시
			member.setPwd(bcryptPasswordEncoder.encode(member.getPwd()));
			logger.info("after encode : " + member.getPwd());			
		}else { //암호 변경안됨
			member.setPwd(originalPwd); //원래 패스워드로 기록저장
		}
		
		if(memberService.updateOrgMember(member) > 0) { //내정보 수정 성공시
			return "member/myInfoPage";
		}else {
			model.addAttribute("message", "회원 정보 수정에 실패하였습니다.<br> 확인 후 다시 수정해주세요.");
			return "common/error";
		}
	}//memberUpdateMethod() end

		
}//MemberController end
