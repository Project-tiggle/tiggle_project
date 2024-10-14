<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tiggle</title>
</head>
<body>
<script type="text/javascript" src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
<script>
	/* Javascript Sample*/
	var xhr = new XMLHttpRequest();
	var url = 'http://api.kcisa.kr/openapi/API_CCA_145/request'; /*URL*/
	var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + 'fcdfe4b5-38d6-4592-8d63-7964b086465a'; /*서비스키*/
	queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('100'); /*세션당 요청레코드수*/
	queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /*페이지수*/
	
	xhr.open('GET', url + queryParams);
	xhr.onreadystatechange = function () {
	if (this.readyState == 4) {
	
	console.log('status: ' + this.status);
	console.log('resultCode: ' + $(this.responseText).find('resultCode').text());
	console.log('resultMsg: ' + $(this.responseText).find('resultMsg').text());
	
	var item = $(this.responseText).find('item');
	$(item).each(function(){
	
	console.log("TITLE" + $(this).find("TITLE").text());
	console.log("CNTC_INSTT_NM" + $(this).find("CNTC_INSTT_NM").text());
	console.log("COLLECTED_DATE" + $(this).find("COLLECTED_DATE").text());
	console.log("ISSUED_DATE" + $(this).find("ISSUED_DATE").text());
	console.log("DESCRIPTION" + $(this).find("DESCRIPTION").text());
	console.log("IMAGE_OBJECT" + $(this).find("IMAGE_OBJECT").text());
	console.log("LOCAL_ID" + $(this).find("LOCAL_ID").text());
	console.log("URL" + $(this).find("URL").text());
	console.log("VIEW_COUNT" + $(this).find("VIEW_COUNT").text());
	console.log("SUB_DESCRIPTION" + $(this).find("SUB_DESCRIPTION").text());
	console.log("SPATIAL_COVERAGE" + $(this).find("SPATIAL_COVERAGE").text());
	console.log("EVENT_SITE" + $(this).find("EVENT_SITE").text());
	console.log("GENRE" + $(this).find("GENRE").text());
	console.log("DURATION" + $(this).find("DURATION").text());
	console.log("NUMBER_PAGES" + $(this).find("NUMBER_PAGES").text());
	console.log("TABLE_OF_CONTENTS" + $(this).find("TABLE_OF_CONTENTS").text());
	console.log("AUTHOR" + $(this).find("AUTHOR").text());
	console.log("CONTACT_POINT" + $(this).find("CONTACT_POINT").text());
	console.log("ACTOR" + $(this).find("ACTOR").text());
	console.log("CONTRIBUTOR" + $(this).find("CONTRIBUTOR").text());
	console.log("AUDIENCE" + $(this).find("AUDIENCE").text());
	console.log("CHARGE" + $(this).find("CHARGE").text());
	console.log("PERIOD" + $(this).find("PERIOD").text());
	console.log("EVENT_PERIOD" + $(this).find("EVENT_PERIOD").text());
	
	});
	
	};
	
	}
	xhr.send('');
</script>

<input type="button" >

</body>
</html>