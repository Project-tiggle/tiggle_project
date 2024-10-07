<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />



	<!-- 마이페이지 회원정보 수정 -->
	<div class="myinfo_section">
		<aside class="myinfo_aside">
			<div class="mypage_title">
				<p>마이페이지</p>
			</div><!-- mypage_title -->

			<nav>
				<ul class="left_menu">
					<li><a href="myInfo.do?uuid=${ sessionScope.loginMember.uuid }">내정보 보기</a></li>
					<li><a href="#">예약확인 / 취소</a></li>
					<li><a href="#">1:1 문의내역</a></li>
					<li><a href="delMemPage.do">회원탈퇴</a></li>
				</ul><!-- left_ menu end -->
			</nav>
		</aside><!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<p>내 정보 수정</p>
			</div><!-- myinfo_title end -->
			
			
			
			<div class="myinfo_wrap">
				<c:if test="${ loginMember.memberType eq 'USER' }">
					<form action="myupdate.do" method="post" onsubmit="return validatePwd2();">
						<input type="hidden" name="uuid" value="${ requestScope.member.uuid }">
						<input type="hidden" name="originalPwd" value="${ requestScope.member.pwd }">
						
						<div class="myinfo_list">
							<p>이 름</p>
							<input type="text" name="name" id="myinfo_name" class="bg_eee" value="${ requestScope.member.name }" readonly>
						</div><!-- myinfo_list end -->
	
						<div class="myinfo_list">
							<p>아이디</p>
							<input type="text" name="id" id="myinfo_id" class="bg_eee" value="${ requestScope.member.id }" readonly>
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
	
						<div class="myinfo_list bc_333">
							<p>비밀번호 확인</p>
							<input type="password" id="myinfo_pwd2">
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
						
						<div class="myinfo_btn">
							<input type="reset" value="초기화">
							<input type="submit" value="수 정">
						</div><!-- myinfo_btn end -->
					</form>
				</c:if><%-- USER 일때 --%>
				
				
				
				<c:if test="${ loginMember.memberType eq 'ORGANIZER' }">
					<form action="orgMyUpdate.do" method="post" onsubmit="return validatePwd2();">
						<input type="hidden" name="uuid" value="${ requestScope.member.uuid }">
						<input type="hidden" name="originalPwd" value="${ requestScope.member.pwd }">
						
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
						
						<div class="myinfo_list bc_333">
							<p>비밀번호 확인</p>
							<input type="password" id="myinfo_pwd2">
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
						
						<div class="myinfo_btn">
							<input type="reset" value="초기화">
							<input type="submit" value="수 정">
						</div><!-- myinfo_btn end -->
					</form>
				</c:if><%-- ORGANIZER 일때 --%>
				
				
				
			</div><!-- myinfo_wrap end -->
		</div><!-- myinfo_content end -->
	</div><!-- myinfo_section end -->
	<!-- 마이페이지 회원정보 수정 end -->



	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
</body>
</html>