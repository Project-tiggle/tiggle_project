<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티글 로그인</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	
	<section class="container">
		<div class="l_title">
			<img src="/tiggle/resources/images/tiggle_logo.png" alt="">
			<p>로그인</p>
		</div><!-- l_title end -->

		<div class="login_wrap">
			<div class="loginform" id="loginForm">
				<form action="login.do" method="post">
					<input type="hidden" id="loginType" name="loginType" value="member">
					<div>
						<input type="text" name="Id" id="login_id" class="login_input" required placeholder="로그인">
						<input type="password" name="Pwd" id="login_pwd" class="login_input" required placeholder="패스워드">
					</div>
					<input class="l_submit_btn" type="submit" value="로그인">
				</form>
			</div><!-- loginform end -->

			<ul class="find_wrap">
				<li><a href="#">아이디 찾기</a></li>
				<li>&#10072;</li>
				<li><a href="#">비밀번호 찾기</a></li>
			</ul><!-- find_wrap end -->

			<button class="enroll_btn">
				<a href="TOSPage.do">회원가입</a>
			</button>
		</div><!-- login_wrap end -->
	</section><!-- container end -->


	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>