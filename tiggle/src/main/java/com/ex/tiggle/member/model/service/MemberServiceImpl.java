package com.ex.tiggle.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.common.Paging;
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
	
	
}//MemberServiceImpl end
