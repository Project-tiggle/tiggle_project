<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오시는 길</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
</head>
<body>
	<!-- 이미지 지도를 표시할 div 입니다 -->
	<div id="staticMap" style="width: 100%; height: 450px;"></div>

	<script type="text/javascript" src="${ link }"></script>
	<script>
		var lat = "${searchLat}" !== "" ? parseFloat("${searchLat}") : null;
		var lon = "${searchLon}" !== "" ? parseFloat("${searchLon}") : null;
		// 이미지 지도에서 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(lat, lon);

		// 이미지 지도에 표시할 마커입니다
		// 이미지 지도에 표시할 마커는 Object 형태입니다
		var marker = {
			position : markerPosition
		};

		var staticMapContainer = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
		staticMapOption = {
			center : new kakao.maps.LatLng(lat, lon), // 이미지 지도의 중심좌표
			level : 5, // 이미지 지도의 확대 레벨
			marker : marker
		// 이미지 지도에 표시할 마커 
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
	</script>
</body>
</html>