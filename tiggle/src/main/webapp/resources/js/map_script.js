var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
	center : new kakao.maps.LatLng(37.5663174209601, 126.977829174031), // 지도의 중심좌표
	level : 5
// 지도의 확대 레벨
};
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

console.log(lat);
console.log(lon);
console.log(keyword);

// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
	navigator.geolocation.getCurrentPosition(function(position) {
		
		if (keyword == null || keyword === "") {
			lat = position.coords.latitude; // 위도
			lon = position.coords.longitude; // 경도
		}
		
		var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치
		message = '<div style="padding:5px;">내 위치</div>'; // 인포윈도우에 표시될 내용

		displayMarker(locPosition, message);

		// 위치 정보를 얻은 후에 전시회와의 거리를 계산하고 마커를 표시
		displayExhibitions();
	});
} else {
	var locPosition = new kakao.maps.LatLng(37.5663174209601, 126.977829174031), message = 'geolocation을 사용할수 없어요..';
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

// 하버사인 공식을 이용해 두 좌표 간 거리를 계산하는 함수
function haversine(lat1, lon1, lat2, lon2) {
    var R = 6371e3; // 지구의 반지름 (미터)
    var φ1 = lat1 * Math.PI / 180; // 위도1 라디안
    var φ2 = lat2 * Math.PI / 180; // 위도2 라디안
    var Δφ = (lat2 - lat1) * Math.PI / 180; // 위도 차이
    var Δλ = (lon2 - lon1) * Math.PI / 180; // 경도 차이

    var a = Math.sin(Δφ / 2) * Math.sin(Δφ / 2) +
            Math.cos(φ1) * Math.cos(φ2) *
            Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    var d = R * c;
    return d / 1000; // km로 반환
}

// 위치 정보를 받은 후에 전시회와의 거리를 계산하고 마커를 표시하는 함수
function displayExhibitions() {
	var exhibitListContainer = document.getElementById("exhibit-list"); // 전시회 목록을 뷰에 표시할 컨테이너	

	for (var i = 0; i < positions.length; i++) {
		var exhibitionLat = positions[i].latitude;
        var exhibitionLon = positions[i].longitude;
        
     	// 사용자의 위치와 전시회의 위치 간 거리를 계산
        var distance = haversine(lat, lon, exhibitionLat, exhibitionLon);
     	
     	// 거리가 3km 이하인 경우만 마커를 표시
     	if (distance <= 3) {
     		console.log(positions[i].content + "전시회와의 거리: " + distance + "km");
			
			var marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[i].latlng
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
					makeOutListener(infowindow)); //여기까지가 맵 내보내기
					
			// -----------------------------------------------------------------------------
			
			// 전시회 정보를 HTML에 동적으로 추가
            var exhibitContainer = document.createElement("div");
            exhibitContainer.classList.add("exhibition-item");

            // 포스터 추가
            var posterDiv = document.createElement("div");
            posterDiv.classList.add("exhibition-poster");
            posterDiv.innerHTML = '<img src="' + positions[i].poster + '" alt="포스터">'; // 포스터 이미지 삽입

            // 요약 정보 추가
            var summaryDetailsDiv = document.createElement("div");
            summaryDetailsDiv.classList.add("summary-details");

            var summaryDiv = document.createElement("div");
            summaryDiv.classList.add("exhibition-summary");
            summaryDiv.textContent = positions[i].summary; // 요약 정보 삽입

            var detailsButton = document.createElement("button");
            detailsButton.classList.add("exhibition-btn");
            detailsButton.innerHTML = '<a href="exhibitionDetail.do?no=' + positions[i].totalId + '">상세보기</a>';

            // 요소들 연결
            summaryDetailsDiv.appendChild(summaryDiv);
            summaryDetailsDiv.appendChild(detailsButton);
            exhibitContainer.appendChild(posterDiv);
            exhibitContainer.appendChild(summaryDetailsDiv);

            // 전시회 컨테이너를 전시회 목록에 추가
            exhibitListContainer.appendChild(exhibitContainer);
		}
	}
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