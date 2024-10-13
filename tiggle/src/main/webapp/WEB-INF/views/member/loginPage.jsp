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
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;500&display=swap" rel="stylesheet">
<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
<script src="/tiggle/resources/js/naveridlogin_js_sdk_2.0.2.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://accounts.google.com/gsi/client" async defer></script>
<script type="text/javascript">
	/* $(document).ready(function(){
		Kakao.init('99818889ec96dce2c471645e26a48fdd');
		Kakao.isInitialized();
	}); */
	Kakao.init('99818889ec96dce2c471645e26a48fdd');
	Kakao.isInitialized();
		
	function loginWithKakao() {
		Kakao.Auth.authorize({ 
			redirectUri: 'http://localhost:8080/tiggle/kakaoLogin.do',
		}); // 등록한 리다이렉트uri 입력
	};
</script>
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
				<li><a href="findIdPage.do">아이디 찾기</a></li>
				<li>&#10072;</li>
				<li><a href="findPwdPage.do">비밀번호 찾기</a></li>
			</ul><!-- find_wrap end -->

			<button class="enroll_btn" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/TOSPage.do';">회원가입</button>

			<div class="social_login_wrap">
				<a href="${ naverurl }">
					<img src="${ pageContext.servletContext.contextPath }/resources/images/naver_login_icon.png" alt="네이버로그인">
				</a>
				<a href="javascript:loginWithKakao()">
					<img src="${ pageContext.servletContext.contextPath }/resources/images/kakao_login_icon.png" alt="카카오로그인">
				</a>
				<a href="${ googleurl }">
					<img src="${ pageContext.servletContext.contextPath }/resources/images/google_login_icon.png" alt="구글로그인">
					<span>구글 로그인</span>
				</a>
			</div><!-- social_login_wrap end -->
		</div><!-- login_wrap end -->
	</section><!-- container end -->


	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>