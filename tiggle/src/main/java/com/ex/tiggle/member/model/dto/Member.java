package com.ex.tiggle.member.model.dto;

import java.sql.Date;

public class Member {
	//서로 다른 파일 작업 후 머지 테스트
	
	//Field
	private String uuid; 		//고유식별자
	private String id; 			//아이디
	private String pwd;			//패스워드
	private String name; 		//이름
	private String phone;		//전화번호
	private String email;		//이메일
	private String nickname;	//일반사용자 닉네임
	private String address; 	//일반사용자 주소
	private String gender;		//일반사용자 성별
	private String signtype;	//가입유형
	private String marketingYN;	//마케팅 동의 여부
	private String orgName;		//기관명
	private String orgTel;		//기관 전화번호
	private String orgEmail;	//기관 이메일
	private String mngDept;		//담당자 부서
	private String mngJobId;	//담당자 직급
	private String memberType;	//멤버유형
	private java.sql.Date signUpAt;		//가입일
	private java.sql.Date updatedAt;	//최근접속일
	private String loginOk;		//로그인 가능 여부
	private String deletedYN;	//회원탈퇴 여부
	private java.sql.Date deletedAt;	//회원탈퇴 날짜
	private String deletedReason;		//회원탈퇴 이유
	
	
	//Constructor
	public Member() {
		super();
	}
	
	public Member(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}//로그인용

	public Member(String uuid, String id, String pwd, String name, String phone, String email, String nickname,
			String address, String gender, String signtype, String marketingYN, String orgName, String orgTel,
			String orgEmail, String mngDept, String mngJobId, String memberType, Date signUpAt, Date updatedAt,
			String loginOk, String deletedYN, Date deletedAt, String deletedReason) {
		super();
		this.uuid = uuid;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.nickname = nickname;
		this.address = address;
		this.gender = gender;
		this.signtype = signtype;
		this.marketingYN = marketingYN;
		this.orgName = orgName;
		this.orgTel = orgTel;
		this.orgEmail = orgEmail;
		this.mngDept = mngDept;
		this.mngJobId = mngJobId;
		this.memberType = memberType;
		this.signUpAt = signUpAt;
		this.updatedAt = updatedAt;
		this.loginOk = loginOk;
		this.deletedYN = deletedYN;
		this.deletedAt = deletedAt;
		this.deletedReason = deletedReason;
	}

	
	//Method
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}

	public String getMarketingYN() {
		return marketingYN;
	}

	public void setMarketingYN(String marketingYN) {
		this.marketingYN = marketingYN;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgTel() {
		return orgTel;
	}

	public void setOrgTel(String orgTel) {
		this.orgTel = orgTel;
	}

	public String getOrgEmail() {
		return orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}

	public String getMngDept() {
		return mngDept;
	}

	public void setMngDept(String mngDept) {
		this.mngDept = mngDept;
	}

	public String getMngJobId() {
		return mngJobId;
	}

	public void setMngJobId(String mngJobId) {
		this.mngJobId = mngJobId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public java.sql.Date getSignUpAt() {
		return signUpAt;
	}

	public void setSignUpAt(java.sql.Date signUpAt) {
		this.signUpAt = signUpAt;
	}

	public java.sql.Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(java.sql.Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getLoginOk() {
		return loginOk;
	}

	public void setLoginOk(String loginOk) {
		this.loginOk = loginOk;
	}

	public String getDeletedYN() {
		return deletedYN;
	}

	public void setDeletedYN(String deletedYN) {
		this.deletedYN = deletedYN;
	}

	public java.sql.Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(java.sql.Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeletedReason() {
		return deletedReason;
	}

	public void setDeletedReason(String deletedReason) {
		this.deletedReason = deletedReason;
	}

	@Override
	public String toString() {
		return "Member [uuid=" + uuid + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", nickname=" + nickname + ", address=" + address + ", gender=" + gender
				+ ", signtype=" + signtype + ", marketingYN=" + marketingYN + ", orgName=" + orgName + ", orgTel="
				+ orgTel + ", orgEmail=" + orgEmail + ", mngDept=" + mngDept + ", mngJobId=" + mngJobId
				+ ", memberType=" + memberType + ", signUpAt=" + signUpAt + ", updatedAt=" + updatedAt + ", loginOk="
				+ loginOk + ", deletedYN=" + deletedYN + ", deletedAt=" + deletedAt + ", deletedReason=" + deletedReason
				+ "]";
	}
	
	
}//Member Class end
