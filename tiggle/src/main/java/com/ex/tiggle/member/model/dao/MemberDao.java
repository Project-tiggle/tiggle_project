package com.ex.tiggle.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.member.model.dto.Member;

@Repository("memeberDao")
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Member selectLogin(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectLogin", member);
	}//로그인 처리용

	public int insertMember(Member member) {
		return sqlSessionTemplate.insert("memberMapper.insertMember", member);
	}//회원가입 처리용

	public int insertOrgMember(Member member) {
		return sqlSessionTemplate.insert("memberMapper.insertOrgMember", member);
	}//전시관계자 회원가입 처리용

	public int selectCheckId(String id) {
		return sqlSessionTemplate.selectOne("memberMapper.selectCheckId", id);
	}//아이디 중복 체크(ajax)

	public Member selectMember(String uuid) {
		return sqlSessionTemplate.selectOne("memberMapper.selectMember", uuid);
	}//내정보 보기용

	public int updateMember(Member member) {
		return sqlSessionTemplate.update("memberMapper.updateMember", member);
	}//내정보 수정용 - USER
	
	public int updateOrgMember(Member member) {
		return sqlSessionTemplate.update("memberMapper.updateOrgMember", member);
	}//내정보 수정용 - USER

	public int updateDeleteMember(Member member) {
		return sqlSessionTemplate.update("memberMapper.updateDeleteMember", member);
	}//회원탈퇴 처리용 - USER, ORGANIZER 모두 처리

	public int updateUpdatedAt(Member member) {
		return sqlSessionTemplate.update("memberMapper.updateUpdatedAt", member);
	}//최근 접속일 업데이트
	
	
	
	//관리자용 **************************************************
//	public Member selectAdmin(String uuid) {
//		return sqlSessionTemplate.selectOne("memberMapper.selectAdmin", uuid);
//	}
	//관리자페이지 내보내기용

	public int selectListCount() {
		return sqlSessionTemplate.selectOne("memberMapper.selectListCount");
	}//총 페이지 수 계산

	public ArrayList<Member> selectList(Paging paging) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectList", paging);
		return (ArrayList<Member>)list;
	}//회원 목록 조회 후 결과받기 - 삭제예정

	public ArrayList<Member> selectUserMembers(Paging paging) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectUserMembers", paging);
		return (ArrayList<Member>)list;
	}//USER 목록 조회

	public ArrayList<Member> selectOrgMembers(Paging paging) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectOrgMembers", paging);
		return (ArrayList<Member>)list;
	}//ORGANIZER 목록 조회

	public int selectUserMembersCount() {
		return sqlSessionTemplate.selectOne("memberMapper.selectUserMembersCount");
	}//USER 총 페이지 수 계산

	public int selectOrgMembersCount() {
		return sqlSessionTemplate.selectOne("memberMapper.selectOrgMembersCount");
	}//ORGANIZER 총 페이지 수 계산
	

}//MemberDao end
