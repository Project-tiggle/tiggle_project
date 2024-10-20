<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />



	<!-- 관리자페이지 회원정보 수정 -->
	<div class="myinfo_section">
		<aside class="myinfo_aside">
			<div class="mypage_title">
				<p>관리자페이지</p>
			</div><!-- mypage_title -->

			<nav>
				<ul class="left_menu">
					<!-- <li><a href="mlist.do?page=1">회원목록</a></li> -->
					<li><a href="ulist.do?page=1">일반사용자 목록</a></li>
					<li><a href="olist.do?page=1">전시관계자 목록</a></li>
					<li><a href="adminCustBoard.do?page=1">1:1 문의내역</a></li>
				</ul><!-- left_ menu end -->
			</nav>
		</aside><!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<p>일반사용자 목록 (관리자용)</p>
			</div><!-- myinfo_title end -->
			
			
			
			<div class="admin_wrap">
				<div class="m_list_wrap">
					<table class="member_list user_member_list">
						<tr>
							<td>UUID</td>
							<td>아이디</td>
							<td>이름</td>
							<td>닉네임</td>
							<td>이메일</td>
							<td class="dn">연락처</td>
							<td class="dn">가입유형</td>
							<td>수정</td>
						</tr>
						
						<c:forEach items="${ requestScope.memberList }" var="m">
							<tr class="mlist_value_tr">
								<td><p>${ m.uuid }</p></td>
								<td>${ m.id }</td>
								<td>${ m.name }</td>
								<td>${ m.nickname }</td>
								<td>${ m.email }</td>
								<td class="dn">${ m.phone }</td>
								<td class="dn">${ m.signtype }</td>
								<td><button type="button" class="mlist_up_btn" onclick="moveMEditPage('${ m.uuid }');">수정</button></td>
							</tr>
						</c:forEach>
					</table><!-- member_list end -->
				</div><!-- m_list_wrap end -->
			</div><!-- admin_wrap end -->
			
			<div class="mlist_search">
				<form action="userSearch.do" method="get" class="m_search_form" id="m_search_form">
					<select name="sOption" class="search_option">
						<option value="">검색</option>
						<option value="id">아이디</option>
						<option value="name">이름</option>
						<option value="nickname">닉네임</option>
						<option value="email">이메일</option>
					</select>

					<input type="text" name="keyword" class="mlist_search_input">
					<input type="submit" value="검색" class="mlist_search_btn">
				</form>
			</div><!-- mlist_search end -->
			
			<c:import url="/WEB-INF/views/common/pagingSOptionView.jsp" />
		</div><!-- myinfo_content end -->
	</div><!-- myinfo_section end -->
	<!-- 마이페이지 회원정보 수정 end -->


	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
	<script type="text/javascript">
	    function moveMEditPage(uuid) {
	        console.log("UUID: " + uuid); // UUID 확인

	        var form = document.createElement("form");
	        form.setAttribute("method", "post");
	        form.setAttribute("action", "mEditPage.do"); // 요청할 URL

	        var uuidField = document.createElement("input");
	        uuidField.setAttribute("type", "hidden");
	        uuidField.setAttribute("name", "uuid");
	        uuidField.setAttribute("value", uuid); // UUID 값 설정
	        form.appendChild(uuidField); // form에 추가

	        document.body.appendChild(form);
	        form.submit(); // form 제출
	    }
	</script>
</body>
</html>