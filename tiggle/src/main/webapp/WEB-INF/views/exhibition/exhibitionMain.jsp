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
	<c:if test="${ !empty sessionScope.loginMember && MemberType eq 'admin' }">
	<button ><a href="/tiggle/WEB-INF/views/exhibition/exhibitionInsert.jsp"></a> API 테스트 </button>
	<script type="text/javascript">
	$(function(){
		var jarr = new Array();
		var pStr = $('#p6').html();
		
		
		$('#addBtn').on('click', function(){
			// json 객체 만들기
			var job = new Object();
			job.title = $(this).find("TITLE").text());
			job.contributor = $(this).find("CONTRIBUTOR").text());
			job.description = $(this).find("DESCRIPTION").text());
			job.eventSite = $(this).find("EVENT_SITE").text());
			job.genre = $(this).find("GENRE").text());
			job.cotactPoint = $(this).find("CONTACT_POINT").text());
			job.url = $(this).find("URL").text());
			job.period = $(this).find("PERIOD").text());
			job.fileUrl = $(this).find("IMAGE_OBJECT").text());
			job.charge = $(this).find("CHARGE").text());
			
			
			
			jarr.push(job);
			
			pStr += JSON.stringify(job);
			$('#p6').html(pStr + '<br>');
			
			// 기존에 기록된 input 의 값은 지우기
			$('#ntitle').val('');
			$('#ncontent').val('');
		}); // addBtn click
		
		$('#test6').on('click', function(){
			$.ajax({
				url: 'test6.do',
				type: 'post',
				data: JSON.stringify(jarr),
				contentType: "application/json;",
				success: function(data){
					alert('요청 성공 :' + data)
				},
				error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임
					console.log("error code : " + request.status + "\nMessage : " + request.responseText
					+ "\nError : " + errorData );
				}
			}); // ajax
		}); // test6 click
	}); // document.ready

	</script>
	</c:if>
	<div class="exhibition"  style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: flex-start; padding:20px;">
		<table>
			 <c:forEach var="p" items="${ list }">
       			 <div class="poster" style="flex-basis: calc(20% - 20px);">
		            <a href="exhibitionDetail.do?no=${ p.totalId }" ><img id="Emain" src="${ p.fileUrl }" ></a>
		            <div class="poster_p">
		            	${ p.title }<br>
			            기간 : <br>
			            ${ p.startDate } ~ ${ p.endDate } <br>
		            </div>
		        </div>
		    </c:forEach>
		</table>
	</div>
	

	<!-- main section end -->


	<c:import url="/WEB-INF/views/common/pagingView.jsp" />
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>

















