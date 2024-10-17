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
<script type="text/javascript">
function closeWindow(){
	// 자신의 창을 닫기 처리할때는 form 태그에 action 속성을 직접 설정하면 안됨. 
	document.rupdate.action="rinsert.do"
	document.rupdate.submit();
	
	window.location.href = 'http://localhost:8080/tiggle/exhibitionDetail.do?no=${ review.totalId }';
    opener.parent.reload(); // 부모 쪽 reload 함수를 실행시키는 함수
	window.open("about:blank", "_self").close();

}
</script>

<hr>
<h1 align="center">한줄평 등록 페이지</h1>


<br>
<!-- form 에서 파일이 첨부되어서 전송이 될 경우에는 반드시 enctype = "multipart/form-data" 속성을 추가해야 함 -->

<form action="rinsert.do" method="post">
<input type="hidden" name="totalId" value="${ exhibition.totalId }">
<input type="hidden" name="uuid" value="${ sessionScope.loginMember.uuid }">
<input type="hidden" name="nickname" value="${ sessionScope.loginMember.id }">
<table id="outer" align="center" width="700" cellspacing="5" cellpadding="5">
	<tr><th width="120">전시 제목</th>
		<td>
			<input type="text" name="exhibitionTitle" readonly value="${ exhibition.title }" >
		</td>
	</tr>
	<tr><th width="120">작성자</th>
		<td>
			<input type="text" name="reviewWriter" readonly value="${ sessionScope.loginMember.id }">
		</td>
	</tr>
	<tr><th>내 용</th>
		<td><textarea rows="5" cols="50" name="rContents"></textarea>
		</td></tr>
	
	<tr><th colspan="2">
		<input type="submit" value="등록하기"> &nbsp;
		<input type="button" value="취소" onclick="window.close()"> &nbsp;
	</th></tr>
</table>
</form>
<footer></footer>
<hr>
</body>
</html>













