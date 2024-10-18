<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 - 티글</title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	
	<section class="container">
		<div class="l_title">
			<img src="/tiggle/resources/images/tiggle_logo.png" alt="">
			<p>비밀번호 찾기</p>
		</div><!-- l_title end -->

		<ul class="select_findpwd">
			<li>일반회원</li>
			<li>전시관계자</li>
		</ul><!-- select_findpwd end -->

		<div class="find_pwd_wrap">
			<form action="tempPwde.do" method="post">
				<div class="find_pwd">
					<input type="text" name="id" required placeholder="아이디">
					<input type="text" name="name" required placeholder="이름">
					<input type="email" name="email" required placeholder="예) tiggle@tiggle.com">
				</div><!-- find_pwd end -->
				
				<input type="submit" value="임시비밀번호 보내기" class="find_pwd_btn">
			</form>
		</div><!-- find_pwd_wrap end -->
		
		<div class="find_orgpwd_wrap">
			<form action="tempOrgPwde.do" method="post">
				<div class="find_pwd">
					<input type="text" name="id" required placeholder="아이디">
					<input type="text" name="orgName" required placeholder="기관명">
					<input type="email" name="orgEmail" required placeholder="기관이메일 예시) tiggle@tiggle.com">
				</div><!-- find_pwd end -->

				<input type="submit" value="임시비밀번호 보내기" class="find_pwd_btn">
			</form>
		</div><!-- find_orgpwd_wrap end -->
	</section><!-- container end -->

	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			const memberTab = document.querySelector(".select_findpwd li:nth-child(1)");  // 일반회원 탭
			const orgTab = document.querySelector(".select_findpwd li:nth-child(2)");    // 전시관계자 탭
			const findPwdWraps = document.querySelectorAll(".find_pwd_wrap");               // 일반회원 폼
			const findOrgPwdWraps = document.querySelectorAll(".find_orgpwd_wrap");         // 전시관계자 폼
		
			// 기본 설정
			memberTab.classList.add("s_fpwd"); // 기본적으로 일반회원 탭에 .s_fpwd 클래스 추가
			findOrgPwdWraps.forEach(wrap => wrap.classList.add("d_none")); // 전시관계자 폼 숨김
		
			// 일반회원 탭 클릭 이벤트
			memberTab.addEventListener("click", function() {
				memberTab.classList.add("s_fpwd"); // 일반회원 탭에 .s_fpwd 클래스 추가
				orgTab.classList.remove("s_fpwd"); // 전시관계자 탭에서 .s_fpwd 클래스 제거
		
				findPwdWraps.forEach(wrap => wrap.classList.remove("d_none")); // 일반회원 폼 보이기
				findOrgPwdWraps.forEach(wrap => wrap.classList.add("d_none")); // 전시관계자 폼 숨기기
			});
		
			// 전시관계자 탭 클릭 이벤트
			orgTab.addEventListener("click", function() {
				orgTab.classList.add("s_fpwd"); // 전시관계자 탭에 .s_fpwd 클래스 추가
				memberTab.classList.remove("s_fpwd"); // 일반회원 탭에서 .s_fpwd 클래스 제거
		
				findOrgPwdWraps.forEach(wrap => wrap.classList.remove("d_none")); // 전시관계자 폼 보이기
				findPwdWraps.forEach(wrap => wrap.classList.add("d_none")); // 일반회원 폼 숨기기
			});
		});
	</script>
</body>
</html>