<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="nowpage" value="1"/>
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }"/>
</c:if>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tiggle</title>
<style type="text/css">
fieldset#ss {
	width: 550px;
	position: relative;
	left: 450px;
}
form fieldset {
	width: 500px;
}
form.sform {
	background: lightgray;
	width: 550x;
	position: relative;
	left: 450px;
	display: none;	/* 기본적으로 안 보이게 함*/
}

</style>

<script type="text/javascript" src="/first/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	// input 태그의 name 이 itme 인 radio 값이 바뀌면(change) 작동되는 이벤트 핸들러 작성
	// JQuery('태그선택자').실행할메소드명(...); => jQuery 는 줄여서 $로 표시함
	$('input[name=item]').on('change', function(){
		// 3개의 item 중에 체크표시가 된 radio 를 선택 => 반복 처리 : each() 메소드 사용
		$('input[name=item]').each(function(index){
			// 선택된 radio 순번대로 하나씩 checked 인지 확인함 : is() 메소드 사용
			if($(this).is(':checked')){
				// 체크 표시된 item 에 대한 form 이 보여지게 처리함
				$('form.sform').eq(index).css('display', 'block');
			}else{
				// 체크 표시 안된 item 에 대한 form 이 안보이게 처리함
				$('form.sform').eq(index).css('display', 'none');
				
			}
		});
		
	}); // onchange 에 대한 이벤트 콜백
});// document.ready
</script>


</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>
<hr>
<br>
<center>
	<button>목록</button> &nbsp; &nbsp;
	<c:if test="${ !empty sessionScope.loginUser and loginUser }">
		<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/moveWrite.do';">공지글 등록</button> &nbsp; &nbsp;
		<%-- location.href = "/first/moveWrite.do"; --%>
	</c:if>
</center>
<br>

<%-- 항목별 검색 기능 추가 --%>
<fieldset id="ss">
	<legend>검색할 항목을 선택하세요</legend>
	<input type="radio" name="item" id="title"> 제목 &nbsp;
	<input type="radio" name="item" id="content"> 내용 &nbsp;
	<input type="radio" name="item" id="date"> 등록날짜 &nbsp;
</fieldset>

<%-- 검색 항목별 값 입력 전송용 폼 만들기 --%>
<%-- 제목 검색용 폼 --%>
<form action="nsearchTitle.do" id="titleform" class="sform" method="get">
	<input type="hidden" name="action" value="title">
	<fieldset>
	<legend>검색할 제목을 입력하세요.</legend>
		<input type="search" name="keyword" size="50"> &nbsp;
		<input type="submit" value="검색">
	</fieldset>
</form>

<%-- 내용 검색용 폼 --%>
<form action="nsearchContent.do" id="contentform" class="sform" method="get">
	<input type="hidden" name="action" value="content">
	<fieldset>
	<legend>검색할 내용을 입력하세요.</legend>
		<input type="search" name="keyword" size="50"> &nbsp;
		<input type="submit" value="검색">
	</fieldset>
</form>

<%-- 등록날짜 검색용 폼 --%>
<form action="nsearchDate.do" id="dateform" class="sform" method="get">
	<input type="hidden" name="action" value="date">
	<fieldset>
	<legend>검색할 등록날짜를 입력하세요.</legend>
		<input type="date" name="begin"> ~ <input type="date" name="end"> &nbsp;
		<input type="submit" value="검색">
	</fieldset>
</form>


<%-- 조회된 공지사항 목록 출력 --%>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>첨부파일</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${ requestScope.list }" var="n">
		<tr>
			<td align="center">${ n.noticeNo }</td>
			<td align="center">
			<c:if test="${ n.importance eq 'Y' }">
				<img src="${ pageContext.servletContext.contextPath}/resources/images/notice.gif"
				width="15" height="15">
			</c:if>
			<a href="${ pageContext.servletContext.contextPath}/ndetail.do?no=${ n.noticeNo }">${ n.noticeTitle }</a></td>
			<td align="center">${ n.noticeWriter }</td>
			<td align="center">
				<c:if test="${ !empty n.originalFilePath }">◎</c:if>
				<c:if test="${ empty n.originalFilePath }">&nbsp;</c:if>
			</td>
			<td align="center">
				<fmt:formatDate value="${n.noticeDate }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
	</c:forEach>
</table>
<br>

<%-- 페이징 출력 뷰 포함 처리 --%>
<c:import url="/WEB-INF/views/common/pagingView.jsp"/>



<hr>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>