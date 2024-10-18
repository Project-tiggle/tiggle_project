<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>1:1 문의 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/custBoard_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	<div class="myinfo_section">
		<aside class="myinfo_aside">
			<div class="mypage_title">
				<p>관리자페이지</p>
			</div>
			<!-- mypage_title -->

			<nav>
				<ul class="left_menu">
					<!-- <li><a href="mlist.do?page=1">회원목록</a></li> -->
					<li><a href="ulist.do?page=1">일반사용자 목록</a></li>
					<li><a href="olist.do?page=1">전시관계자 목록</a></li>
					<li><a href="#">예약확인 / 취소</a></li>
					<li><a href="adminCustBoard.do?page=1">1:1 문의내역</a></li>
				</ul>
				<!-- left_ menu end -->
			</nav>
		</aside>
		<!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<c:if test="${ !empty sessionScope.loginMember.nickname }">
					<p>${ sessionScope.loginMember.nickname } 님 안녕하세요.</p>
				</c:if>
				<c:if test="${ empty sessionScope.loginMember.nickname }">
					<p>${ sessionScope.loginMember.id } 님 안녕하세요.</p>
				</c:if>
			</div>
			<!-- myinfo_title end -->

			<div id="cwCon">
				<form action="cBoardUpdate.do" method="post" enctype="multipart/form-data" id="cwForm">
					<input type="hidden" name="cId" value="${ custBoard.cId }">
				    <input type="hidden" name="page" value="${ currentPage }">
				    <input type="hidden" name="uuid" value="${ sessionScope.loginMember.uuid }">
				    <input type="hidden" name="saveFile" value="${ custBoard.fileUrl }">
    
					<table id="cwFormTable">
						<tr>
							<td><label for="cwTitle">제목</label></td>
							<td><input type="text" id="cwTitle" name="title" style="width: 90%;"
								value="${ custBoard.title }" readonly>
							</td>
						</tr>
						<tr>
							<td><label for="cwWriter">작성자</label></td>
							<td><input type="text" id="cwWriter" name="id" style="width: 20%;"
								value="${ sessionScope.loginMember.id }" readonly>
							</td>
						</tr>
						<tr>
							<td><label for="cwContent">내용</label></td>
							<td><textarea id="cwContent" name="cContent" rows="15" style="width: 100%" required>${ custBoard.cContent }</textarea></td>
						</tr>
						<tr>
							<td><label for="cwFile">첨부파일</label></td>
							<td>
								<c:if test="${ !empty custBoard.fileUrl }">
									${ originalFileName } &nbsp;
									<input type="checkbox" name="deleteFlag" value="yes">파일삭제<br>
									변경 : <input type="file" id="cwFile" name="cfile" style="width: 400px;">
								</c:if>
								<c:if test="${ empty custBoard.fileUrl }">
									첨부 파일 없음 <br>
									추가 : <input type="file" id="cwFile" name="cfile" style="width: 400px;">
								</c:if>
							</td>
						</tr>
					</table>
					<br>
					<div id="cwBtn">
						<input type="button" value="이전페이지" onclick="javascript:history.go(-1);">
						<input type="button" value="목록"
							onclick="javascript:location.href='adminCustBoard.do?page=${ currentPage }';">
						<input type="submit" value="글수정">
					</div>			
				</form>
			</div>
		</div>
	</div>
	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>