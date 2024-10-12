<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	
	<section class="container">
		<div class="l_title">
			<img src="/tiggle/resources/images/tiggle_logo.png" alt="">
			<p>아이디 찾기</p>
		</div><!-- l_title end -->

		<div class="print_id_wrap">
			<c:if test="${ member.memberType == 'USER' }">
				<p>${ member.name }님의 아이디를 찾았어요</p>
				<div class="print_id_box">
					<p>${ member.id }</p>
					<p>
						<fmt:formatDate value="${ member.signUpAt }" pattern="yyyy-MM-dd" /> 가입
					</p>
				</div><!-- print_id_box end -->
			</c:if>
			<c:if test="${ member.memberType == 'ORGANIZER' }">
				<p>${ member.orgName }의 아이디를 찾았어요</p>
				<div class="print_id_box">
					<p>${ member.id }</p>
					<p>
						<fmt:formatDate value="${ member.signUpAt }" pattern="yyyy-MM-dd" /> 가입
					</p>
				</div><!-- print_id_box end -->
			</c:if>

			<div class="print_bt_btns">
				<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/findPwdPage.do';">비밀번호 찾기</button>
				<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/loginPage.do';">로그인</button>
			</div><!-- print_bt_btns end -->
		</div><!-- print_id_wrap end -->
	</section><!-- container end -->


	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>