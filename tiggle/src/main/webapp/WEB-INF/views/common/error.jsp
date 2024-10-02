<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tiggle - Error</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	
	
	<!-- error_wrap section start -->

	<section class="error_wrap">
		<div class="err_top">
			<p>오류 발생</p>
			<p><%= request.getAttribute("message") %></p>
		</div><!-- err_top end -->
		
		<div class="err_bt">
			<a href="javascript:history.go(-1)">이전 페이지</a>
			<a href="main.do">메인 페이지</a>
		</div><!-- err_bt end -->
	</section>

	<!-- error_wrap section end -->
	
	
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>