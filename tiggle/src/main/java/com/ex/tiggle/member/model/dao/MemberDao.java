package com.ex.tiggle.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
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

	public Member selectAllMember(String uuid) {
		return sqlSessionTemplate.selectOne("memberMapper.selectAllMember", uuid);
	}//회원정보 보기용
	
	public int updateMemberInfo(Member member) {
		return sqlSessionTemplate.update("memberMapper.updateMemberInfo", member);
	}//회원정보 수정용
	
	
	//(관리자) USER 회원 검색용 ****************************************
	public int selectSearchIdCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchIdCount", keyword);
	}

	public int selectSearchNameCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchNameCount", keyword);
	}

	public int selectSearchNicknameCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchNicknameCount", keyword);
	}

	public int selectSearchEmailCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchEmailCount", keyword);
	}

	public ArrayList<Member> selectSearchId(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectSearchId", search);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectSearchName(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectSearchName", search);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectSearchNickname(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectSearchNickname", search);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectSearchEmail(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectSearchEmail", search);
		return (ArrayList<Member>)list;
	}
	
	
	//(관리자) ORGANIZER 회원 검색용 ****************************************
	public int selectOrgSearchIdCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOrgSearchIdCount", keyword);
	}

	public int selectOrgSearchOrgNameCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOrgSearchOrgNameCount", keyword);
	}

	public int selectOrgSearchOrgEmailCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOrgSearchOrgEmailCount", keyword);
	}

	public int selectOrgSearchNameCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOrgSearchNameCount", keyword);
	}

	public ArrayList<Member> selectOrgSearchId(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectOrgSearchId", search);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectOrgSearchOrgName(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectOrgSearchOrgName", search);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectOrgSearchOrgEmail(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectOrgSearchOrgEmail", search);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectOrgSearchName(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("memberMapper.selectOrgSearchName", search);
		return (ArrayList<Member>)list;
	}
	
	
	//이메일로 아이디 찾기 - USER
	public Member selectIdByEmail(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectIdByEmail", member);
	}
	
	//전화번호로 아이디 찾기 - USER
	public Member selectIdByPhone(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectIdByPhone", member);
	}
	
	//이메일로 아이디 찾기 - ORGANIZER
	public Member selectOrgIdByEmail(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOrgIdByEmail", member);
	}
	
	//담당자 전화번호로 아이디 찾기 - ORGANIZER
	public Member selectOrgIdByPhone(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOrgIdByPhone", member);
	}

	public Member selectFindUser(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectFindUser", member);
	}//USER 찾기(아이디,이름,이메일)

	public int updateTempPwd(Member member) {
		return sqlSessionTemplate.update("memberMapper.updateTempPwd", member);
	}//임시 비밀번호 설정 - USER

	public Member selectFindOrganizer(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectFindOrganizer", member);
	}//ORGANIZER 찾기(아이디,기관명,이메일)
	
	
	
}//MemberDao end
