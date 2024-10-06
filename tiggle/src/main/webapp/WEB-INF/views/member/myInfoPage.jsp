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
					<li><a href="#">회원탈퇴</a></li>
				</ul><!-- left_ menu end -->
			</nav>
		</aside><!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<p>내 정보 수정</p>
			</div><!-- myinfo_title end -->

			<div class="myinfo_wrap">
				<form action="" method="post">
					<div class="myinfo_list">
						<p>이 름</p>
						<input type="text" name="name" id="myinfo_name" value="${ requestScope.member.name }" readonly>
					</div><!-- myinfo_list end -->

					<div class="myinfo_list">
						<p>아이디</p>
						<input type="text" name="id" id="myinfo_id" value="${ requestScope.member.id }" readonly>
					</div><!-- myinfo_list end -->

					<div class="myinfo_list">
						<p>비밀번호</p>
						<input type="password" name="pwd" id="myinfo_pwd">
					</div><!-- myinfo_list end -->

					<div class="myinfo_list">
						<p>비밀번호 확인</p>
						<input type="password" id="myinfo_pwd2">
					</div><!-- myinfo_list end -->

					<div class="myinfo_list">
						<p>이메일</p>
						<input type="email" name="email" id="myinfo_email" value="${ requestScope.member.email }">
					</div><!-- myinfo_list end -->

					<div class="myinfo_list">
						<p>연락처</p>
						<input type="tel" name="phone" id="myinfo_phone" value="${ requestScope.member.phone }">
					</div><!-- myinfo_list end -->

					<div class="myinfo_list">
						<p>닉네임</p>
						<input type="text" name="nickname" id="myinfo_nickname" value="${ requestScope.member.nickname }">
					</div><!-- myinfo_list end -->

					
				</form>
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