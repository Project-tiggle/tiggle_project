<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
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
				<p>1:1문의내역 (관리자용)</p>
			</div>
			<!-- myinfo_title end -->

			<div class="myinfo_wrap">
				<table>
					<thead>
						<tr>
							<th align="center">No</th>
							<th align="center">처리상태</th>
							<th align="center">제목</th>
							<th align="center">첨부파일</th>
							<th align="center">등록일</th>
							<th align="center">관리</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ requestScope.list }" var="list">
							<tr>
								<td align="center">${ list.cId }</td>
								<td align="center">
									<c:if test=""><b>답변대기</b></c:if>
									<c:if test="">답변완료</c:if>
								</td>
								<td align="center">${ list.title }</td>
								<td align="center">${ list.fileUrl }</td>
								<td align="center">${ list.createdAt }</td>
								<td align="center">미완</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



			</div>
			<!-- myinfo_wrap end -->
		</div>
		<!-- myinfo_content end -->
	</div>
	<!-- myinfo_section end -->
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>