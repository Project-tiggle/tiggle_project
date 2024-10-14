<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tiggle</title>
<script src="https://js.tosspayments.com/v2/standard"></script>

<style>

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
		<tr><th width="120">전시 제목</th>
			<td>
				<input type="text" name="exhibitionTitle" readonly id="title" value="${ exhibition.title }" >
			</td>
		</tr>
		<tr><th width="120">예매자</th>
			<td>
				<input type="text" name="reserveId" readonly value="${ sessionScope.loginMember.id }">
			</td>
		</tr>
		<tr><th>전화번호</th>
			<td><input type="text" name="reservePhone" readonly value="${ sessionScope.loginMember.phone }">
			</td></tr>
		
		<tr><th>주소</th>
			<td>
				<input type="text" name="reserveAddress" readonly value="${ sessionScope.loginMember.address }">
				<input type="checkbox" id="deliveryCheck" name="delivery"> 기본 배송지로 설정
			</td></tr>
		
		<tr><th>배송지</th>
			<td><input type="text" id="delivery" name="reserveDelivery">
				<script>
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
			</td></tr>
		

		<tr><th colspan="2">
			인원수    
			<button id="decrease" type="button">-</button>
       		<span id="counter">0</span>
       		<button id="increase" type="button">+</button>

		<tr><th colspan="2">
			금액 <p>총 금액: <span id="totalPrice">0</span> 원</p> &nbsp;
		</th></tr>
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
			    </script>
		</th></tr>
		<tr><th colspan="2">
			<button class="button" value="결제하기" id="payment-Button">결제하기</button>
		  		
			<script>
			 main();

		      async function main() {
		        const button = document.getElementById("payment-button");
		        
		        // ------  결제위젯 초기화 ------
		        const clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm";
		        const tossPayments = TossPayments(clientKey);
		        // 회원 결제
		        const customerKey = "u8v1GriemisXxWDUEW9Sb";
		        const widgets = tossPayments.widgets({
		          customerKey,
		        });
		        
		        // ------ 주문의 결제 금액 설정 ------
		        await widgets.setAmount({
		          currency: "KRW",
		          value: 50000,
		        });
		        
		        await Promise.all([
		        // ------  결제 UI 렌더링 ------
		          widgets.renderPaymentMethods({
		            selector: "#payment-method",
		            variantKey: "DEFAULT",
		          }),
		        
	          // ------  이용약관 UI 렌더링 ------
		          widgets.renderAgreement({ 
		        	  selector: "#agreement", 
		        	  variantKey: "AGREEMENT" 
	        	 	 }),
	        	  }
		        ]);
		        
	        // ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
		        button.addEventListener(
		        		"click",
		        		async function () {
					          await widgets.requestPayment({
		    			      orderId: "ZYyTRgZ3fG25vcl667LFh",
		            		  orderName: "토스 티셔츠 외 2건",
		   		              successUrl: window.location.origin + "/success.html",
		          			  failUrl: window.location.origin + "/fail.html",
		          			  customerEmail: "customer123@gmail.com",
		       			      customerName: "김토스",
		       			      customerMobilePhone: "01012341234",
         			 });
    		    });
	        
		        const express = require("express");
		        const got = require("got");

		        const app = express();

		        app.use(express.json());
		        app.use(express.urlencoded({ extended: true }));

		        app.post("/confirm", function (req, res) {
		          // 클라이언트에서 받은 JSON 요청 바디입니다.
		          const { paymentKey, orderId, amount } = req.body;

		          // 토스페이먼츠 API는 시크릿 키를 사용자 ID로 사용하고, 비밀번호는 사용하지 않습니다.
		          // 비밀번호가 없다는 것을 알리기 위해 시크릿 키 뒤에 콜론을 추가합니다.
		          const widgetSecretKey = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";
		          const encryptedSecretKey =
		            "Basic " + Buffer.from(widgetSecretKey + ":").toString("base64");

		          // 결제를 승인하면 결제수단에서 금액이 차감돼요.
		          got
		            .post("https://api.tosspayments.com/v1/payments/confirm", {
		              headers: {
		                Authorization: encryptedSecretKey,
		                "Content-Type": "application/json",
		              },
		              json: {
		                orderId: orderId,
		                amount: amount,
		                paymentKey: paymentKey,
		              },
		              responseType: "json",
		            })
		            .then(function (response) {
		              // 결제 성공 비즈니스 로직을 구현하세요.
		              console.log(response.body);
		              res.status(response.statusCode).json(response.body)
		            })
		            .catch(function (error) {
		              // 결제 실패 비즈니스 로직을 구현하세요.
		              console.log(error.response.body);
		              res.status(error.response.statusCode).json(error.response.body)
		            });
		        });

		        app.listen(4242, () =>
		          console.log(`http://localhost:${4242} 으로 샘플 앱이 실행되었습니다.`)
		        );	
	        
	        
			</script>
			 &nbsp;
			<input type="button" value="취소" onclick="javascript:history.go(-1); return false;">
		</th></tr>
	</table>
</div>
</form>
<footer></footer>
<hr>
</body>
</html>













