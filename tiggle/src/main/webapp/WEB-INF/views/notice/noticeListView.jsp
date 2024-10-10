<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="nowpage" value="1" />
<c:if test="${ !empty requsetScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티글 공지사항</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/notice_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	
	<!-- notice_section start -->
	<div class="notice_section">
		<div class="notice_top">
			<div class="notice_title">
				<p>공지사항</p>
			</div><!-- notice_title end -->

			<div class="notice_wrap">
				<table class="notice_list">
					<tr>
						<td>No</td>
						<td>제목</td>
						<td>작성자</td>
						<td>첨부파일</td>
						<td>등록날짜</td>
					</tr>

					<c:forEach items="${ requestScope.list }" var="n">
						<tr>
							<td>${ n.nNo }</td>
							<td>${ n.nTitle }</td>
							<td>${ n.nWriter }</td>
							<td>
								<c:if test="${ !empty n.nOriginalFilePath }">
									<img src="/tiggle/resources/images/attach_file_icon.png" style="width: 5px;">
								</c:if>
								<c:if test="${ empty n.nOriginalFilePath }">&nbsp;</c:if>
							</td>
							<td>
								<fmt:formatDate value="${ n.nDate }" pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</c:forEach>
				</table><!-- notice_list end -->
			</div><!-- notice_wrap end -->
		</div><!-- notice_top end -->
		
		
		<c:import url="/WEB-INF/views/common/pagingSOptionView.jsp" />
	</div>
	<!-- notice_section end -->


	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/notice_script.js"></script>
</body>
</html>




















