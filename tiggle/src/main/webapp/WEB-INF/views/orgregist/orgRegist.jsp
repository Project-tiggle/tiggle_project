<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 전시/박람회 등록</title>
<link href="/tiggle/resources/css/orgRegist_style.css" rel="stylesheet"	type="text/css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	<div class="container">
		<h1 class="title">기업 전시/박람회 등록</h1>

		<div class="table-space">
			<p>혜택내용</p>
		</div>

		<div class="message">등록 승인 상황</div>

		<div class="buttons">
			<form action="#" method="get">
				<input type="submit" value="수정하기" class="btn">
			</form>

			<form action="orgRegDetail.do" method="post">
				<input type="submit" value="전시등록" class="btn">
			</form>
		</div>
	</div>
	<br><br><br><br>
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
