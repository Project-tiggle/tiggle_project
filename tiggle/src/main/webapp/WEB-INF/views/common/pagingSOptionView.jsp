<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 페이지 표시에 사용될 값들을 변수 선언 --%>
<c:set var="currentPage" value="${ requestScope.paging.currentPage }" />
<c:set var="urlMapping" value="${ requestScope.paging.urlMapping }" />
<c:set var="startPage" value="${ requestScope.paging.startPage }" />
<c:set var="endPage" value="${ requestScope.paging.endPage }" />
<c:set var="maxPage" value="${ requestScope.paging.maxPage }" />

<c:set var="sOption" value="${ requestScope.sOption }" />
<c:set var="keyword" value="${ requestScope.keyword }" />
<c:set var="begin" value="${ requestScope.begin }" />
<c:set var="end" value="${ requestScope.end }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
   .soption_paging {display: flex; justify-content: center; align-items: center; width: 100%;}
   .soption_paging img {width: 32px;}
   .soption_paging a {height: 32px; display: flex; align-items: center; justify-content: center;}
   .soption_paging span {margin: 0 5px;}
</style>
</head>
<body>
<%-- 1. 목록 페이징 처리 : 검색에 대한 목록이 아닌 경우 --%>
<c:if test="${ empty sOption }">
<div class="soption_paging">
   <%-- 1page 로 이동 --%>
   <c:if test="${ currentPage eq 1 }">
      <img src="/tiggle/resources/images/arr_double_left.png"> &nbsp;
   </c:if>
   <c:if test="${ currentPage gt 1 }">
      <a href="/tiggle/${ urlMapping }?page=1">
         <img src="/tiggle/resources/images/arr_double_left.png">
      </a> &nbsp;
   </c:if>
   
   <%-- 이전 페이지그룹으로 이동 --%>
   <%-- 이전 그룹이 있다면 --%>
   <c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) gt 1 }">
      <a href="/tiggle/${ urlMapping }?page=${ startPage - 10 }">
         <img src="/tiggle/resources/images/arr_left.png">
      </a> &nbsp;
   </c:if>
   <%-- 이전 그룹이 없다면 --%>
   <c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) gt 1) }">
      <img src="/tiggle/resources/images/arr_left.png"> &nbsp;
   </c:if>
   
   <%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
   <c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
      <c:if test="${ p eq currentPage }">
         <font color="#ff5f2c"><b><span>${ p }</span></b></font>
      </c:if>
      <c:if test="${ p ne currentPage }">
         <a href="/tiggle/${ urlMapping }?page=${ p }"><span>${ p }</span></a>
         <%-- 예: 페이지 7 클릭시 href="/tiggle/nlist.do?page=7" 요청 처리됨 --%>
      </c:if>
   </c:forEach>
   
   <%-- 다을 페이지그룹으로 이동 --%>
   <%-- 다음 그룹이 있다면 --%>
   <c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
      <a href="/tiggle/${ urlMapping }?page=${ startPage + 10 }">
         <img src="/tiggle/resources/images/arr_right.png">
      </a> &nbsp;
   </c:if>
   <%-- 다음 그룹이 없다면 --%>
   <c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
      <img src="/tiggle/resources/images/arr_right.png"> &nbsp;
   </c:if>
   
   <%-- maxPage 로 이동 --%>
   <c:if test="${ currentPage ge maxPage }">
      <img src="/tiggle/resources/images/arr_double_right.png"> &nbsp;
   </c:if>
   <c:if test="${ currentPage lt maxPage }">
      <a href="/tiggle/${ urlMapping }?page=${ maxPage }">
         <img src="/tiggle/resources/images/arr_double_right.png">
      </a> &nbsp;
   </c:if>
</div>
</c:if>

