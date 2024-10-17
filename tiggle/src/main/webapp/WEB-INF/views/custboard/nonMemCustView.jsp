<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>고객센터</title>

<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/custBoard_style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	<div id="cbMain">
		<div class="myinfo_title">
			<p>고객센터</p>
		</div>
		<!-- myinfo_title end -->

		<div id="boardTable">
			<table id="dataTable">
				<thead>
					<tr>
						<th align="center">No</th>
						<th align="center">제목</th>
						<th align="center">첨부파일</th>
						<th align="center">등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ requestScope.list }" var="list">
						<tr>
							<td align="center">${ list.cId }</td>

							<!-- 제목 -->
							<td style="text-align: left;"><c:url var="cDetail"
									value="custbDetail.do">
									<c:param name="cId" value="${ list.cId }" />
									<c:param name="page" value="${ currentPage }" />
								</c:url> <c:if test="${ list.cLev eq 1 }">
									<a href="#"> <c:if test="${ empty list.deletedAt }">
											<i class="fa-solid fa-lock"></i> &nbsp; <b>${ list.title }</b>
										</c:if> <c:if test="${ !empty list.deletedAt }">
												<i class="fa-solid fa-lock"></i> &nbsp; [${ list.deletedAt } 삭제] <del>${ list.title }</del>
										</c:if>
									</a>
								</c:if> <c:if test="${ list.cLev eq 2 }">
									<a href="#"> <c:if
											test="${ empty list.deletedAt }">
												<i class="fa-solid fa-lock"></i> &nbsp; &#x21B3; [Re:No.${ list.refNo }] ${ list.title }
											</c:if> <c:if test="${ !empty list.deletedAt }">
												<i class="fa-solid fa-lock"></i> &nbsp; &#x21B3; [Re:No.${ list.refNo }] <del>${ list.title }</del>
										</c:if>
									</a>
								</c:if></td>
							<!-- 제목 여기까지 -->

							<td align="center"><c:if test="${ empty list.fileUrl }"></c:if>
								<c:if test="${ !empty list.fileUrl }">
									<img src="/tiggle/resources/images/attach_file_icon.png"
										style="width: 24px; position: relative; top: 2px;">
								</c:if></td>

							<td align="center">${ list.createdAt }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div>
			<form action="noMemCbSearch.do" method="get" id="cbSearch">
				<select name="sOption" class="search_option">
					<option value="">검색</option>
					<option value="cbNo">번호</option>
					<option value="cbTitle">제목</option>
					<option value="cbId">아이디</option>
				</select> <input type="text" name="keyword"
					style="padding: 6px; border: 1px solid #ccc;"> <input
					type="submit" value="검색"
					style="padding: 6px; border: 1px solid #ccc;">
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/pagingSOptionView.jsp" />
	<br>
	<br>
	<br>
	<br>




	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>