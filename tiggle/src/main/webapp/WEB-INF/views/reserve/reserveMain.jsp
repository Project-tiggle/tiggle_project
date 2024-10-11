<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tiggle</title>
</head>
<body>
<hr>
<h1 align="center">예매 하기</h1>
<br>
<!-- form 에서 파일이 첨부되어서 전송이 될 경우에는 반드시 enctype = "multipart/form-data" 속성을 추가해야 함 -->
<form action="rinsert.do" method="post">
<table id="outer" align="center" width="700" cellspacing="5" cellpadding="5">
	<tr><th width="120">전시 제목</th>
		<td>
			<input type="text" name="exhibitionTitle" size="50" >
		</td>
	</tr>
	<tr><th width="120">작성자</th>
		<td>
			<input type="text" name="reviewWriter" readonly value="${ sessionScope.loginUser.userId }">
		</td>
	</tr>
	<tr><th>내 용</th>
		<td><textarea rows="5" cols="50" name="reviewContent"></textarea>
		</td></tr>
	
	<tr><th colspan="2">
		<input type="submit" value="등록하기"> &nbsp;
		<input type="reset" value="작성취소"> &nbsp;
		<input type="button" value="목록" onclick="javascript:history.go(-1); return false;">
	</th></tr>
</table>
</form>
<footer></footer>
<hr>
</body>
</html>













