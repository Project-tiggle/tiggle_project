<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 상세 보기</title>
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/custBoard_style.css">

<c:url var="replyf" value="custReply.do">
	<c:param name="cId" value="${ custBoard.cId }" />
	<c:param name="page" value="${ currentPage }" />
</c:url>

<script type="text/javascript">

function requestReply(){
	location.href = "${ replyf }";
}

</script>
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
				<p>1:1문의 ${ cId }번 글 상세 (관리자용)</p>
			</div>
			<!-- myinfo_title end -->

			<div id="custDetail">
				<h2 id="custTitle">[글제목] ${ custBoard.title }</h2>

				<table id="custInfoTable">
					<tr>
						<th>회원ID</th>
						<td style="padding-left: 15px; text-align: left;">${ custBoard.id }</td>
						<th>등록일</th>
						<td>${ custBoard.createdAt }</td>
						<th>수정일</th>
						<c:if test="${ empty custBoard.updatedAt }">
							<td>-</td>
						</c:if>
						<c:if test="${ !empty custBoard.updatedAt }">
							<td>${ custBoard.updatedAt }</td>
						</c:if>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="5" style="padding-left: 15px; text-align: left;">
							<c:if test="${ empty custBoard.fileUrl }">첨부파일 없음</c:if>
							<c:if test="${ !empty custBoard.fileUrl }">
								<a href="${pageContext.request.contextPath}/resources/custboard_upfiles/${ custBoard.fileUrl }" download>${ custBoard.fileUrl }
							</c:if>
						</td>
					</tr>
				</table>

				<div id="custContent">
					<textarea rows="15" style="font-size: 15px; line-heigth: 1.5; line-height: unset; width: 100%" readonly>${ custBoard.cContent }</textarea>
				</div>

				<div id="custActions">
					<c:if test="${ custBoard.cLev eq 1 and custBoard.updatedYn eq 'N' }">
						<button id="reBtn" onclick="requestReply(); return false;">문의글 답변하기</button>
					</c:if>
					<button onclick="javascript:location.href='adminCustBoard.do?page=${ currentPage }';">목록</button>
					<button onclick="alert('삭제 기능은 준비 중입니다.'); return false">삭제</button>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
