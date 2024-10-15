<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>관리자 전시등록 관리 페이지</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<style>
#adminMainTitle {
    margin: 50px 0 20px;
    text-align: left;
    font-size: 24px;
    font-weight: bold;
    color: #ff5f2c;
	margin-bottom: 20px;
	text-align: left;
}

#ynMessage {
    width: 100%;
    max-width: 1280px;
    margin: 0 auto;
}

#ynMessage table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
    background-color: #ffffff;
}

#ynMessage th, #ynMessage td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: center;
}

#ynMessage th {
    background-color: #f2f2f2;
    color: #333;
    font-weight: bold;
}

#ynMessage td {
    color: #666;
}

#adEditBtn {
    display: inline-block;
    padding: 5px 20px;
    border: none;
    border-radius: 5px;
    font-weight: bold;
    transition: background-color 0.3s ease;
}

#adEditBtn:hover {
    background-color: #555;
    color: white;
}

#apiBtnDiv, #apiXy{
	text-align: right;
}

#apiBtn, #apiXyBtn {
    width: 250px;
    padding: 10px;
    margin-top: 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    background-color: #eee;
}

#apiBtn:hover, #apiXyBtn:hover {
    background-color: #ff7a52;
    color: white;
}

</style>
<script type="text/javascript" src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="/tiggle/resources/js/exhibition.js"></script>

</head>
<body>
    <c:import url="/WEB-INF/views/common/header.jsp" />

    <div id="ynMessage" align="center">
        <h1 id="adminMainTitle">전시/박람회 등록 대기</h1>
        
        <!-- 전시회 API 등록 버튼 -->
        <div id="apiBtnDiv">
        	<button id="apiBtn" onclick="cultureApiDataSave();">전시회 API 등록</button>
  			&nbsp;
        	<button id="apiXyBtn" onclick="javascript:location.href='apiXySetting.do';">전시회 API 위치 값(X, Y등록)</button>
        </div>
        <br>
        <!-- 전시회 API 등록 버튼 -->
        
        <table>
            <thead>
                <tr>
                	<th align="center">분류</th>
                    <th align="center">제목</th>
                    <th align="center">신청기업</th>
                    <th align="center">시작일</th>
                    <th align="center">종료일</th>
                    <th align="center">상세보기</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ requestScope.list }" var="list">
                    <tr>
                    	<td align="center">
                    		<c:if test="${ list.eCategory eq 1 }">전시회</c:if>
                    		<c:if test="${ list.eCategory ne 1 }">박람회</c:if>
                    	</td>
                        <td align="center">${ list.title }</td>
                        <td align="center">${ list.orgName }</td>
                        <td align="center">${ list.startDate }</td>
                        <td align="center">${ list.endDate }</td>
                        <td align="center">
                        	<c:url var="adEditLink" value="RegistDetailAd.do">
                                <c:param name="num" value="${ list.totalId }" />
                                <c:param name="page" value="${ currentPage }" />
                            </c:url> <a href="${ adEditLink }" id="adEditBtn">상세 정보 보기</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <c:import url="/WEB-INF/views/common/pagingView.jsp" />
	<br><br><br><br><br>
    <c:import url="/WEB-INF/views/common/footer.jsp" />

</body>
</html>
