<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>내 주변 전시</title>
<script type="text/javascript"
	src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=e1972ed25349a231bccee750d03753b3"></script>
<link href="/tiggle/resources/css/map_style.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<h3>내 주변?</h3>
	<table>
		<!-- 위치검색 -->
		<tr>
			<td colspan="5" class="search-container">
				<input type="text"	placeholder="위치검색" id="location-search">
				<button class="search-btn">검색</button>
			</td>
		</tr>
		
		<!-- 지도 표시 -->
		<tr>
			<td colspan="5">
				<div id="map"></div>
			</td>
		</tr>
		
		<!-- 정렬 기준(위치, 랭킹) -->
		<tr>
			<td colspan="2">위치순</td>
			<td colspan="2">랭킹순</td>
		</tr>
	</table>

	<!-- 전시 정보 (2x2로 포스터와 상세정보를 배치) -->
	<div class="exhibit-grid">
		<!-- 전시 항목 1 -->
		<div class="exhibit-container">
			<div class="poster">포스터 2</div>
			<div class="summary-details">
				<div class="summary">요약 정보 2</div>
				<button class="details-btn">상세보기</button>
			</div>
		</div>

		<!-- 전시 항목 2 -->
		<div class="exhibit-container">
			<div class="poster">포스터 2</div>
			<div class="summary-details">
				<div class="summary">요약 정보 2</div>
				<button class="details-btn">상세보기</button>
			</div>
		</div>

		<!-- 전시 항목 3 -->
		<div class="exhibit-container">
			<div class="poster">포스터 3</div>
			<div class="summary-details">
				<div class="summary">요약 정보 3</div>
				<button class="details-btn">상세보기</button>
			</div>
		</div>

		<!-- 전시 항목 4 -->
		<div class="exhibit-container">
			<div class="poster">포스터 4</div>
			<div class="summary-details">
				<div class="summary">요약 정보 4</div>
				<button class="details-btn">상세보기</button>
			</div>
		</div>
	</div>

	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 5
		// 지도의 확대 레벨
		};
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var lat = position.coords.latitude, // 위도
				lon = position.coords.longitude; // 경도
				var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치
				message = '<div style="padding:5px;">내 위치</div>'; // 인포윈도우에 표시될 내용

				displayMarker(locPosition, message);
			});
		} else {
			var locPosition = new kakao.maps.LatLng(33.450701, 126.570667), message = 'geolocation을 사용할수 없어요..';
			displayMarker(locPosition, message);
		}

		function displayMarker(locPosition, message) {
			var marker = new kakao.maps.Marker({
				map : map,
				position : locPosition
			});

			var infowindow = new kakao.maps.InfoWindow({
				content : message,
				removable : true
			});
			infowindow.open(map, marker);
			map.setCenter(locPosition);
		}
		// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
		var positions = [ {
			content : '<div>카카오</div>',
			latlng : new kakao.maps.LatLng(33.450705, 126.570677)
		}, {
			content : '<div>생태연못</div>',
			latlng : new kakao.maps.LatLng(33.450936, 126.569477)
		}, {
			content : '<div>텃밭</div>',
			latlng : new kakao.maps.LatLng(33.450879, 126.569940)
		}, {
			content : '<div>근린공원</div>',
			latlng : new kakao.maps.LatLng(33.451393, 126.570738)
		} ];

		for (var i = 0; i < positions.length; i++) {
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[i].latlng
			// 마커의 위치
			});

			// 마커에 표시할 인포윈도우를 생성합니다 
			var infowindow = new kakao.maps.InfoWindow({
				content : positions[i].content
			// 인포윈도우에 표시할 내용
			});

			// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
			// 이벤트 리스너로는 클로저를 만들어 등록합니다 
			// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
			kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(
					map, marker, infowindow));
			kakao.maps.event.addListener(marker, 'mouseout',
					makeOutListener(infowindow));
		}

		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
			return function() {
				infowindow.open(map, marker);
			};
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
			return function() {
				infowindow.close();
			};
		}
	</script>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
