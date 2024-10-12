<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
	
	<section class="container">
		<div class="l_title">
			<img src="/tiggle/resources/images/tiggle_logo.png" alt="">
			<p>아이디 찾기</p>
		</div><!-- l_title end -->

		<ul class="select_findid">
			<li>일반회원</li>
			<li>전시관계자</li>
		</ul><!-- select_findid end -->

		<div class="find_id_wrap">
			<!-- <p>이메일로 찾기</p> -->
			<form action="findide.do" method="post">
				<div class="find_id">
					<input type="text" name="name" required placeholder="이름">
					<input type="email" name="email" required placeholder="예) tiggle@tiggle.com">
				</div><!-- find_id end -->

				<input type="submit" value="이메일로 찾기" class="find_id_btn">
			</form>
		</div><!-- find_id_wrap end -->
		
		<div class="find_id_wrap">
			<!-- <p>전화번호로 찾기</p> -->
			<form action="findidp.do" method="post">
				<div class="find_id">
					<input type="text" name="name" required placeholder="이름">
					<input type="tel" name="phone" required placeholder="예) 010-1234-5678">
				</div><!-- find_id end -->

				<input type="submit" value="전화번호로 찾기" class="find_id_btn">
			</form>
		</div><!-- find_id_wrap end -->

		<div class="find_orgid_wrap">
			<!-- <p>이메일로 찾기</p> -->
			<form action="findOrgIde.do" method="post">
				<div class="find_id">
					<input type="text" name="orgName" required placeholder="기관명">
					<input type="email" name="orgEmail" required placeholder="예) tiggle@tiggle.com">
				</div><!-- find_id end -->

				<input type="submit" value="기관 이메일로 찾기" class="find_id_btn">
			</form>
		</div><!-- find_orgid_wrap end -->
		
		<div class="find_orgid_wrap">
			<!-- <p>전화번호로 찾기</p> -->
			<form action="findOrgIdp.do" method="post">
				<div class="find_id">
					<input type="text" name="orgName" required placeholder="기관명">
					<input type="tel" name="phone" required placeholder="예) 010-1234-5678">
				</div><!-- find_id end -->

				<input type="submit" value="담당자 전화번호로 찾기" class="find_id_btn">
			</form>
		</div><!-- find_orgid_wrap end -->
	</section><!-- container end -->


	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			const memberTab = document.querySelector(".select_findid li:nth-child(1)");  // 일반회원 탭
			const orgTab = document.querySelector(".select_findid li:nth-child(2)");    // 전시관계자 탭
			const findIdWraps = document.querySelectorAll(".find_id_wrap");               // 일반회원 폼
			const findOrgIdWraps = document.querySelectorAll(".find_orgid_wrap");         // 전시관계자 폼
		
			// 기본 설정
			memberTab.classList.add("s_fid"); // 기본적으로 일반회원 탭에 .s_fid 클래스 추가
			findOrgIdWraps.forEach(wrap => wrap.classList.add("d_none")); // 전시관계자 폼 숨김
		
			// 일반회원 탭 클릭 이벤트
			memberTab.addEventListener("click", function() {
				memberTab.classList.add("s_fid"); // 일반회원 탭에 .s_fid 클래스 추가
				orgTab.classList.remove("s_fid"); // 전시관계자 탭에서 .s_fid 클래스 제거
		
				findIdWraps.forEach(wrap => wrap.classList.remove("d_none")); // 일반회원 폼 보이기
				findOrgIdWraps.forEach(wrap => wrap.classList.add("d_none")); // 전시관계자 폼 숨기기
			});
		
			// 전시관계자 탭 클릭 이벤트
			orgTab.addEventListener("click", function() {
				orgTab.classList.add("s_fid"); // 전시관계자 탭에 .s_fid 클래스 추가
				memberTab.classList.remove("s_fid"); // 일반회원 탭에서 .s_fid 클래스 제거
		
				findOrgIdWraps.forEach(wrap => wrap.classList.remove("d_none")); // 전시관계자 폼 보이기
				findIdWraps.forEach(wrap => wrap.classList.add("d_none")); // 일반회원 폼 숨기기
			});
		});
	</script>
</body>
</html>