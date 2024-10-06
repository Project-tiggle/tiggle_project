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
	

}//MemberDao end
