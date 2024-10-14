/**
 * 
 */
 
 function cultureApiDataSave(){
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
	
	var jarr = new Array();
	var pStr = '';
	

	var item = $(this.responseText).find('item');
	$(item).each(function(){
	
	var job = new Object();
	
	
	
	job.TITLE = $(this).find("TITLE").text());
	job.CNTC_INSTT_NM = $(this).find("CNTC_INSTT_NM").text());
	job.DESCRIPTION = $(this).find("DESCRIPTION").text());
	job.IMAGE_OBJECT = $(this).find("IMAGE_OBJECT").text());
	job.URL = $(this).find("URL").text());
	job.EVENT_SITE = $(this).find("EVENT_SITE").text());
	job.GENRE = $(this).find("GENRE").text());
	job.CONTACT_POINT = $(this).find("CONTACT_POINT").text());
	job.CONTRIBUTOR = $(this).find("CONTRIBUTOR").text());
	job.CHARGE = $(this).find("CHARGE").text());
	job.PERIOD = $(this).find("PERIOD").text());
	
	jarr.push(job);
	
	});
	
	};
	
	}
	xhr.send('');
	
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
			}
	});
	
	
	
	
	
	
 }