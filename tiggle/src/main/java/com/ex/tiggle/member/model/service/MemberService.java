package com.ex.tiggle.member.model.service;

import java.util.ArrayList;

import com.ex.tiggle.common.Paging;
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

	
	
	//관리자용 **************************************************
	//관리자페이지 내보내기용
	//Member selectAdmin(String uuid);
	//총 페이지 수 계산 - 삭제예정
	int selectListCount();
	//회원 목록 조회 후 결과받기 - 삭제예정
	ArrayList<Member> selectList(Paging paging);
	//USER 목록 조회 후 결과받기
	ArrayList<Member> selectUserMembers(Paging paging);
	//ORGANIZER 목록 조회 후 결과받기
	ArrayList<Member> selectOrgMembers(Paging paging);
	//USER 총 페이지 수 계산
	int selectUserMembersCount();
	//ORGANIZER 총 페이지 수 계산
	int selectOrgMembersCount();
	//회원정보 수정용
	int updateMemberInfo(Member member);
	
	
}//MemberService end
