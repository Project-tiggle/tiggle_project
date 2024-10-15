<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<p>1:1문의 (관리자용)</p>
			</div>
			<!-- myinfo_title end -->

			<div id="boardTable">
				<table id="dataTable">
					<thead>
						<tr>
							<th align="center">No</th>
							<th align="center">처리상태</th>
							<th align="center">제목</th>
							<th align="center">첨부파일</th>
							<th align="center">작성자</th>
							<th align="center">등록일</th>
							<th align="center">수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ requestScope.list }" var="list">
							<tr>
								<td align="center">${ list.cId }</td>
																
								<td align="center">
									<c:if test="${ list.replyYn eq 'N' and empty list.deletedAt }">
										<b style="color: #ff5f2c;">답변대기</b>
									</c:if>
								</td>
								
								<!-- 제목 -->
								<td style="text-align: left;">
									<c:url var="cDetail" value="custbDetail.do">
										<c:param name="cId" value="${ list.cId }" />
										<c:param name="page" value="${ currentPage }" />
									</c:url>
									
									<c:if test="${ list.cLev eq 1 }">
										<a href="${ cDetail }">
											<c:if test="${ empty list.deletedAt }">
												<b>${ list.title }</b>
											</c:if>
											<c:if test="${ !empty list.deletedAt }">
												[${ list.deletedAt } 삭제] <del>${ list.title }</del>
											</c:if>
										</a>
									</c:if>
									<c:if test="${ list.cLev eq 2 }">
										<a href="${ cDetail }">
											<c:if test="${ empty list.deletedAt }">
												&#x21B3; [Re:No.${ list.refNo }] ${ list.title }
											</c:if>
											<c:if test="${ !empty list.deletedAt }">
												&#x21B3; [Re:No.${ list.refNo }] <del>${ list.title }</del>
											</c:if>
										</a>
									</c:if>
								</td>
								<!-- 제목 여기까지 -->
								
								<td align="center">
									<c:if test="${ empty list.fileUrl }"></c:if>
									<c:if test="${ !empty list.fileUrl }">
										<img src="/tiggle/resources/images/attach_file_icon.png" style="width: 24px; position: relative; top: 2px;">
									</c:if>
								</td>

								<td align="center">${ list.id }</td>
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