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
<style type="text/css">

/* 게시판 테이블 스타일 */
#boardTable {
    width: 100%;
    margin: 20px auto;
    border-collapse: collapse;
}

#dataTable {
    width: 100%;
    border-left: none;
    border-right: none;
}

#dataTable th, #dataTable td {
    padding: 12px 15px;
    border-bottom: 1px solid #ddd;
    text-align: center;
}

#dataTable th {
    background-color: #f4f4f4;
    font-weight: bold;
    border-bottom: 2px solid #333;
}

#dataTable th, #dataTable td {
    border-left: none;
    border-right: none;
}

#dataTable tr:hover {
    background-color: #f1f1f1;
}

.status {
    font-weight: bold;
    color: #ff6b6b;
}

</style>
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

			<div id="boardTable">
				<table id="dataTable">
					<thead>
						<tr>
							<th align="center">No</th>
							<th align="center">처리상태</th>
							<th align="center">제목</th>
							<th align="center">작성자</th>
							<th align="center">첨부파일</th>
							<th align="center">등록일</th>
							<th align="center">수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ requestScope.list }" var="list">
							<tr>
								<td align="center">${ list.cId }</td>
								<td align="center"><span class="status"> 대기 <c:if
											test="">
											<b>대기</b>
										</c:if> <c:if test="">완료</c:if>
								</span></td>
								<td align="left">${ list.title }</td>
								<td align="center">${ list.uuid }</td>
								<td align="center">
									<c:if test="${ empty list.fileUrl }">없음</c:if>
									<c:if test="${ !empty list.fileUrl }"><b>있음</b></c:if></td>
								<td align="center">${ list.createdAt }</td>
								<td align="center">${ list.updatedAt }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<c:import url="/WEB-INF/views/common/pagingView.jsp" />
			<br><br><br><br>

			<!-- myinfo_wrap end -->
		</div>
		<!-- myinfo_content end -->
	</div>
	<!-- myinfo_section end -->
	

	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>