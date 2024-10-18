<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄평 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
</head>
<body>
<script type="text/javascript">
function closeWindow(){
	// 자신의 창을 닫기 처리할때는 form 태그에 action 속성을 직접 설정하면 안됨. 
	document.rupdate.action="rupdate.do"
	var ref = document.rupdate.submit();
	//alert("한줄평 변경 완료");
	
	window.location.href = 'http://localhost:8080/tiggle/exhibitionDetail.do?no=${ review.totalId }';
    opener.parent.reload(); // 부모 쪽 reload 함수를 실행시키는 함수
    setTimeout(function () {
		window.open("about:blank", "_self").close();
	    }, 50);
}

</script>

<hr>
<h1 align="center">한줄평 수정 페이지</h1>
<br>
<!-- form 에서 파일이 첨부되어서 전송이 될 경우에는 반드시 enctype = "multipart/form-data" 속성을 추가해야 함 -->
<form name="rupdate" method="post" id="rupdate">
<input type="hidden" name="totalId" value="${ exhibition.totalId }">
<input type="hidden" name="uuid" value="${ sessionScope.loginMember.uuid }">
 <input type="hidden" name="nickname" value="${ sessionScope.loginMember.nickname }">
 <input type="hidden" name="page" value="${ requestScope.currentPage }">
 <input type="hidden" name="rNum" value="${ review.rNum }">

<table id="outer" align="center" width="700" cellspacing="5" cellpadding="5">
   <tr><th width="120">전시 제목</th>
      <td>
         <input type="text" name="exhibitionTitle" size="50" readonly value="${ exhibition.title }">
      </td>
   </tr>
   <tr><th width="120">작성자</th>
      <td>
         <input type="text" name="reviewWriter" readonly value="${ sessionScope.loginMember.id }">
      </td>
   </tr>
   <tr><th>내 용</th>
      <td><textarea rows="5" cols="50" name="rContents">${ review.rContents }</textarea>
      </td></tr>
   
   <tr><th colspan="2">
      <input type="submit" value="수정하기" onclick="closeWindow();"> &nbsp;
      <input type="button" value="취소" onclick="window.close();"> &nbsp;
   </th></tr>
</table>
</form>
<footer></footer>
<hr>
</body>
</html>
