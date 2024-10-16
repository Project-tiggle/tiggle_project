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
		            poster: '${ exhibit.fileUrl }',
		            summary: '${ exhibit.eDescription }'
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
		            summary: '${ exhibit.eDescription }'
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
						<input type="submit" value="Search">
					</form>
				</td>
			</tr>
	
			<tr id="mapOuter">
				<td colspan="5">
					<div id="map"><!-- 카카오 지도 표시 --></div>
				</td>
			</tr>
			<tr><td><a href="directions.do">direction</a></td></tr>
		</table>
	
		
	    <div id="exhibit-list" class="exhibit-grid"><!-- 전시회 목록 l --></div>
	</div>
	<script src="/tiggle/resources/js/map_script.js"></script>	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>