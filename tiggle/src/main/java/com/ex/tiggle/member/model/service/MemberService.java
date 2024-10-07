package com.ex.tiggle.member.model.service;

import com.ex.tiggle.member.model.dto.Member;

public interface MemberService {
	//로그인 처리용
	Member selectLogin(Member member);
	
	//내정보 보기 처리용
	Member selectMember(String uuid);
	
	
	//DML **************************************************
	//일반사용자 회원가입 처리용
	int insertMember(Member member);
	//전시관계자 회원가입 처리용
	int insertOrgMember(Member member);
	//아이디 중복 체크(ajax)
	int selectCheckId(String id);
	
	//내 정보 수정용 - USER
	int updateMember(Member member);
	//내 정보 수정용 - ORGANIZER
	int updateOrgMember(Member member);

	
}//MemberService end
