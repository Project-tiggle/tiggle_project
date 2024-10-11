<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 등록</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/notice_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	
	<!-- notice_section start -->
	<div class="notice_section">
		<div class="notice_top">
			<div class="notice_title">
				<img src="/tiggle/resources/images/tiggle_logo.png">
				<p>공지글 등록</p>
			</div><!-- notice_title end -->
		</div><!-- notice_top end -->

		<div class="n_write_bt">
			<form action="ninsert.do" method="post" enctype="multipart/form-data">
				<table class="n_insert_table">
					<tr>
						<th>제 목</th>
						<td>
							<input type="text" name="nTitle">
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<input class="bg_eee" type="text" name="nWriter" readonly value="${ sessionScope.loginMember.nickname }">
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="file" name="ofile" multiple>
							<%-- name 속성의 이름은 필드명과 별개로 지정함 
							파일업로드 실패시 파일명만 문자열로 commmand 객체에 저장되지 않게 하기 위함
							--%>
						</td>
					</tr>
					<tr>
						<th>내 용</th>
						<td>
							<textarea name="nContent" wrap="hard" style=" white-space: pre;"></textarea>
						</td>
					</tr>
				</table><!-- n_insert_table end -->

				<div class="n_w_btns">
					<input type="submit" value="등록">
					<input type="reset" value="초기화">
					<input type="button" value="목록" onclick="javascript:history.go(-1); return false;">
				</div><!-- n_w_btns end -->
			</form>
		</div><!-- n_write_bt end -->
	</div><!-- notice_section end -->
		
		
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/notice_script.js"></script>
</body>
</html>