<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>1:1 문의</title>
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
				<p>1:1 문의 내역</p>
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

								<td align="center"><c:if test="${ list.replyYn eq 'Y' }">
										<b style="color: #ff5f2c;">답변완료</b>
									</c:if></td>

								<!-- 제목 -->
								<td style="text-align: left;"><c:url var="cDetail" value="usercDetail.do">
										<c:param name="cId" value="${ list.cId }" />
										<c:param name="page" value="${ currentPage }" />
									</c:url> <c:if test="${ list.cLev eq 1 }">
										<a href="${ cDetail }"><b>${ list.title }</b></a>
									</c:if> <c:if test="${ list.cLev eq 2 }">
										<a href="${ cDetail }">&#x21B3; [Re:No.${ list.refNo }] ${ list.title }</a>
									</c:if></td>
								<!-- 제목 여기까지 -->

								<td align="center"><c:if test="${ empty list.fileUrl }"></c:if>
									<c:if test="${ !empty list.fileUrl }">
										<img src="/tiggle/resources/images/attach_file_icon.png" style="width: 24px; position: relative; top: 2px;">
									</c:if></td>
								<td align="center">${ list.id }</td>
								<td align="center">${ list.createdAt }</td>
								<td align="center">${ list.updatedAt }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<input id="inquiryBtn" type="button" onclick="javascript:location.href='inquiry.do'" value="1:1 문의">
			<c:import url="/WEB-INF/views/common/pagingView.jsp" />
			<br> <br> <br> <br>


		</div>

	</div>


	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>