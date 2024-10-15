<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>기업 전시/박람회 등록</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<style>
#orgContainer {
	width: 80%;
	max-width: 1280px;
	margin: 50px auto 0;
}

#orgTitle {
	color: #ff5f2c;
	font-size: 24px;
	margin-bottom: 20px;
	text-align: left;
}

#orgTerms {
	width: 97.8%;
	height: 250px;
	border: 1px solid #000;
	overflow-y: scroll;
	padding: 10px;
	margin-bottom: 20px;
}

#ynMessage {
	font-weight: bold;
	margin-bottom: 20px;
	padding: 10px;
}

#orgBtn {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	gap: 10px;
}

#orgEditBtn, #orgRegBtn {
	padding: 10px 20px;
	background-color: #ababab5c;
	border: none;
	cursor: pointer;
}

#orgEditBtn:hover{
	background-color: #ff5f2c;
}

#orgRegBtn:hover {
	background-color: #ff5f2c;
}

#ynMessage > table {
    width: 100%;
    border-collapse: separate;
    margin: 20px 0;
    font-size: 14px;
    text-align: left;
}

#ynMessage > table th, 
#ynMessage > table td {
    padding: 12px;
    border-bottom: 1px solid #ddd;
}

#ynMessage > table th {
    background-color: #f4f4f4;
    font-weight: bold;
}

#ynMessage > table .edit-button {
    background-color: #fff;
    padding: 5px 10px;
    border: 1px solid #ddd;
    cursor: pointer;
}

#ynMessage > table .edit-button:hover {
    background-color: #eee;
}

