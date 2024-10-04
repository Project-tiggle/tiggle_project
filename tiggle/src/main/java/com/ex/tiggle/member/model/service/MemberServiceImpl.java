package com.ex.tiggle.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.member.model.dao.MemberDao;
import com.ex.tiggle.member.model.dto.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public Member selectMember(Member member) {
		return memberDao.selectMember(member);
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
	
	
}//MemberServiceImpl end