<%-- 2. 검색(제목, 작성자, 내용) 목록에 대한 페이징 처리 --%>
<c:if test="${ !empty sOption and !empty keyword }">
<div class="soption_paging">
   <%-- 1page 로 이동 --%>
   <c:if test="${ currentPage eq 1 }">
      <img src="/tiggle/resources/images/arr_double_left.png"> &nbsp;
   </c:if>
   <c:if test="${ currentPage gt 1 }">
      <a href="/tiggle/${ urlMapping }?page=1&sOption=${ sOption }&keyword=${ keyword }">
         <img src="/tiggle/resources/images/arr_double_left.png">
      </a> &nbsp;
   </c:if>
   
   <%-- 이전 페이지그룹으로 이동 --%>
   <%-- 이전 그룹이 있다면 --%>
   <c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) gt 1 }">
      <a href="/tiggle/${ urlMapping }?page=${ startPage - 10 }&sOption=${ sOption }&keyword=${ keyword }">
         <img src="/tiggle/resources/images/arr_left.png">
      </a> &nbsp;
   </c:if>
   <%-- 이전 그룹이 없다면 --%>
   <c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) gt 1) }">
      <img src="/tiggle/resources/images/arr_left.png"> &nbsp;
   </c:if>
   
   <%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
   <c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
      <c:if test="${ p eq currentPage }">
         <font color="#ff5f2c"><b><span>${ p }</span></b></font>
      </c:if>
      <c:if test="${ p ne currentPage }">
         <a href="/tiggle/${ urlMapping }?page=${ p }&sOption=${ sOption }&keyword=${ keyword }"><span>${ p }</span></a>
         <%-- 예: 페이지 7 클릭시 href="/tiggle/nlist.do?page=7" 요청 처리됨 --%>
      </c:if>
   </c:forEach>
   
   <%-- 다을 페이지그룹으로 이동 --%>
   <%-- 다음 그룹이 있다면 --%>
   <c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
      <a href="/tiggle/${ urlMapping }?page=${ startPage + 10 }&sOption=${ sOption }&keyword=${ keyword }">
         <img src="/tiggle/resources/images/arr_right.png">
      </a> &nbsp;
   </c:if>
   <%-- 다음 그룹이 없다면 --%>
   <c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
      <img src="/tiggle/resources/images/arr_right.png"> &nbsp;
   </c:if>
   
   <%-- maxPage 로 이동 --%>
   <c:if test="${ currentPage ge maxPage }">
      <img src="/tiggle/resources/images/arr_double_right.png"> &nbsp;
   </c:if>
   <c:if test="${ currentPage lt maxPage }">
      <a href="/tiggle/${ urlMapping }?page=${ maxPage }">
         <img src="/tiggle/resources/images/arr_double_right.png">
      </a> &nbsp;
   </c:if>
</div>
</c:if>

<%-- 3. 검색(등록날짜, 연령대) 목록에 대한 페이징 처리 --%>
<c:if test="${ !empty sOption and sOption eq 'date' or sOption eq 'enrolldate' }">
<div class="soption_paging">
   <%-- 1page 로 이동 --%>
   <c:if test="${ currentPage eq 1 }">
      <img src="/tiggle/resources/images/arr_double_left.png"> &nbsp;
   </c:if>
   <c:if test="${ currentPage gt 1 }">
      <a href="/tiggle/${ urlMapping }?page=1&sOption=${ sOption }&begin=${ begin }&end=${ end }">
         <img src="/tiggle/resources/images/arr_double_left.png">
      </a> &nbsp;
   </c:if>
   
   <%-- 이전 페이지그룹으로 이동 --%>
   <%-- 이전 그룹이 있다면 --%>
   <c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) gt 1 }">
      <a href="/tiggle/${ urlMapping }?page=${ startPage - 10 }&sOption=${ sOption }&begin=${ begin }&end=${ end }">
         <img src="/tiggle/resources/images/arr_left.png">
      </a> &nbsp;
   </c:if>
   <%-- 이전 그룹이 없다면 --%>
   <c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) gt 1) }">
      <img src="/tiggle/resources/images/arr_left.png"> &nbsp;
   </c:if>
   
   <%-- 현재 페이지그룹 출력 and currentPage 표시 --%>
   <c:forEach begin="${ startPage }" end="${ endPage }" step="1" var="p">
      <c:if test="${ p eq currentPage }">
         <font color="#ff5f2c"><b><span>${ p }</span></b></font>
      </c:if>
      <c:if test="${ p ne currentPage }">
         <a href="/tiggle/${ urlMapping }?page=${ p }&sOption=${ sOption }&begin=${ begin }&end=${ end }"><span>${ p }</span></a>
         <%-- 예: 페이지 7 클릭시 href="/tiggle/nlist.do?page=7" 요청 처리됨 --%>
      </c:if>
   </c:forEach>
   
   <%-- 다을 페이지그룹으로 이동 --%>
   <%-- 다음 그룹이 있다면 --%>
   <c:if test="${ (currentPage + 10) gt endPage and (currentPage + 10) lt maxPage }">
      <a href="/tiggle/${ urlMapping }?page=${ startPage + 10 }&sOption=${ sOption }&begin=${ begin }&end=${ end }">
         <img src="/tiggle/resources/images/arr_right.png">
      </a> &nbsp;
   </c:if>
   <%-- 다음 그룹이 없다면 --%>
   <c:if test="${ !((currentPage + 10) gt endPage and (currentPage + 10) lt maxPage) }">
      <img src="/tiggle/resources/images/arr_right.png"> &nbsp;
   </c:if>
   
   <%-- maxPage 로 이동 --%>
   <c:if test="${ currentPage ge maxPage }">
      <img src="/tiggle/resources/images/arr_double_right.png"> &nbsp;
   </c:if>
   <c:if test="${ currentPage lt maxPage }">
      <a href="/tiggle/${ urlMapping }?page=${ maxPage }&sOption=${ sOption }&begin=${ begin }&end=${ end }">
         <img src="/tiggle/resources/images/arr_double_right.png">
      </a> &nbsp;
   </c:if>
</div>
</c:if>

</body>
</html>






