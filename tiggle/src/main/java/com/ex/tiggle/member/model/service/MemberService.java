package com.ex.tiggle.member.model.service;

import com.ex.tiggle.member.model.dto.Member;

public interface MemberService {
	//로그인 처리용(암호화 전)
	Member selectMember(Member member);

}//MemberService end
