<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tiggle</title>

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
				<input type="text" name="exhibitionTitle" readonly value="${ exhibition.title }" >
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
					if(deliveryCheck.checked == true){
						delivery.value="${ sessionScope.loginMember.address }"	
					}
				</script>
			</td></tr>
		<tr><th colspan="2">
			<input type="button" value="결제하기"> &nbsp;
			<input type="button" value="취소" onclick="javascript:history.go(-1); return false;">
		</th></tr>
	</table>
</div>
</form>
<footer></footer>
<hr>
</body>
</html>













