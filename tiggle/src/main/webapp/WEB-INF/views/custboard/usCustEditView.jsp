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

	<!-- 마이페이지 회원정보 수정 -->
	<div class="myinfo_section">
		<aside class="myinfo_aside">
			<div class="mypage_title">
				<p>마이페이지</p>
			</div>
			<!-- mypage_title -->

			<nav>
				<ul class="left_menu">
					<li><a
						href="myInfo.do?uuid=${ sessionScope.loginMember.uuid }">내정보
							보기</a></li>
					<li><a href="#">예약확인 / 취소</a></li>
					<li><a href="userCustBoard.do">1:1 문의내역</a></li>
					<li><a href="delMemPage.do">회원탈퇴</a></li>
				</ul>
				<!-- left_ menu end -->
			</nav>
		</aside>
		<!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<p>1 : 1 문의</p>
			</div>
			<!-- myinfo_title end -->

			<div id="cwCon">
				<form action="usCbUp.do" method="post" enctype="multipart/form-data" id="cwForm">
					<input type="hidden" name="cId" value="${ custBoard.cId }">
				    <input type="hidden" name="page" value="${ currentPage }">
				    <input type="hidden" name="uuid" value="${ sessionScope.loginMember.uuid }">
				    <input type="hidden" name="saveFile" value="${ custBoard.fileUrl }">
    
					<table id="cwFormTable">
						<tr>
							<td><label for="cwTitle">제목</label></td>
							<td><input type="text" id="cwTitle" name="title" style="width: 90%;"
								value="${ custBoard.title }">
							</td>
						</tr>
						<tr>
							<td><label for="cwCategory">분야</label></td>
							<td>
								<select id="cwCategory" name="cCategory" style="width: 20%;">
									<c:if test="${ custBoard.cCategory eq 1 }">
										<option value="1" selected>전시회</option>
										<option value="2">박람회</option>
									</c:if>
									<c:if test="${ custBoard.cCategory eq 2 }">
										<option value="1">전시회</option>
										<option value="2" selected>박람회</option>
									</c:if>
								</select>
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
							onclick="javascript:location.href='userCustBoard.do?page=${ currentPage }';">
						<input type="submit" value="글수정">
					</div>			
				</form>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>