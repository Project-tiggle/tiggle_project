<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>내 주변 전시</title>
<script type="text/javascript" src="${ link }"></script>
<link href="/tiggle/resources/css/map_style.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	<script> 
		var lat = "${searchLat}" !== "" ? parseFloat("${searchLat}") : null;
		var lon = "${searchLon}" !== "" ? parseFloat("${searchLon}") : null;
		var keyword = "${keyword}";
		
		var positions = new Array();
		
		<c:forEach var="exhibit" items="${exList}" varStatus="status">
	        positions.push({
	        	totalId: '${ exhibit.totalId }',
	            content: '<div>${ exhibit.title }</div>',
	            latitude: ${ exhibit.latitude},
	            longitude: ${ exhibit.longitude },
	            latlng : new kakao.maps.LatLng(${ exhibit.latitude }, ${ exhibit.longitude }),
	            poster: '${ exhibit.fileUrl }',
	            summary: '${ exhibit.eDescription }'
	        });
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
						<input type="search" name="keyword" size="50">
						<input type="submit" value="Search">
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
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>