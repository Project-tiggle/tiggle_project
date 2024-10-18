<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전시회 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable-dynamic-subset.min.css" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/exhibition_style.css">

<style>


.poster > a {
	display: block;
	width: 100%;
	height: 400px;
}

.poster > a > img {
	display: block;
	width: 100%;
	height: 90%;
	object-fit: cover;
}
.poster_p {
	position: relative;
	top: -25px;
}

</style>

</head>
<body>
<script type="text/javascript" src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	
	<!-- main section start -->
	<div class="exhibition"  style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: flex-start; padding:20px; margin-bottom: 60px;">
			 <c:forEach var="p" items="${ list }">
       			 <div class="poster" style="flex-basis: calc(20% - 20px);">
       			 	<c:if test="${p.fileUrl.toUpperCase().startsWith('H')}">
		            <a href="exhibitionDetail.do?no=${ p.totalId }" ><img id="Emain" src="${ p.fileUrl }" ></a>
		            </c:if>
       			 	<c:if test="${!p.fileUrl.toUpperCase().startsWith('H')}">
		            <a href="exhibitionDetail.do?no=${ p.totalId }" ><img id="Emain" src="${pageContext.request.contextPath}/resources/exhibit_upfiles/${p.fileUrl}"></a>
		            </c:if>
		            <div class="poster_p">
		            	${ p.title }<br>
			            ${ p.startDate } ~ ${ p.endDate } <br>
		            </div>
		        </div>
		    </c:forEach>
	<c:import url="/WEB-INF/views/common/pagingView.jsp" />
	</div>
	

	<!-- main section end -->


	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>

















