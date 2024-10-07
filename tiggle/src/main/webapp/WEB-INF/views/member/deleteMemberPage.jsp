<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />



	<!-- 마이페이지 회원탈퇴 -->
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
				<p>회원탈퇴</p>
			</div><!-- myinfo_title end -->
			
			<div class="myinfo_wrap">
				
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