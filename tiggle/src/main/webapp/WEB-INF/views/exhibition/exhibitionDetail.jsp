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

<style type="text/css">
button{
	font-family: "Pretendard Variable", Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
}

.esection{
	max-width: 1280px;
	margin: 0 auto;
}

.navList{
	display: flex;
	width: 100%;
}

#exhibitionDetailMenu nav ul li{
	width: 250px;
	font-size: 16pt;
	float: left;
	font-weight: bold;
	text-align: center;
}

#exhibitionDetailMenu nav ul li a:hover{
	width: 250px;
	font-size: 16pt;
	float: left;
	text-align: center;
	font-weight: bolder;
	background: lightgray;
}

#titlediv {
	display: block;
}

.detail {
	display: flex;
	justify-content: space-between;
	width: 100%;
	margin: 60px auto;
}

.detailc{
	/* display: inline-block; */
	width: 500px;
}

div.sdiv {
	border: 3px black;
	background: lightgray;
	width: 200x;
	width-max: 1280px;
	left: 450px;
	margin: 10px 0 0 0; 
	display: none;	/* 기본적으로 안 보이게 함*/
}

#Edtail {
	width: 300px;
	margin: 0 auto;
	display: block;
	object-fit: cover;
}
		
#reserve_b{
	width: 100px;
	height: 50px;
	font-size: 16pt;
	border: 0.5px solid lightgray; 
	font-weight: bold;
}



</style>

<script type="text/javascript" src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
<script src="/tiggle/resources/js/script.js"></script>
<script type="text/javascript">
$(function(){
	$('.navLink').eq(0).css('display', 'block');
	$('.sdiv').eq(0).css('display', 'block');
});// document.ready

function showdiv(tag){
	if($(tag).attr("id") == "div1" ){
		$('.sdiv').eq(0).css('display', 'block');
		$('.sdiv').eq(1).css('display', 'none');
		$('.sdiv').eq(2).css('display', 'none');
	}
	if($(tag).attr("id") == "div2"  ){
		$('.sdiv').eq(0).css('display', 'none');
		$('.sdiv').eq(1).css('display', 'block');
		$('.sdiv').eq(2).css('display', 'none');
	}
	if($(tag).attr("id") == "div3"  ){
		$('.sdiv').eq(0).css('display', 'none');
		$('.sdiv').eq(1).css('display', 'none'); 
		$('.sdiv').eq(2).css('display', 'block');
	}
	
	

}

function rvPopupOpen() {
	  // 팝업을 띄울 페이지 URL
	  var popupURL = "rvmove.do";
	  // 팝업 창의 속성
	  var popupProperties = "width=600,height=400,scrollbars=no,left=600,top=200,location=no";
	  // 팝업 열기
	  window.open(popupURL, "Popup", popupProperties);
	}

function rePopupOpen() {
	  // 팝업을 띄울 페이지 URL
	  var popupURL = "remove.do";
	  // 팝업 창의 속성
	  var popupProperties = "width=600,height=400,scrollbars=no,left=600,top=200,location=no";
	  // 팝업 열기
	  window.open(popupURL, "Popup", popupProperties);
	}

</script>


</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	
	<!-- main section start -->

	<div class="main" >
	<section class="esection">	
		<div class="detail"> 
			<div class="detailc">
				<img id="Edtail" src="${ exhibition.fileUrl }">
			</div>		
			<div class="detailc" >
				<h1> ${ exhibition.title } </h1><br>
				<p>기간 :<br>
				 ${ exhibition.startDate } ~ ${ exhibition.endDate }<br><br>
				 장소 : <br>
				 ${ exhibition.contributor }
				 </p><br>
				 
				<button id="reserve_b" onclick="rePopupOpen()">예매하기</button>
			</div>
		</div>
		<div id="exhibitionDetailMenu">
			<nav class="nav" >
				<ul class="navList" style="align-items: center;">
					<li class="navitem is-active">
						<a id="div1" class="navLink" href="#" onclick="showdiv(this); return false" >상세 정보</a>
					</li>
					<li class="navitem">
						<a id="div2" class="navLink" href="#" onclick="showdiv(this); return false">한줄평</a>
					</li>
					<li class="navitem">
						<a id="div3" class="navLink" href="#" onclick="showdiv(this); return false">오시는 길</a>
					</li>
				</ul>			
			</nav>
		</div>
	<br style="clear: both;">

<%-- 상세정보 클릭시 출력될 폼 --%>
<div id="contentdiv" class="sdiv" >
	<input type="hidden" name="action" value="content">
	<fieldset>
		<h2>상세보기</h2>
		<div>
		<hr>
		소개 :  ${ exhibition.description }
		</div>
	</fieldset>
</div>

<%-- 한줄평 클릭시 출력될 폼 --%>
<div id="reviewdiv" class="sdiv">
	<input type="hidden" name="action" value="review">
	<fieldset>
		<h2>한줄평</h2>
		<button  onclick="rvPopupOpen()">등록</button>
		<div>
			한줄평 목록 출력
			
		</div>
	</fieldset>
</div>

<%-- 오시는길 클릭시 출력될 폼 --%>
<div  id="mapdiv" class="sdiv">
	<input type="hidden" name="action" value="date">
	<fieldset>
		<h2>오시는 길</h2>
		<div style="width: 600x; height: 450px; border: 1px red; background: green;">
			지도가 들어갈 공간
		</div>
	</fieldset>
</div>
		
	</section>
	</div>

	<!-- main section end -->


	<c:import url="/WEB-INF/views/common/footer.jsp" />


</body>
</html>


