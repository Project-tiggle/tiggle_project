<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판</title>
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/custBoard_style.css">
<style type="text/css">
#cwCon {
	margin: 30px;
}

#cwFormTable {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

#cwFormTable td {
	padding: 10px;
	text-align: left;
	vertical-align: top;
}

#cwFormTable label {
	font-weight: bold;
}

#cwTitle, #cwWriter, #cwFile {
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 5px;
	width: 100%;
}

#cwContent {
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 5px;
	width: 100%;
}

#cwSubmitBtn, #cwResetBtn, #cwListBtn {
	padding: 10px 15px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-right: 10px;
}

#cwSubmitBtn:hover, #cwResetBtn:hover, #cwListBtn:hover {
	background-color: #45a049;
}

#cwSubmitBtn, #cwResetBtn, #cwListBtn {
	display: inline-block;
	font-size: 16px;
}

input[type="file"] {
	padding: 5px;
}
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	<div class="myinfo_section">
		<aside class="myinfo_aside">
			<div class="mypage_title">
				<p>관리자페이지</p>
			</div>
			<!-- mypage_title -->

			<nav>
				<ul class="left_menu">
					<!-- <li><a href="mlist.do?page=1">회원목록</a></li> -->
					<li><a href="ulist.do?page=1">일반사용자 목록</a></li>
					<li><a href="olist.do?page=1">전시관계자 목록</a></li>
					<li><a href="#">예약확인 / 취소</a></li>
					<li><a href="adminCustBoard.do?page=1">1:1 문의내역</a></li>
				</ul>
				<!-- left_ menu end -->
			</nav>
		</aside>
		<!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<p>1:1문의 ${ cId }번 글 답변 (관리자용)</p>
			</div>
			<!-- myinfo_title end -->

			<div id="cwCon">
				<form action="BoardWriteServlet" method="post"
					enctype="multipart/form-data" id="cwForm">
					<table id="cwFormTable" border="1" cellpadding="10" cellspacing="0">
						<tr>
							<td><label for="cwTitle">제목</label></td>
							<td><input type="text" id="cwTitle" name="title"
								style="width: 400px;" required></td>
						</tr>
						<tr>
							<td><label for="cwWriter">작성자</label></td>
							<td><input type="text" id="cwWriter" name="writer"
								style="width: 200px;" required></td>
						</tr>
						<tr>
							<td><label for="cwContent">내용</label></td>
							<td><textarea id="cwContent" name="content" rows="10"
									cols="50" required></textarea></td>
						</tr>
						<tr>
							<td><label for="cwFile">첨부파일</label></td>
							<td><input type="file" id="cwFile" name="file"
								style="width: 400px;"></td>
						</tr>
					</table>
					<br> <input type="submit" value="글쓰기" id="cwSubmitBtn">
					<input type="reset" value="초기화" id="cwResetBtn"> <input
						type="button" value="목록으로" id="cwListBtn"
						onclick="location.href='listPageURL';">
				</form>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>