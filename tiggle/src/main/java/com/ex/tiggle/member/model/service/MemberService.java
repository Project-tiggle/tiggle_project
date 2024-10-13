package com.ex.tiggle.member.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
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
	
	//회원정보 보기 처리용
	Member selectAllMember(String uuid);
	//회원정보 수정용
	int updateMemberInfo(Member member);
	
	//이메일로 아이디 찾기 - USER
	Member selectIdByEmail(Member member);
	//전화번호로 아이디 찾기 - USER
	Member selectIdByPhone(Member member);
	//이메일로 아이디 찾기 - ORGANIZER
	Member selectOrgIdByEmail(Member member);
	//담당자 전화번호로 아이디 찾기 - ORGANIZER
	Member selectOrgIdByPhone(Member member);
	
	//USER 찾기(아이디,이름,이메일)
	Member selectFindUser(Member member);
	//임시비밀번호 설정
	int updateTempPwd(Member member);
	//ORGANIZER 찾기(아이디,기관명,이메일)
	Member selectFindOrganizer(Member member);
	
	
	//(관리자) USER 회원 검색용
	int selectSearchIdCount(String keyword);
	int selectSearchNameCount(String keyword);
	int selectSearchNicknameCount(String keyword);
	int selectSearchEmailCount(String keyword);

	ArrayList<Member> selectSearchId(Search search);
	ArrayList<Member> selectSearchName(Search search);
	ArrayList<Member> selectSearchNickname(Search search);
	ArrayList<Member> selectSearchEmail(Search search);
	
	//(관리자) ORGANIZER 회원 검색용
	int selectOrgSearchIdCount(String keyword);
	int selectOrgSearchOrgNameCount(String keyword);
	int selectOrgSearchOrgEmailCount(String keyword);
	int selectOrgSearchNameCount(String keyword);

	ArrayList<Member> selectOrgSearchId(Search search);
	ArrayList<Member> selectOrgSearchOrgName(Search search);
	ArrayList<Member> selectOrgSearchOrgEmail(Search search);
	ArrayList<Member> selectOrgSearchName(Search search);

	
	//이메일로 소셜로그인 **************************************************
	Member selectSocialLogin(String email);
	//소셜 회원가입
	int insertSocialMember(Member member);
	
	//카카오 접속토큰 get
	String getReturnAccessToken(String code);
	//카카오 접속자 정보 get
	Map<String, Object> getMemberInfo(String kakaoToken);
	

			
}//MemberService end
