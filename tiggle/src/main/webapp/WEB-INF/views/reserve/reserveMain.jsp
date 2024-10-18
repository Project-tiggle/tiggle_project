<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>tiggle</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<!-- jQuery와 Postcodify를 로딩한다. -->
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>
	/*  검색 단추를 누르면 팝업 레이어가 열리도록 설정한다. */
	$(function(){
		$("#postcodify_search_button").postcodifyPopUp();
	});
</script>			
<style>
	
	span.guide {display:none; font-size:12px; top:12px, right:10px;}
	span.ok{color:green;}
	span.error{color:red;}
	
#reserve {
	display: flex;
	justify-content: space-between;
	width: 100%;
	margin: 60px auto;
}

div.resC {
	width: 600px;
} 

#resExh {
	width: 400px;
}
	
</style>

</head>
<body>
<hr>
<h1 align="center">예매 하기</h1>
<br>
<!-- form 에서 파일이 첨부되어서 전송이 될 경우에는 반드시 enctype = "multipart/form-data" 속성을 추가해야 함 -->
<form action="remove.do" method="post" id="reserve">
<div class="resC">
	<img id="resExh" src="${ exhibition.fileUrl }">
</div>
<div class="resC">
	<table id="outer" align="center" width="700" cellspacing="5" cellpadding="5">
		<tr>
		<th width="120">전시 제목</th>
			<td>
				<input type="text" name="exhibitionTitle" readonly id="title" value="${ exhibition.title }" >
			</td>
		</tr>
		<tr>
		<th width="120">예매자</th>
			<td>
				<input type="text" name="reserveId" readonly value="${ sessionScope.loginMember.id }">
			</td>
		</tr>
		<tr>
		<th>전화번호</th>
			<td><input type="text" name="reservePhone" readonly value="${ sessionScope.loginMember.phone }">
			</td></tr>
		
		<tr>
		<th>주소</th>
			<td>
				<input type="text" name="reserveAddress" readonly value="${ sessionScope.loginMember.address }">
				<input type="checkbox" id="deliveryCheck" name="delivery"> 기본 배송지로 설정
			</td></tr>
		<tr>
		<td>우편번호</td>
			<td>
				<input type="text" name="post" class="postcodify_postcode5" size="6">
				<button type="button" id="postcodify_search_button">검색</button>
			</td>
		</tr>
		<tr>
			<td>도로명 주소</td>
			<td><input type="text" name="address1" class="postcodify_address"></td>
		</tr>
		<tr>
			<td>상세 주소</td>
			<td><input type="text" name="address2" class="postcodify_extra_info"></td>
		</tr>	
		<tr>
		<th>배송지</th>
			<td>
				<input type="text" id="delivery" name="reserveDelivery">
			</td>
		</tr>
		<tr>
			<th colspan="2">인원수    
				<button id="decrease" type="button">-</button>
	       			<span id="counter">	0</span>
	       		<button id="increase" type="button">+</button>
		<tr>
			<th colspan="2">
				금액 <p>총 금액: <span id="totalPrice">0</span> 원</p> &nbsp;
			</th>
		</tr>
		<tr>
			<th colspan="2"> &nbsp;
				<input type="button" value="취소" onclick="javascript:history.go(-1); return false;">
			</th>
		</tr>
	</table>
</div>
</form>
<footer></footer>
<hr>
 
<script>
	   var counterValue = 0;  // 초기 카운터 값
       const unitPrice = 1000;  // 단가 설정

       // DOM 요소를 가져옴
       const counterDisplay = document.getElementById('counter');
       const totalPriceDisplay = document.getElementById('totalPrice');
       const increaseButton = document.getElementById('increase');
       const decreaseButton = document.getElementById('decrease');
       
       // 최종 금액 계산 함수
       const calculateTotalPrice = () => {
           const totalPrice = counterValue * unitPrice;
           totalPriceDisplay.textContent = totalPrice.toLocaleString();  // 1000단위 쉼표
       };
        // 증가 버튼 클릭 시
       increaseButton.addEventListener('click', () => {
           counterValue++;
           counterDisplay.textContent = counterValue;
           calculateTotalPrice();
       });
       // 감소 버튼 클릭 시
 	   decreaseButton.addEventListener('click', () => {
	    if (counterValue > 0) {  // 값이 0 이하로 내려가지 않도록
	        counterValue--;  
	        counterDisplay.textContent = counterValue;
	        calculateTotalPrice();  // 금액 업데이트
 				}
       });

	  const deliveryCheck = document.getElementById("deliveryCheck");
   	  const deliveryInput = document.getElementById("delivery");

	    deliveryCheck.addEventListener("change", function() {
	        if (this.checked) {
	            deliveryInput.value = "${ sessionScope.loginMember.address }";
	            deliveryInput.setAttribute("readonly", true);  // 읽기 전용 설정
	        } else {
	            deliveryInput.value = "";  // 체크 해제 시 값 초기화
	            deliveryInput.removeAttribute("readonly");  // 읽기 전용 해제
	        }
	    });
	    </script>
		


</body>
</html>













