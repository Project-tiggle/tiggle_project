<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	
	<section class="container">
		<div class="l_title">
			<img src="/tiggle/resources/images/tiggle_logo.png" alt="">
			<p>비밀번호 찾기</p>
		</div><!-- l_title end -->

		<div class="print_pwd_wrap">
			<p>임시 비밀번호를 이메일로 전송했습니다.</p>
			<p>임시 비밀번호로 로그인 한 후</p>
			<p><span>반드시</span> 비밀번호를 변경하세요</p>
			
			<div class="print_bt_btns">
				<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/main.do';">메인</button>
				<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/loginPage.do';">로그인</button>
			</div><!-- print_bt_btns end -->
		</div><!-- print_id_wrap end -->
	</section><!-- container end -->

	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>