<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<!-- 회원가입 페이지 -->
	<div class="enroll_section">
	
		<div class="enroll_top">
			<div class="logo">
                <a href="main.do">
                    <img class="logo_img" src="/tiggle/resources/images/tiggle_logo.png" alt="logo">
                    <span>TIGGLE</span>
                </a>
            </div><!-- logo end -->

			<div class="e_top_title">정보입력</div>
		</div><!-- enroll_top end -->

		<div class="enroll_wrap">
			<form action="enroll.do" method="post" onsubmit="return validatePwd();">
				<input type="hidden" name="marketingYN" value="${param.marketingYN}">
				<div class="enroll_box">
					<div class="enroll_list">
						<p>아이디</p>
						<input type="text" name="id" id="enroll_id" placeholder="6~20자 영문시작, 숫자포함" required>
						<input type="button" value="중복확인" onclick="return dupIdCheck();">
					</div>

					<div class="enroll_list">
						<p>비밀번호</p>
						<input type="password" name="pwd" id="enroll_pwd" placeholder="영문, 숫자, 특수문자 포함가능" required>
					</div>
					
					<div class="enroll_list">
						<p>비밀번호 확인</p>
						<input type="password" id="enroll_pwd2" placeholder="영문, 숫자, 특수문자 포함가능" required>
					</div>

					<div class="enroll_list">
						<p>이름</p>
						<input type="text" name="name" id="enroll_name" placeholder="이름 입력" required>
					</div>

					<div class="enroll_list">
						<p>이메일</p>
						<input type="email" name="email" id="enroll_email" placeholder="tiggle@tiggle.com" required>
						<input type="button" id="mail_check_btn" value="인증메일 발송" onclick="return mailSend();">
					</div>
					
					<div class="enroll_list">
						<p>인증번호</p>
						<input type="text" id="mail_check_input" placeholder="인증번호 입력" required>
						<input type="button" id="mail_certify_btn" value="인증" onclick="return mailValidate();">
						<input type="hidden" id="email_double_check" name="email_double_check" value="false">
					</div>

					<div class="enroll_list">
						<p>연락처</p>
						<input type="tel" name="phone" id="enroll_phone" placeholder="010-1234-5678" required>
					</div>

					<div class="enroll_list">
						<p>닉네임</p>
						<input type="text" name="nickname" id="enroll_nickname" placeholder="닉네임 입력" required>
					</div>
				</div><!-- enroll_box end -->

				<button type="submit" class="e_success_btn">가입완료</button>

				<div class="tos_move_home">
					<a href="main.do">홈으로 이동</a>
				</div>
			</form>
		</div><!-- enroll_wrap end -->
	</div><!-- enroll_section end -->
	<!-- 회원가입 페이지 end -->
	


	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
</body>
</html>