<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="nowpage" value="1" />
<c:if test="${ !empty requsetScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티글 공지사항</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/notice_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	
	<!-- notice_section start -->
	<div class="notice_section">
		<div class="notice_top">
			<div class="notice_title">
				<img src="/tiggle/resources/images/tiggle_logo.png">
				<p>공지사항</p>
				<p><span>티글</span>의 공지사항을 확인해보세요.</p>
			</div><!-- notice_title end -->
		</div><!-- notice_top end -->

		<div class="notice_wrap">
			<table class="notice_list">
				<tr>
					<td>No</td>
					<td>제목</td>
					<td>작성자</td>
					<td>첨부파일</td>
					<td>등록날짜</td>
				</tr>

				<c:forEach items="${ requestScope.list }" var="n">
					<tr>
						<td>${ n.nNo }</td>
						<td>
							<a href="${ pageContext.servletContext.contextPath }/ndetail.do?no=${ n.nNo }">${ n.nTitle }</a>
						</td>
						<td>${ n.nWriter }</td>
						<td>
							<c:if test="${ !empty n.nOriginalFilePath }">
								<img src="/tiggle/resources/images/attach_file_icon.png" style="width: 24px; position: relative; top: 2px;">
							</c:if>
							<c:if test="${ empty n.nOriginalFilePath }">&nbsp;</c:if>
						</td>
						<td>
							<fmt:formatDate value="${ n.nDate }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</table><!-- notice_list end -->
			
			<div class="notice_bt">
				<div class="nlist_search">
					<form action="nSearch.do" method="get" class="n_search_form" id="n_search_form">
						<select name="sOption" class="search_option">
							<option value="">검색</option>
							<option value="nNo">번호</option>
							<option value="nTitle">제목</option>
							<option value="nWriter">작성자</option>
						</select>
	
						<input type="text" name="keyword" class="search_input">
						<input type="submit" value="검색" class="search_btn">
					</form>
				</div><!-- mlist_search end -->

				<c:if test="${ !empty sessionScope.loginMember and loginMember.memberType eq 'ADMIN' }">
					<button class="n_write_btn" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveNWrite.do';">공지글 등록</button>
				</c:if>
			</div><!-- notice_bt end -->
			
			<div class="paging_wrap">
				<c:import url="/WEB-INF/views/common/pagingSOptionView.jsp" />
			</div><!-- paging_wrap end -->
		</div><!-- notice_wrap end -->
	</div><!-- notice_section end -->


	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/notice_script.js"></script>
</body>
</html>