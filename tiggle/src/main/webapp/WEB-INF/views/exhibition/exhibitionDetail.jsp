<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전시회 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable-dynamic-subset.min.css" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/exhibition_style.css">

<style type="text/css">
button {
	font-family: "Pretendard Variable", Pretendard, -apple-system,
		BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI",
		"Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic",
		"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
}

.esection {
	max-width: 1280px;
	margin: 0 auto;
}

.navList {
	display: flex;
	width: 100%;
}

#exhibitionDetailMenu nav ul li {
	width: 150px;
	font-size: 16pt;
	float: left;
	font-weight: bold;
	text-align: center;
}

#exhibitionDetailMenu nav ul li a {
	font-weight: bold;
	font-size: 30px;
	text-decoration: none;
	margin-right: 10px;
	color: #000;
	position: relative;
}

#exhibitionDetailMenu nav ul li a::before {
	content: "";
	height: 5px;
	width: 0;
	background-color: #fff;
	border-radius: 10px;
	transition: 0.3s;
	position: absolute;
	bottom: -4px;
	left: 48%;
}

#exhibitionDetailMenu nav ul li a:hover::before {
	width: 50%;
	background-color: #ff5f2c;
}

#exhibitionDetailMenu nav ul li a:hover {
	color: #ff5f2c;
}

#exhibitionDetailMenu nav ul li a::after {
	content: "";
	height: 5px;
	width: 0;
	background-color: #fff;
	border-radius: 10px;
	transition: 0.3s;
	position: absolute;
	bottom: -4px;
	right: 48%;
}

#exhibitionDetailMenu nav ul li a:hover::after {
	width: 50%;
	background-color: #ff5f2c;
}

#exhibitionDetailMenu nav ul li a:focus {
	width: 100%;
	color: #ff5f2c;
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

.detailc {
	/* display: inline-block; */
	width: 600px;
}

div.sdiv {
	border: 1px ligntgray;
	width: 150x;
	width-max: 1280px;
	left: 450px;
	margin: 10px 0 0 0;
	/* display: none; */ /* 기본적으로 안 보이게 함. 활성화시 지도로딩 막힘*/
}

#Edtail {
	width: 300px;
	margin: 0 auto;
	display: block;
	object-fit: cover;
}

#guide_b {
	width: 170px;
	height: 30px;
	font-size: 14pt;
	font-weight: bolder;
	color: #ff5f2c;
}

.review_t td {
	border-top: 1px solid lightgray;
}

</style>

<script type="text/javascript"
	src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
<script src="/tiggle/resources/js/script.js"></script>

<c:set var="currentPage" value="1" />
<c:if test="${ !empty currentPage }">
	<c:set var="currentPage" value="${ currentPage }" />
</c:if>
<script type="text/javascript">
/* $(function(){
	$('.sdiv').eq(0).css('display', 'block');
});// document.ready


} */
/* display none 이 비활성화 되면서 3개가 동시에 출력됨
 * 2번이나 3번 클릭시 펼쳐진 메뉴 사라짐이 확인됨
 * 그래서 페이지 로드시, 동시에 div1 클릭 처리 하면서 2번 3번 숨김처리함 */
$(function() {
    // 페이지 로드 시 첫 번째 탭을 자동으로 클릭한 것처럼 동작
    showdiv($('#div1'));

    // 탭 클릭 시 이벤트 처리
    $('#exhibitionDetailMenu nav ul li a').on('click', function(event) {
        event.preventDefault(); // 기본 클릭 동작 방지
        showdiv($(this)); // 클릭한 탭에 해당하는 콘텐츠 표시
    });

    // showdiv 함수
    function showdiv(tag) {
        if ($(tag).attr("id") == "div1") {
            $('.sdiv').eq(0).css('display', 'block');
            $('.sdiv').eq(1).css('display', 'none');
            $('.sdiv').eq(2).css('display', 'none');
        }
        if ($(tag).attr("id") == "div2") {
            $('.sdiv').eq(0).css('display', 'none');
            $('.sdiv').eq(1).css('display', 'block');
            $('.sdiv').eq(2).css('display', 'none');
        }
        if ($(tag).attr("id") == "div3") {
            $('.sdiv').eq(0).css('display', 'none');
            $('.sdiv').eq(1).css('display', 'none');
            $('.sdiv').eq(2).css('display', 'block');
        }
    }
});

function rviPopupOpen() {
	  // 팝업을 띄울 페이지 URL
	  var popupURL = "rvmove.do" + "?no=${ exhibition.totalId }";
	  // 팝업 창의 속성
	  var popupProperties = "width=600,height=400,scrollbars=no,left=600,top=200,location=no";
	  // 팝업 열기
	  window.open(popupURL, "Popup", popupProperties);
	}
	
function rvuPopupOpen() {
	  // 팝업을 띄울 페이지 URL
	  var popupURL = "rvmoveup.do?no=${ exhibition.totalId }&page=${ currentPage }";
	  // 팝업 창의 속성
	  var popupProperties = "width=600,height=400,scrollbars=no,left=600,top=200,location=no";
	  var dat
	  // 팝업 열기
	  window.open(popupURL, "Popup", popupProperties);
	    
	}

