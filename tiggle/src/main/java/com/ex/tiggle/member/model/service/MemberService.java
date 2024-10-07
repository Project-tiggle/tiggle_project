package com.ex.tiggle.member.model.service;

import com.ex.tiggle.member.model.dto.Member;

public interface MemberService {
	//로그인 처리용
	Member selectLogin(Member member);
	
	//내정보 보기 처리용
	Member selectMember(String uuid);
	
	
	//DML **************************************************
	//최근 접속일 업데이트
	int updateUpdatedAt(Member member);
	
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
	//회원탈퇴 처리용 - USER, ORGANIZER 모두 처리
	int updateDeleteMember(Member member);
	
	
}//MemberService end
