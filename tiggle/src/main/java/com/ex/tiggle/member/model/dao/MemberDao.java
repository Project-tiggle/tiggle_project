package com.ex.tiggle.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	

}//MemberDao end
