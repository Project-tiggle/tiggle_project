<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">

<title>게시물 상세 보기</title>

<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/custBoard_style.css">

<c:url var="cbdel" value="usCustDelete.do">
	<c:param name="refNo" value="${ custBoard.refNo }" />
</c:url>

<c:url var="cbup" value="custUpView.do">
	<c:param name="cId" value="${ custBoard.cId }" />
	<c:param name="page" value="${ currentPage }" />
</c:url>

<script type="text/javascript">

	function requestDelete() {
		location.href = "${ cbdel }";
	}

	function requestUpdatePage() {
		location.href = "${ cbup }";
	}

	</script>
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
				<p>1:1문의 ${ cId }번 글 상세</p>
			</div>
			<!-- myinfo_title end -->

			<div id="custDetail">
				<h2 id="custTitle">[글제목] ${ custBoard.title }</h2>

				<table id="custInfoTable">
					<tr>
						<th>회원ID</th>
						<td>${ custBoard.id }</td>
						<th>등록일</th>
						<td style="padding-left: 15px; text-align: left;">${ custBoard.createdAt }</td>
						<th>수정일</th>
						<c:if test="${ empty custBoard.updatedAt }">
							<td>-</td>
						</c:if>
						<c:if test="${ !empty custBoard.updatedAt }">
							<td style="padding-left: 15px; text-align: left;">${ custBoard.updatedAt }</td>
						</c:if>
					</tr>
					<tr>
						<th>분류</th>
						<td>
							<c:if test="${ custBoard.cCategory eq '1' }">전시회</c:if>
							<c:if test="${ custBoard.cCategory eq '2' }">박람회</c:if>
						</td>
						<th>첨부파일</th>
						<td colspan="3" style="padding-left: 15px; text-align: left;">
							<c:url var="custfdown" value="custfDown.do">
								<c:param name="sfile" value="${ custBoard.fileUrl }" />
							</c:url> 
							<c:if test="${ empty custBoard.fileUrl }">첨부 파일 없음</c:if>
							<c:if test="${ !empty custBoard.fileUrl }">
								<a href="${ custfdown }">${ originalFileName }</a>
							</c:if>
						</td>
					</tr>
				</table>

				<div id="custContent">
					<%-- <textarea rows="15"
						style="font-size: 15px; line-heigth: 1.5; line-height: unset; width: 100%"
						readonly>${ custBoard.cContent }</textarea> --%>
					<div style="white-space: pre;"><c:out value="${ custBoard.cContent }" /></div>
				</div>

				<div id="custActions">
					<button onclick="javascript:location.href='userCustBoard.do?page=${ currentPage }';">목록</button>
					<%-- 게시글을 적은 id와 로그인세션에 저장되어있는 id가 같을때 활성화 --%>
					<c:if test="${ custBoard.id eq sessionScope.loginMember.id }">
						<button onclick="#">수정</button>
						<button onclick="requestDelete(); return false;">삭제</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
