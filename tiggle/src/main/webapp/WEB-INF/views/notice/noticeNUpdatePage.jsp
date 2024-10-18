<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 수정 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
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
				<p>${ notice.nNo } 번 공지글 수정</p>
			</div><!-- notice_title end -->
		</div><!-- notice_top end -->

		<div class="n_write_bt">
			<form action="nupdate.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="nNo" value="${ notice.nNo }">
				<input type="hidden" name="nOriginalFilePath" value="${ notice.nOriginalFilePath }">
				<input type="hidden" name="nRenameFilePath" value="${ notice.nRenameFilePath }">
				
				<table class="n_insert_table">
					<tr>
						<th>제 목</th>
						<td>
							<input type="text" name="nTitle" value="${ notice.nTitle }">
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
							<c:if test="${ !empty notice.nOriginalFilePath }">
								<input type="checkbox" name="deleteFlag" value="yes" style="width: auto; display: inline; margin-right: 5px">파일삭제 &nbsp;&nbsp;
								<input type="file" name="upfile">
							</c:if>
							<c:if test="${ empty notice.nOriginalFilePath }">
								첨부 파일 없음 (추가하려면 아래의 '파일 선택'을 클릭해주세요.)
								<input type="file" name="upfile">
							</c:if>
						</td>
					</tr>
					<tr>
						<th>내 용</th>
						<td>
							<textarea name="nContent" wrap="hard" style=" white-space: pre;">${ notice.nContent }</textarea>
						</td>
					</tr>
				</table><!-- n_insert_table end -->

				<div class="n_w_btns">
					<input type="submit" value="수정">
					<input type="reset" value="초기화">
					<input type="button" value="목록" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/nlist.do'; return false;">
					<input type="button" value="이전" onclick="javascript:history.go(-1); return false;">
				</div><!-- n_w_btns end -->
			</form>
		</div><!-- n_write_bt end -->
	</div><!-- notice_section end -->
		
		
	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>	
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/notice_script.js"></script>
</body>
</html>