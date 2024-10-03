<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 전시/박람회 등록</title>
<style>
.container {
	width: 80%;
	margin: 0 auto;
}

.title {
	font-size: 24px;
	margin-bottom: 20px;
	text-align: left;
}

.table-space {
	width: 100%;
	height: 200px; /* 표가 들어갈 공간의 높이 설정 */
	border: 1px solid #000;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 20px;
}

.table-space p {
	text-align: center;
	font-size: 16px;
	color: #666;
}

.message {
	font-weight: bold;
	margin-bottom: 20px;
	border: 1px solid;
	padding: 10px;
}

.buttons {
	display: flex;
	justify-content: flex-end; /* 버튼들을 오른쪽 정렬 */
	align-items: center;
	gap: 10px; /* 버튼 사이 간격 */
}

.btn {
	padding: 10px 20px;
	background-color: #ababab5c;
	border: none;
	cursor: pointer;
}

.btn:hover {
	background-color: #ababab97;
}
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	<div class="container">
		<h1 class="title">기업 전시/박람회 등록</h1>

		<div class="table-space">
			<p>혜택내용</p>
		</div>

		<div class="message">등록 승인 상황</div>

		<div class="buttons">
			<form action="orgRegEdit.do" method="get">
				<input type="submit" value="수정하기" class="btn">
			</form>

			<form action="orgRegDetail.do" method="post">
				<input type="submit" value="전시등록" class="btn">
			</form>
		</div>
	</div>
	<br><br><br><br>
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
