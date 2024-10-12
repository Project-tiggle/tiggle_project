package com.ex.tiggle.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
import com.ex.tiggle.member.model.dao.MemberDao;
import com.ex.tiggle.member.model.dto.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public Member selectLogin(Member member) {
		return memberDao.selectLogin(member);
	}//암호화 전

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}//회원가입용

	@Override
	public int insertOrgMember(Member member) {
		return memberDao.insertOrgMember(member);
	}//전시관계자 회원가입용

	@Override
	public int selectCheckId(String id) {
		return memberDao.selectCheckId(id);
	}//아이디 중복 체크(ajax)

	@Override
	public Member selectMember(String uuid) {
		return memberDao.selectMember(uuid);
	}//내정보 보기용

	@Override
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
	}//내정보 수정용 - USER
	
	@Override
	public int updateOrgMember(Member member) {
		return memberDao.updateOrgMember(member);
	}//내정보 수정용 - ORGANIZER

	@Override
	public int updateDeleteMember(Member member) {
		return memberDao.updateDeleteMember(member);
	}//회원탈퇴 처리용 - USER, ORGANIZER 모두 처리

	@Override
	public int updateUpdatedAt(Member member) {
		return memberDao.updateUpdatedAt(member);
	}//최근 접속일 업데이트
	
	
	
	//관리자용 **************************************************
	//관리자페이지 내보내기용	
//	@Override
//	public Member selectAdmin(String uuid) {
//		return memberDao.selectAdmin(uuid);
//	}
	
	@Override
	public int selectListCount() {
		return memberDao.selectListCount();
	}//총 페이지 수 계산 - 삭제예정

	@Override
	public ArrayList<Member> selectList(Paging paging) {
		return memberDao.selectList(paging);
	}//회원 목록 조회 후 결과받기 - 삭제예정

	@Override
	public ArrayList<Member> selectUserMembers(Paging paging) {
		return memberDao.selectUserMembers(paging);
	}//USER 목록 조회

	@Override
	public ArrayList<Member> selectOrgMembers(Paging paging) {
		return memberDao.selectOrgMembers(paging);
	}//ORGANIZER 목록 조회

	@Override
	public int selectUserMembersCount() {
		return memberDao.selectUserMembersCount();
	}//USER 총 페이지 수 계산

	@Override
	public int selectOrgMembersCount() {
		return memberDao.selectOrgMembersCount();
	}//ORGANIZER 총 페이지 수 계산

	@Override
	public Member selectAllMember(String uuid) {
		return memberDao.selectAllMember(uuid);
	}//회원정보 보기용
	
	@Override
	public int updateMemberInfo(Member member) {
		return memberDao.updateMemberInfo(member);
	}//회원정보 수정용

	//(관리자) USER 회원 검색용 ********************
	@Override
	public int selectSearchIdCount(String keyword) {
		return memberDao.selectSearchIdCount(keyword);
	}

	@Override
	public int selectSearchNameCount(String keyword) {
		return memberDao.selectSearchNameCount(keyword);
	}

	@Override
	public int selectSearchNicknameCount(String keyword) {
		return memberDao.selectSearchNicknameCount(keyword);
	}

	@Override
	public int selectSearchEmailCount(String keyword) {
		return memberDao.selectSearchEmailCount(keyword);
	}

	@Override
	public ArrayList<Member> selectSearchId(Search search) {
		return memberDao.selectSearchId(search);
	}

	@Override
	public ArrayList<Member> selectSearchName(Search search) {
		return memberDao.selectSearchName(search);
	}

	@Override
	public ArrayList<Member> selectSearchNickname(Search search) {
		return memberDao.selectSearchNickname(search);
	}

	@Override
	public ArrayList<Member> selectSearchEmail(Search search) {
		return memberDao.selectSearchEmail(search);
	}
	
	//(관리자) ORGANIZER 회원 검색용 ********************
	@Override
	public int selectOrgSearchIdCount(String keyword) {
		return memberDao.selectOrgSearchIdCount(keyword);
	}

	@Override
	public int selectOrgSearchOrgNameCount(String keyword) {
		return memberDao.selectOrgSearchOrgNameCount(keyword);
	}

	@Override
	public int selectOrgSearchOrgEmailCount(String keyword) {
		return memberDao.selectOrgSearchOrgEmailCount(keyword);
	}

	@Override
	public int selectOrgSearchNameCount(String keyword) {
		return memberDao.selectOrgSearchNameCount(keyword);
	}

	@Override
	public ArrayList<Member> selectOrgSearchId(Search search) {
		return memberDao.selectOrgSearchId(search);
	}

	@Override
	public ArrayList<Member> selectOrgSearchOrgName(Search search) {
		return memberDao.selectOrgSearchOrgName(search);
	}

	@Override
	public ArrayList<Member> selectOrgSearchOrgEmail(Search search) {
		return memberDao.selectOrgSearchOrgEmail(search);
	}

	@Override
	public ArrayList<Member> selectOrgSearchName(Search search) {
		return memberDao.selectOrgSearchName(search);
	}
	
	
	@Override
	public Member selectIdByEmail(Member member) {
		return memberDao.selectIdByEmail(member);
	}//이메일로 아이디 찾기 - USER

	@Override
	public Member selectIdByPhone(Member member) {
		return memberDao.selectIdByPhone(member);
	}//전화번호로 아이디 찾기 - USER

	@Override
	public Member selectOrgIdByEmail(Member member) {
		return memberDao.selectOrgIdByEmail(member);
	}//이메일로 아이디 찾기 - ORGANIZER

	@Override
	public Member selectOrgIdByPhone(Member member) {
		return memberDao.selectOrgIdByPhone(member);
	}//담당자 전화번호로 아이디 찾기 - ORGANIZER

	@Override
	public Member selectFindUser(Member member) {
		return memberDao.selectFindUser(member);
	}//USER 찾기(아이디,이름,이메일)

	@Override
	public int updateTempPwd(Member member) {
		return memberDao.updateTempPwd(member);
	}//임시비밀번호 설정

	@Override
	public Member selectFindOrganizer(Member member) {
		return memberDao.selectFindOrganizer(member);
	}//ORGANIZER 찾기(아이디,기관명,이메일)

	@Override
	public Member selectSocialLogin(String email) {
		return memberDao.selectSocialLogin(email);
	}//이메일로 소셜로그인

	@Override
	public int insertSocialMember(Member member) {
		return memberDao.insertSocialMember(member);
	}//소셜 회원가입

	
	
	
}//MemberServiceImpl end
