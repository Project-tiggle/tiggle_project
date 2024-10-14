/**
 * 24-10-14 15:01 건열 전시 OPEN API Data -> 관리자 권한으로 DB에 JSON 형식으로 저장하는 함수
 */
 
 function cultureApiDataSave(){
 	/* Javascript Sample*/
	var xhr = new XMLHttpRequest();
	var url = 'http://api.kcisa.kr/openapi/API_CCA_145/request'; /*URL*/
	var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + 'fcdfe4b5-38d6-4592-8d63-7964b086465a'; /*서비스키*/
	queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('100'); /*세션당 요청레코드수*/
	queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /*페이지수*/
	
	var jarr = new Array();
	var lastLocalID = null; // 마지막으로 처리된 LOCAL_ID 값을 저장
	
	xhr.open('GET', url + queryParams);
	xhr.onreadystatechange = function () {
		
	
	if (this.readyState == 4) {
	
	console.log('status: ' + this.status);
	console.log('resultCode: ' + $(this.responseText).find('resultCode').text());
	console.log('resultMsg: ' + $(this.responseText).find('resultMsg').text());
	
	
	var item = $(this.responseText).find('item');
	$(item).each(function(){
	
	
		// console.log("TITLE" + $(this).find("TITLE").text());
		// console.log("CNTC_INSTT_NM" + $(this).find("CNTC_INSTT_NM").text());
		// console.log("COLLECTED_DATE" + $(this).find("COLLECTED_DATE").text());
		// console.log("ISSUED_DATE" + $(this).find("ISSUED_DATE").text());
		// console.log("DESCRIPTION" + $(this).find("DESCRIPTION").text());
		// console.log("IMAGE_OBJECT" + $(this).find("IMAGE_OBJECT").text());
		console.log("LOCAL_ID" + $(this).find("LOCAL_ID").text());
		// console.log("URL" + $(this).find("URL").text());
		// console.log("VIEW_COUNT" + $(this).find("VIEW_COUNT").text());
		// console.log("SUB_DESCRIPTION" + $(this).find("SUB_DESCRIPTION").text());
		// console.log("SPATIAL_COVERAGE" + $(this).find("SPATIAL_COVERAGE").text());
		// console.log("EVENT_SITE" + $(this).find("EVENT_SITE").text());
		// console.log("GENRE" + $(this).find("GENRE").text());
		// console.log("DURATION" + $(this).find("DURATION").text());
		// console.log("NUMBER_PAGES" + $(this).find("NUMBER_PAGES").text());
		// console.log("TABLE_OF_CONTENTS" + $(this).find("TABLE_OF_CONTENTS").text());
		// console.log("AUTHOR" + $(this).find("AUTHOR").text());
		// console.log("CONTACT_POINT" + $(this).find("CONTACT_POINT").text());
		// console.log("ACTOR" + $(this).find("ACTOR").text());
		// console.log("CONTRIBUTOR" + $(this).find("CONTRIBUTOR").text());
		// console.log("AUDIENCE" + $(this).find("AUDIENCE").text());
		// console.log("CHARGE" + $(this).find("CHARGE").text());
		// console.log("PERIOD" + $(this).find("PERIOD").text());
		// console.log("EVENT_PERIOD" + $(this).find("EVENT_PERIOD").text());	

	 	var currentLocalID = $(this).find("LOCAL_ID").text(); // 현재 처리 중인 LOCAL_ID
	 
		 // 마지막 LOCAL_ID와 현재 LOCAL_ID 비교
	    if (lastLocalID !== null) {
       		 if (lastLocalID === currentLocalID) {
            	console.log(`이전 Local_ID(${lastLocalID})와 현재 Local_ID(${currentLocalID})가 동일합니다.`);
           		return; // 같은 경우 넘기고 다음 항목 처리
       		 } else {
            	console.log(`이전 Local_ID(${lastLocalID})와 현재 Local_ID(${currentLocalID})가 다릅니다.`);
       		 }
    	}
 
	
		var job = new Object();
	
		job.TITLE = $(this).find("TITLE").text();
		job.LOCAL_ID = currentLocalID;;		
		job.CNTC_INSTT_NM = $(this).find("CNTC_INSTT_NM").text();
		job.DESCRIPTION = $(this).find("DESCRIPTION").text();
		job.IMAGE_OBJECT = $(this).find("IMAGE_OBJECT").text();
		job.URL = $(this).find("URL").text();
		job.EVENT_SITE = $(this).find("EVENT_SITE").text();
		job.GENRE = $(this).find("GENRE").text();
		job.CONTACT_POINT = $(this).find("CONTACT_POINT").text();
		job.CONTRIBUTOR = $(this).find("CONTRIBUTOR").text();
		job.CHARGE = $(this).find("CHARGE").text();
		job.PERIOD = $(this).find("PERIOD").text();
	
		console.log(JSON.stringify(job));
		jarr.push(job);
		console.log(jarr.length);
	
		// 마지막 LOCAL_ID 값을 현재 LOCAL_ID로 업데이트
   		 lastLocalID = currentLocalID;
	
		}); // each
	}; // readyState
		$.ajax({
			url: 'apiDbSave.do',
			type: 'post',
			data: JSON.stringify(jarr),
			contentType: "application/json;",
			success: function(data){
				alert('DB 저장 성공 :' + data)
			},
			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임
				console.log("error code : " + request.status + "\nMessage : " + request.responseText
				+ "\nError : " + errorData );
			} // error function end
		}); // ajax
	}// onreadystatechange end
	
	xhr.send('');
	
 }// cultureApiDataSave end
 
 
 
 