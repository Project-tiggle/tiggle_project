package com.ex.tiggle.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.member.model.dto.Member;

@Repository("memeberDao")
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Member selectMember(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectMember", member);
	}//암호화 전

}//MemberDao end
