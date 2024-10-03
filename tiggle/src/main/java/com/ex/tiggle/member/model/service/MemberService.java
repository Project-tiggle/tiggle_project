package com.ex.tiggle.member.model.service;

import com.ex.tiggle.member.model.dto.Member;

public interface MemberService {
	//로그인 처리용(암호화 전)
	Member selectMember(Member member);
	
	//일반사용자 회원가입 처리용
	int insertMember(Member member);
	//전시관계자 회원가입 처리용
	int insertOrgMember(Member member);

}//MemberService end
