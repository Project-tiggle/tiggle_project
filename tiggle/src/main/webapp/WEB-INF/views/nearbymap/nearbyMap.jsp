<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>내 주변 전시</title>
<script type="text/javascript" src="${ link }"></script>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/map_style.css">

<style type="text/css">

/* 전시회 항목 전체 레이아웃 */
.exhibition-item {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    width: 50%;
    padding: 20px;
    border: 1px solid #ccc;
    box-sizing: border-box;
    margin: 0 auto;
    max-width: 640px;
}

.exhibition-poster {
	height: 330px;
	width: 230px;
}

/* 포스터 이미지 크기 */
.exhibition-poster img {
    width: 100%;
    height: 100%;
    object-fit: cover !important;
    display: block;
}

/* 전시회 정보 영역 */
.exhibition-details {
    flex: 1;
    margin-left: 20px;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    width: 60%;
    height: 330px;
    position: relative;
}

/* 전시회 제목 스타일 */
.exhibition-title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 20px;
}

/* 전시회 cntc 스타일 */
.exhibition-contact, .exhibition-period {
    font-size: 16px;
    color: #666;
    margin-bottom: 10px;
}

/* 상세보기 버튼 */
.exhibition-btn {
    margin-top: 0px; /* 버튼이 아래쪽으로 밀리도록 설정 */
    height: 45px;
    line-height: 45px;
    font-weight: bold;
    font-family: "Pretendard Variable", Pretendard, sans-selif;
    letter-spacing: 1px;
    border: none;
    background-color: #eee;
    font-size: 18px;
    cursor: pointer;
    width: 100%;
    align-self: center;
    position: absolute;
    bottom: 0px;
    transition: all 0.2s;
}

/* 버튼에 호버 효과 */
.exhibition-btn:hover {
    background-color: #ff5f2c;
    color:white;
}

/* 링크 스타일 제거 */
.exhibition-btn a {
    text-decoration: none;
}
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	<script> 
		var lat = "${searchLat}" !== "" ? parseFloat("${searchLat}") : null;
		var lon = "${searchLon}" !== "" ? parseFloat("${searchLon}") : null;
		var keyword = "${keyword}";
		
		var positions = new Array();
		
		<c:forEach var="exhibit" items="${exList}" varStatus="status">
	        
			<c:if test="${exhibit.fileUrl.toUpperCase().startsWith('H')}">
				positions.push({
		        	totalId: '${ exhibit.totalId }',
		            content: '<div>${ exhibit.title }</div>',
		            latitude: ${ exhibit.latitude},
		            longitude: ${ exhibit.longitude },
		            latlng : new kakao.maps.LatLng(${ exhibit.latitude }, ${ exhibit.longitude }),
		            poster: '${exhibit.fileUrl}',
		            title: '${ exhibit.title }',
		            cntc: '${ exhibit.cntcInsttNm }',
		            perido: '${ exhibit.preiod }'
		        });
			</c:if>
			
			<c:if test="${!exhibit.fileUrl.toUpperCase().startsWith('H')}">
				positions.push({
		        	totalId: '${ exhibit.totalId }',
		            content: '<div>${ exhibit.title }</div>',
		            latitude: ${ exhibit.latitude},
		            longitude: ${ exhibit.longitude },
		            latlng : new kakao.maps.LatLng(${ exhibit.latitude }, ${ exhibit.longitude }),
		            poster: '${pageContext.request.contextPath}/resources/exhibit_upfiles/${exhibit.fileUrl}',
		            title: '${ exhibit.title }',
		            cntc: '${ exhibit.cntcInsttNm }',
		            perido: '${ exhibit.preiod }'
		        });
			</c:if>
				
	  	</c:forEach>
  	</script>
  	<div id="mapOuter">
	  	<table>
	  		<tr>
	  			<td><h2 id="mapTitle">내 주변 전시</h2></td>
	  		</tr>
			<tr>
				<td colspan="5" class="search-container">
					<form action="nearbyMap.do" id="titleform" class="sform" method="get">
						<input type="search" name="keyword" size="50" placeholder="검색한 주소의 주변 전시가 보여집니다">
						<input type="submit" value="검색">
					</form>
				</td>
			</tr>
	
			<tr id="mapOuter">
				<td colspan="5">
					<div id="map"><!-- 카카오 지도 표시 --></div>
				</td>
			</tr>
		</table>
	
		
	    <div id="exhibit-list" class="exhibit-grid"><!-- 전시회 목록 l --></div>
	</div>
	<script src="/tiggle/resources/js/map_script.js"></script>	
	
	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>