function rePopupOpen() {
	  // 이동할 페이지 URL
	  var popupURL = "remove.do?no=${ exhibition.totalId }";
	  // 팝업 창의 속성
	  var popupProperties = "width=600,height=400,scrollbars=no,left=600,top=200,location=no";
	}

function rvdPopupOpen(rN){
	var delYN = window.confirm('한줄평을 삭제하시겠습니까?')
	if(delYN == true){
		location.href="rdelete.do?rNum=" + rN + "&totalId=" + ${ exhibition.totalId };
	}
}

 function reload(){
    // 자신을 새로고침하는데, 100 : 0.1초 뒤에 새로고침을 진행하라는 함수
    // 서버에서 받을 
	setTimeout(function () {
    location.reload();
    }, 200); 
}

</script>


</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />


	<!-- main section start -->

	<div class="main">
		<section class="esection">
			<div class="detail">
				<div class="detailc">
					<c:if test="${exhibition.fileUrl.toUpperCase().startsWith('H')}">
		            	<img id="Edtail" src="${ exhibition.fileUrl }" >
		            </c:if>
       			 	<c:if test="${!exhibition.fileUrl.toUpperCase().startsWith('H')}">
		           		<img id="Edtail" src="${pageContext.request.contextPath}/resources/exhibit_upfiles/${exhibition.fileUrl}">
		            </c:if>
					
					<%-- <img id="Edtail" src="${ exhibition.fileUrl }"> --%>
				</div>
				<div class="detailc">
					<h1>${ exhibition.title }</h1>
					<br>
					<h3>기간</h3>
					<p>
					${ exhibition.startDate } ~ ${ exhibition.endDate }
					</p>
					<br>
					<h3>장소</h3>
					<p>
					${ exhibition.cntcInsttNm }
					</p>
					<br>
					<h3>입장료</h3>
					<p>
					${ exhibition.charge }
					</p>
					<br>
					<button id="guide_b">
						<a href="${ exhibition.url }">전시 안내페이지 이동</a>
					</button>
				</div>
			</div>
			<div id="exhibitionDetailMenu">
				<nav class="nav">
					<ul class="navList" style="align-items: center;">
						<li class="navitem is-active"><a id="div1" class="navLink"
							href="#" onclick="showdiv(this); return false">상세 정보</a></li>
						<li class="navitem"><a id="div2" class="navLink" href="#"
							onclick="showdiv(this); return false">한줄평</a></li>
						<li class="navitem"><a id="div3" class="navLink" href="#"
							onclick="showdiv(this); return false">오시는 길</a></li>
					</ul>
				</nav>
			</div>
			<br style="clear: both;">

			<%-- 상세정보 클릭시 출력될 폼 --%>
			<div id="contentdiv" class="sdiv" style="margin-bottom: 60px;">
				<input type="hidden" name="action" value="content" >
				<fieldset>
					<h2>상세보기</h2>
					<div>
						<hr>
						소개 ${ exhibition.description }
					</div>
				</fieldset>
			</div>

			<%-- 한줄평 클릭시 출력될 폼 --%>
			<div id="reviewdiv" class="sdiv" style="margin-bottom: 60px;">
				<input type="hidden" name="action" value="review">
						
				<fieldset>
					<div>
						<table class="review_t" align="center" width="1280"  cellspacing="0" cellpadding="0" >
							<tr>
								<th width="100px">번호</th>
								<th width="930px">내용</th>
								<th width="150px">작성날짜</th>
								<th width="100px">
									<c:if test="${ !empty sessionScope.loginMember and uuidCount eq 0 }"><button onclick="rviPopupOpen()">등록</button></c:if>
								</th>
							</tr>
							<c:forEach items="${ list }" var="rv">
								<c:set var="i" value="${ i + 1 }" />
								<tr>
									<c:if test="${ deleteYN != 'Y' }">
										<td align="center" >${ i }</td>
										<td align="left" >&nbsp; ${ rv.rContents }</td>
										<td align="center"><fmt:formatDate value="${ rv.writeDate }" pattern="yyyy-MM-dd" /></td>
										<td align="center" >
											<c:if test="${ !empty sessionScope.loginMember and rv.uuid eq sessionScope.loginMember.uuid }">
												<button onclick="rvuPopupOpen()">수정</button>
												<button onclick="rvdPopupOpen(${ rv.rNum })">삭제</button>
												<c:set var="writeflag" value="true" />
											</c:if>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</div>
				</fieldset>
			</div>

			<%-- 오시는길 클릭시 출력될 폼 --%>
			<div id="mapdiv" class="sdiv" style="margin-bottom: 60px;">
				<input type="hidden" name="action" value="date">
				<fieldset>
					<c:import url="/WEB-INF/views/exhibition/exhibitDirections.jsp" />
				</fieldset>
			</div>
		</section>
	</div>

	<!-- main section end -->
	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>

	<c:import url="/WEB-INF/views/common/footer.jsp" />


</body>
</html>