</style>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	<div id="orgContainer">
		<h1 id="orgTitle">기업 전시/박람회 등록</h1>

		<div id="orgTerms">
			<h3>(주)티글 전시회 및 박람회 등록 및 홍보 약관</h3>
			<br>
			<h4>제1조 (목적)</h4>
			<p>
				본 약관은 (주)티글(이하 "회사")이 운영하는 홈페이지에서 제공하는 전시회 및 박람회 등록과 홍보 서비스(이하 "서비스")를 
				이용함에 있어 회사와 이용자 간의 권리, 의무 및 책임사항을 규정함을 목적으로 합니다.
			</p>
			<br>
			<h4>제2조 (용어의 정의)</h4>
			<p>	1. "회원"이라 함은 회사의 홈페이지에 접속하여 본 약관에 따라 회사가 제공하는 서비스를 이용하는 개인, 법인, 단체를 말합니다.<br>
				2. "전시자"라 함은 전시회 또는 박람회를 등록하고 홍보하는 회원을 말합니다.<br>
				3. "전시회/박람회"라 함은 회원이 등록하고자 하는 다양한 전시회, 박람회, 세미나 등 행사 일체를 의미합니다.<br>
				4. "서비스"라 함은 전시회 및 박람회를 홍보할 수 있도록 회사가 제공하는 온라인 등록 및 홍보 플랫폼을 말합니다.
			</p>
			<br>
			<h4>제3조 (서비스 내용)</h4>
			<p>	1. 회사는 전시자에게 전시회 및 박람회를 홈페이지에 등록하고 홍보할 수 있는 서비스를 제공합니다.<br>
				2. 전시자는 전시회/박람회에 대한 정확한 정보를 제공해야 하며, 등록된 정보는 회사의 검토 후 승인이 이루어집니다.<br>
				3. 회사는 전시자가 제공한 정보를 기반으로 전시회/박람회 내용을 홈페이지를 통해 홍보합니다.
			</p>
			<br>
			<h4>제4조 (전시 등록 절차)</h4>
			<p>	1. 전시자는 전시회 또는 박람회 등록을 위해 필요한 세부 정보를 작성하고, 회사의 승인을 받아야 합니다.<br>
				2. 등록된 전시회/박람회는 관리자의 승인이 완료된 후에만 홈페이지에 노출됩니다.<br>
				3. 전시자는 전시회/박람회의 내용이 변경될 경우, 즉시 회사에 해당 변경 사항을 통보해야 합니다.
			</p>
			<br>
			<h4>제5조 (전시 정보의 수정 및 삭제)</h4>
			<p>	1. 전시자는 언제든지 등록된 전시회/박람회 정보를 수정할 수 있으며, 수정된 정보는 회사의 검토 후 반영됩니다.<br>
				2. 전시회/박람회의 취소 또는 삭제가 필요한 경우, 전시자는 회사에 이를 요청해야 하며, 회사는 해당 요청을 검토 후 처리합니다.
			</p>
			<br>
			<h4>제6조 (서비스 이용의 제한)</h4>
			<p>	회사는 다음의 경우 서비스 이용을 제한할 수 있습니다:<br>
				1. 전시자가 허위 정보를 제공하거나 부정한 목적으로 서비스를 이용하는 경우<br>
				2. 타인의 권리를 침해하거나 관련 법령을 위반한 경우<br>
				3. 기타 회사의 운영 정책에 위배되는 행위를 한 경우
			</p>
			<br>
			<h4>제7조 (면책조항)</h4>
			<p>	1. 회사는 전시회의 실제 운영 및 진행에 관여하지 않으며, 장소 제공이나 관리에 대한 책임을 지지 않습니다.<br>
				2. 전시회 및 박람회의 내용과 관련된 모든 책임은 전시자에게 있으며, 회사는 그와 관련한 법적 책임을 지지 않습니다.<br>
				3. 회사는 서비스 제공과 관련하여 발생하는 기술적 문제나 시스템 오류에 대해 책임을 지지 않으며, 이를 신속히 해결하기 위해 최선을 다합니다.
			</p>
			<br>
			<h4>제8조 (정보 제공 및 광고)</h4>
			<p>	1. 회사는 전시자에게 전시회/박람회 홍보를 위한 추가 자료 제공을 요청할 수 있습니다.<br>
				2. 전시자는 제공한 자료와 관련한 모든 저작권 및 법적 책임을 지며, 회사는 이를 홍보 목적으로 사용할 수 있습니다.
			</p>
			<br>
			<h4>제9조 (전시회의 제한 및 금지)</h4>
			<p>	1. 전시자는 회사의 승인을 받은 전시회/박람회만을 등록할 수 있습니다.<br>
				2. 회사는 전시회의 내용이 법령에 위배되거나, 타 전시자 및 관람객에게 피해를 줄 수 있는 경우 전시 등록을 제한할 수 있습니다.<br>
				3. 전시자는 전시회의 목적에 맞지 않는 현장 판매 활동을 원칙적으로 금지하며, 필요한 경우 별도 허가를 받아야 합니다.
			</p>
			<br>
			<h4>제10조 (분쟁 해결)</h4>
			<p>전시자와 회사 간에 발생하는 분쟁은 상호 협의하여 해결하며, 협의가 이루어지지 않을 경우 대한민국 법령에 따라 관할 법원의 조정을 따릅니다.</p>
		</div>

		<div id="ynMessage">
		    <table>
		        <thead>
		            <tr>
		                <th align="center">분류</th>
		                <th align="center">제목</th>
		                <th align="center">신청자</th>
		                <th align="center">시작일</th>
		                <th align="center">종료일</th>
		                <th align="center">수정</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach items="${ requestScope.list }" var="list">
		                <tr>
		                	<td align="center">
	                    		<c:if test="${ list.eCategory eq 1 }">전시회</c:if>
	                    		<c:if test="${ list.eCategory eq 2 }">박람회</c:if>
                    		</td>
		                    <td align="center">${ list.title }</td>
		                    <td align="center">${ list.name }</td>
		                    <td align="center">
		                        <fmt:formatDate value="${ list.startDate }" pattern="yyyy-MM-dd" />
		                    </td>
		                    <td align="center">
		                        <fmt:formatDate value="${ list.endDate }" pattern="yyyy-MM-dd" />
		                    </td>
		                    <td align="center">
		                        <c:url var="editLink" value="orgRegEdit.do">
		                            <c:param name="num" value="${ list.totalId }" />
		                            <c:param name="page" value="${ currentPage }" />
		                        </c:url>
		                        <a href="${ editLink }" class="edit-button">수정</a>
		                    </td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		</div>

		<div id="orgBtn">
			<form action="orgRegDetail.do" method="post">
				<input type="submit" value="전시등록" id="orgRegBtn">
			</form>
		</div>
	</div>
	<br>
	<c:import url="/WEB-INF/views/common/pagingView.jsp" />
	<br><br><br><br>
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>



