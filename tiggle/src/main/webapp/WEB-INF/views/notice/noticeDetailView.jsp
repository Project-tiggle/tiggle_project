<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/notice_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	
	<!-- notice_section start -->
	<div class="notice_section">
		<div class="n_detail_title">
			<p><span>공지사항</span>${ notice.nTitle }</p>
			<div class="nd_title_p">
				<p>
					<span>등록일</span>
					<fmt:formatDate value="${ notice.nDate }" pattern="yyyy-MM-dd" />
				</p>
				<p>
					<span>조회수</span>${ notice.nReadCount }
				</p>
			</div>
		</div><!-- n_detail_title end -->
		
		<div class="n_detail_wrap">
			<div class="nd_attach_wrap">
				<p>첨부파일 &nbsp;&nbsp;:</p>
				<div class="nd_attach">
					<c:url var="nfdown" value="nfdown.do">
						<c:param name="ofile" value="${ notice.nOriginalFilePath }" />
						<c:param name="rfile" value="${ notice.nRenameFilePath }" />
					</c:url>
					<c:if test="${ !empty notice.nOriginalFilePath }">
						<a href="${ nfdown }">${ notice.nOriginalFilePath }</a>
					</c:if>
					<c:if test="${ empty notice.nOriginalFilePath }">
						첨부 파일 없음
					</c:if>
				</div><!-- nd_attach end -->
			</div><!-- nd_attach_wrap end -->

			<div class="nd_content_wrap">
				<div class="nd_content">
					<!-- <textarea readonly><c:out value="${ notice.nContent }" /></textarea> -->
					<div style="white-space: pre;"><c:out value="${ notice.nContent }" /></div>
				</div><!-- nd_content end -->
			</div><!-- nd_content_wrap end -->
		</div><!-- n_detail_wrap end -->

		<div class="nd_btns">
			<button type="button" onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/nlist.do';">목록</button>
			<button type="button" onclick="javascript:history.go(-1);">이전</button>
		</div><!-- nd_btns end -->
	</div><!-- notice_section end -->


	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/notice_script.js"></script>
</body>
</html>