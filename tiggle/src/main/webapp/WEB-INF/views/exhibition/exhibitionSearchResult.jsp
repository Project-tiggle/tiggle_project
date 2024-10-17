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

.poster{
	display: flex;
	width: 100%;
    justify-content: space-between;
    overflow: hidden !important;
}

.poster > a {
	display: block;
	width: 300px;
}

.poster > a > img {
	width: 100%;
	height: 300px;
	object-fit: cover;
}

.poster_p {
	width: 75%;
}
#title {
	width: 100%;
	margin-bottom: 60px;
	border-bottom: 2px solid #ff5f2c;
	padding-bottom: 30px;
}
.exhibition{
	width: 90%;
	max-width:1280px;
	margin: 60px auto;
}

.poster_p > p:nth-of-type(6) {
   height: 100px;
   overflow: hidden;
   text-align: justify;
   width: 100%;
   text-overflow: ellipsis;
   word-break: break-word;

   display: -webkit-box;
   -webkit-line-clamp: 3; 
   -webkit-box-orient: vertical;
}
.poster_p > p:nth-of-type(6) ~ p {
	display: none;
}
.poster_p > p img{
	display: none;
	
}
.t {
	font-weight: bold;
}
.poster_p > p > p{
	font-weight: normal !important;
}

.poster_p table {
	display: none;
}



</style>

</head>
<body>
<script type="text/javascript" src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	
	<!-- main section start -->
	<div class="exhibition">
		<h2 id=title>"${ keyword }" 에 대한 검색 결과</h2><br>
			 <c:forEach var="p" items="${ requestScope.list }">
       			 <div class="poster" >
		            <a href="exhibitionDetail.do?no=${ p.totalId }" ><img id="Emain" src="${ p.fileUrl }" ></a>
		            <div class="poster_p">
		            	<p><span class="t">제목 :</span> ${ p.title }</p>
		           		<p><span class="t">장소 :</span> ${ p.cntcInsttNm }</p>
			            <p><span class="t">기간 :</span> ${ p.startDate } ~ ${ p.endDate } </p>
			            <p><span class="t">입장료 :</span> ${ p.charge }</p>
			            <p><span class="t">내용</span> ${ p.description }</p> 
		            </div>
		        </div>
		    </c:forEach>
	</div>
	

	<!-- main section end -->


	<c:import url="/WEB-INF/views/common/pagingSearchView.jsp" />
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>

















