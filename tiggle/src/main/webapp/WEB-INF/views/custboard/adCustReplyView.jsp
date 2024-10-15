<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>1:1 문의</title>
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
				<p>1:1문의 ${ cId }번 글 답변 (관리자용)</p>
			</div>
			<!-- myinfo_title end -->

			<div id="cwCon">
				<!-- 내용 분류 위한 변수 준비 -->
				<c:set var="categoryText" value="" />
				<c:if test="${custBoard.cCategory == '1'}">
				    <c:set var="categoryText" value="전시회" />
				</c:if>
				<c:if test="${custBoard.cCategory == '2'}">
				    <c:set var="categoryText" value="박람회" />
				</c:if>
				<!-- 변수 준비 여기까지 -->
			
				<!-- 폼태그 여기서부터 시작 -->
				<form action="cBoardReply.do" method="post" enctype="multipart/form-data" id="cwForm">
					<input type="hidden" name="cId" value="${ custBoard.cId }">
				    <input type="hidden" name="page" value="${ currentPage }">
				    <input type="hidden" name="uuid" value="${ sessionScope.loginMember.uuid }">
    
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
							<td><textarea id="cwContent" name="cContent" rows="15" style="width: 100%" required>[게시글 내용]
게시자ID : ${ custBoard.id }
분    류 : ${ categoryText }
제    목 : ${ custBoard.title }
내    용 : ${ custBoard.cContent }
========================================================================
</textarea></td>
						</tr>
						<tr>
							<td><label for="cwFile">첨부파일</label></td>
							<td><input type="file" id="cwFile" name="cfile" style="width: 400px;"></td>
						</tr>
					</table>
					<br>
					<div id="cwBtn">
						<input type="button" value="이전페이지" onclick="javascript:history.go(-1);">
						<input type="button" value="목록"
							onclick="javascript:location.href='adminCustBoard.do?page=${ currentPage }';">
						<input type="submit" value="글등록">
					</div>			
				</form>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>