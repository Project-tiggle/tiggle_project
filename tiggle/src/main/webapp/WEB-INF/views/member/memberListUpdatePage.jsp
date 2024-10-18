<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />



	<!-- 관리자페이지 회원정보 수정 -->
	<div class="myinfo_section">
		<aside class="myinfo_aside">
			<div class="mypage_title">
				<p>관리자페이지</p>
			</div><!-- mypage_title -->

			<nav>
				<ul class="left_menu">
					<!-- <li><a href="mlist.do?page=1">회원목록</a></li> -->
					<li><a href="ulist.do?page=1">일반사용자 목록</a></li>
					<li><a href="olist.do?page=1">전시관계자 목록</a></li>
					<li><a href="#">예약확인 / 취소</a></li>
					<li><a href="adminCustBoard.do?page=1">1:1 문의내역</a></li>
				</ul><!-- left_ menu end -->
			</nav>
		</aside><!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<p>회원정보 수정 (관리자용)</p>
			</div><!-- myinfo_title end -->
			
			
			
			<div class="myinfo_wrap">
				<c:if test="${ member.memberType eq 'USER' }">
					<form action="mEdit.do" method="post">
						<input type="hidden" name="originalPwd" value="${ requestScope.member.pwd }">
						<input type="hidden" name="memberType" value="${ requestScope.member.memberType }">
						
						<div class="myinfo_list">
							<p>UUID</p>
							<input type="text" name="uuid" id="myinfo_uuid" class="bg_eee" value="${ requestScope.member.uuid }" required>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>이 름</p>
							<input type="text" name="name" id="myinfo_name" value="${ requestScope.member.name }" required>
						</div><!-- myinfo_list end -->
	
						<div class="myinfo_list">
							<p>아이디</p>
							<input type="text" name="id" id="myinfo_id" value="${ requestScope.member.id }" required>
							<span>아이디는 변경할 수 없습니다</span>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>닉네임</p>
							<input type="text" name="nickname" id="myinfo_nickname" value="${ requestScope.member.nickname }" required>
						</div><!-- myinfo_list end -->
	
						<div class="myinfo_list">
							<p>비밀번호</p>
							<input type="password" name="pwd" id="myinfo_pwd">
							<span>8_20자 영문, 숫자, 특수문자 사용</span>
						</div><!-- myinfo_list end -->
	
						<div class="myinfo_list">
							<p>이메일</p>
							<input type="email" name="email" id="myinfo_email" value="${ requestScope.member.email }" required>
						</div><!-- myinfo_list end -->
	
						<div class="myinfo_list">
							<p>연락처</p>
							<input type="tel" name="phone" id="myinfo_phone" value="${ requestScope.member.phone }" required>
							<span>예시) 010-1234-5678</span>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>주 소</p>
							<input type="text" name="address" id="myinfo_address" value="${ requestScope.member.address }">
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list myinfo_list_marketing bc_333">
							<c:if test="${ requestScope.member.marketingYN eq 'Y' }">
								<input type="checkbox" name="marketingYN" id="myinfo_marketingYN" value="Y" checked>
							</c:if>
							<c:if test="${ requestScope.member.marketingYN ne 'Y' }">
								<input type="checkbox" name="marketingYN" id="myinfo_marketingYN" value="Y">
							</c:if>
							<p>자사 마케팅 수집 및 이용 동의</p>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>가입타입</p>
							<input type="text" name="signtype" id="myinfo_signtype" class="bg_eee" value="${ requestScope.member.signtype }" readonly>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>가입일</p>
							<input type="date" name="signUpAt" id="myinfo_signUpAt" class="bg_eee" value="${ requestScope.member.signUpAt }" readonly>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>최근 접속일</p>
							<input type="date" name="updatedAt" id="myinfo_updatedAt" class="bg_eee" value="${ requestScope.member.updatedAt }" readonly>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list myinfo_list_loginOk">
							<p>로그인 가능 여부</p>
							<c:if test="${ requestScope.member.loginOk eq 'Y' }">
								<input type="radio" name="loginOk" id="myinfo_loginOk1" value="Y" checked> 가능 &nbsp; &nbsp;
								<input type="radio" name="loginOk" id="myinfo_loginOk2" value="N"> 제한
							</c:if>
							<c:if test="${ requestScope.member.loginOk eq 'N' }">
								<input type="radio" name="loginOk" id="myinfo_loginOk1" value="Y"> 가능 &nbsp; &nbsp;
								<input type="radio" name="loginOk" id="myinfo_loginOk2" value="N" checked> 제한
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>회원탈퇴 여부</p>
							<c:if test="${ !empty requestScope.member.deletedYN }">
								<input type="text" name="deletedYN" id="myinfo_deletedYN" class="bg_eee" value="${ requestScope.member.deletedYN }" readonly>
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>회원탈퇴 날짜</p>
							<c:if test="${ !empty requestScope.member.deletedAt }">
								<input type="date" name="deletedAt" id="myinfo_deletedAt" class="bg_eee" value="${ requestScope.member.deletedAt }" readonly>
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>회원탈퇴 이유</p>
							<c:if test="${ !empty requestScope.member.deletedReason }">
								<input type="text" name="deletedReason" id="myinfo_deletedReason" class="bg_eee" value="${ requestScope.member.deletedReason }" readonly>
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_btn">
							<input type="button" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/ulist.do?page=1';" value="목 록">
							<input type="reset" value="초기화">
							<input type="submit" value="수 정">
						</div><!-- myinfo_btn end -->
					</form>
				</c:if><%-- USER 일때 --%>
				
				
				
				<c:if test="${ member.memberType eq 'ORGANIZER' }">
					<form action="mEdit.do" method="post">
						<input type="hidden" name="originalPwd" value="${ requestScope.member.pwd }">
						<input type="hidden" name="memberType" value="${ requestScope.member.memberType }">
						
						<div class="myinfo_list">
							<p>UUID</p>
							<input type="text" name="uuid" id="myinfo_uuid" class="bg_eee" value="${ requestScope.member.uuid }" required>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>아이디</p>
							<input type="text" name="id" id="myinfo_id" class="bg_eee" value="${ requestScope.member.id }" readonly>
							<span>아이디는 변경할 수 없습니다</span>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>비밀번호</p>
							<input type="password" name="pwd" id="myinfo_pwd">
							<span>8_20자 영문, 숫자, 특수문자 사용</span>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>기관명</p>
							<input type="text" name="orgName" id="myinfo_orgName" class="bg_eee" value="${ requestScope.member.orgName }" readonly>
						</div><!-- myinfo_list end -->
	
						<div class="myinfo_list">
							<p>기관 이메일</p>
							<input type="email" name="orgEmail" id="myinfo_orgEmail" value="${ requestScope.member.orgEmail }" required>
						</div><!-- myinfo_list end -->

						<div class="myinfo_list">
							<p>기관 전화번호</p>
							<input type="tel" name="orgTel" id="myinfo_orgTel" value="${ requestScope.member.orgTel }" required>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list bc_333">
							<p>주 소</p>
							<input type="text" name="address" id="myinfo_address" value="${ requestScope.member.address }">
						</div><!-- myinfo_list end -->

						<div class="myinfo_list">
							<p>담당자 이름</p>
							<input type="text" name="name" id="myinfo_name" value="${ requestScope.member.name }" required>
						</div><!-- myinfo_list end -->

						<div class="myinfo_list">
							<p>담당자 연락처</p>
							<input type="tel" name="phone" id="myinfo_phone" value="${ requestScope.member.phone }" required>
							<span>예시) 010-1234-5678</span>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>담당자 이메일</p>
							<input type="email" name="email" id="myinfo_email" value="${ requestScope.member.email }">
						</div><!-- myinfo_list end -->
						
 						<div class="myinfo_list">
							<p>담당자 부서</p>
							<input type="text" name="mngDept" id="myinfo_mngDept" value="${ requestScope.member.mngDept }">
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>담당자 직급</p>
							<input type="text" name="mngJobId" id="myinfo_mngJobId" value="${ requestScope.member.mngJobId }">
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list myinfo_list_marketing bc_333">
							<c:if test="${ requestScope.member.marketingYN eq 'Y' }">
								<input type="checkbox" name="marketingYN" id="myinfo_marketingYN" value="Y" checked>
							</c:if>
							<c:if test="${ requestScope.member.marketingYN ne 'Y' }">
								<input type="checkbox" name="marketingYN" id="myinfo_marketingYN" value="Y">
							</c:if>
							<p>자사 마케팅 수집 및 이용 동의</p>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>가입타입</p>
							<input type="text" name="signtype" id="myinfo_signtype" class="bg_eee" value="${ requestScope.member.signtype }" readonly>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>가입일</p>
							<input type="date" name="signUpAt" id="myinfo_signUpAt" class="bg_eee" value="${ requestScope.member.signUpAt }" readonly>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>최근 접속일</p>
							<input type="date" name="updatedAt" id="myinfo_updatedAt" class="bg_eee" value="${ requestScope.member.updatedAt }" readonly>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list myinfo_list_loginOk">
							<p>로그인 가능 여부</p>
							<c:if test="${ requestScope.member.loginOk eq 'Y' }">
								<input type="radio" name="loginOk" id="myinfo_loginOk1" value="Y" checked> 가능 &nbsp; &nbsp;
								<input type="radio" name="loginOk" id="myinfo_loginOk2" value="N"> 제한
							</c:if>
							<c:if test="${ requestScope.member.loginOk eq 'N' }">
								<input type="radio" name="loginOk" id="myinfo_loginOk1" value="Y"> 가능 &nbsp; &nbsp;
								<input type="radio" name="loginOk" id="myinfo_loginOk2" value="N" checked> 제한
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>회원탈퇴 여부</p>
							<c:if test="${ !empty requestScope.member.deletedYN }">
								<input type="text" name="deletedYN" id="myinfo_deletedYN" class="bg_eee" value="${ requestScope.member.deletedYN }" readonly>
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>회원탈퇴 날짜</p>
							<c:if test="${ !empty requestScope.member.deletedAt }">
								<input type="date" name="deletedAt" id="myinfo_deletedAt" class="bg_eee" value="${ requestScope.member.deletedAt }" readonly>
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_list">
							<p>회원탈퇴 이유</p>
							<c:if test="${ !empty requestScope.member.deletedReason }">
								<input type="text" name="deletedReason" id="myinfo_deletedReason" class="bg_eee" value="${ requestScope.member.deletedReason }" readonly>
							</c:if>
						</div><!-- myinfo_list end -->
						
						<div class="myinfo_btn">
							<input type="button" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/olist.do?page=1';" value="목 록">
							<input type="reset" value="초기화">
							<input type="submit" value="수 정">
						</div><!-- myinfo_btn end -->
					</form>
				</c:if><%-- ORGANIZER 일때 --%>
				
				
				
			</div><!-- myinfo_wrap end -->
		</div><!-- myinfo_content end -->
	</div><!-- myinfo_section end -->
	<!-- 마이페이지 회원정보 수정 end -->


	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
</body>
</html>