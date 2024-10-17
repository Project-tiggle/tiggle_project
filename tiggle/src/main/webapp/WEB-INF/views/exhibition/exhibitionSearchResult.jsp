<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tiggle</title>
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
	<div class="exhibition"  style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: flex-start; padding:20px;">
		<h2>"${ keyword }" 에 대한 검색 결과.</h2><br>
		<table>
			 <c:forEach var="p" items="${ requestScope.list }">
       			 <div class="poster" style="flex-basis: calc(20% - 20px);">
		            <a href="exhibitionDetail.do?no=${ p.totalId }" ><img id="Emain" src="${ p.fileUrl }" ></a>
		            <div class="poster_p">
		            	제목 : ${ p.title }<br>
		           		장소 : ${ p.cntcInsttNm }<br>
			            기간 : ${ p.startDate } ~ ${ p.endDate } <br>
			            입장료 : ${ p.charge } <br>
		            </div>
		        </div>
		    </c:forEach>
		</table>
	</div>
	

	<!-- main section end -->


	<c:import url="/WEB-INF/views/common/pagingSearchView.jsp" />
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>

















