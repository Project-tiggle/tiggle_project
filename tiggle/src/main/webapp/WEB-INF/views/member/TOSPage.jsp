<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티글 회원가입</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<!-- 이용약관 페이지 -->
	<div class="tos_section">
		<div class="tos_wrap">
			<div class="tos_title">
				<img src="/tiggle/resources/images/tiggle_logo.png" alt="tiggle_logo">
				<p>약관동의</p>
			</div><!-- tos_title end -->
			
			<div class="tos_content">
				<form action="/" method="post" id="tos_form">
					<input type="hidden" name="marketingYN" value="marketingYN">
					<input type="hidden" name="org_enroll" value="org_enroll">
					<div class="tos_check_all">
						<input type="checkbox" name="tosCheckAll" id="check_all">
						<label for="check_all">모두 동의합니다.</label>
						<p>
							전체 동의는 필수 및 선택정보에 대한 동의도 포함되어 있으며, 개별적으로도 동의를 선택하실 수 있습니다. 선택항목에 대한 동의를 거부하시는 경우에도 서비스는 이용이 가능합니다.
						</p>
					</div><!-- tos_check_all end -->

					<ul class="tos_list">
						<li class="tos_box">
							<input type="checkbox" name="agreement" id="tos1" value="tos1">
							<label for="tos1">[필수] 이용약관 동의</label>
							<button type="button" class="tos_txt_btn">내용보기</button>
						</li><!-- tos_box end -->
						<li class="tos_box">
							<input type="checkbox" name="agreement" id="tos2" value="tos2">
							<label for="tos2">[필수] 개인정보 수집 및 이용 동의</label>
							<button type="button" class="tos_txt_btn">내용보기</button>
						</li><!-- tos_box end -->
						<li class="tos_box">
							<input type="checkbox" name="agreement" id="marketingYN" value="marketingYN">
							<label for="marketingYN">[선택] 자사 마케팅 수집 및 이용 동의</label>
							<p>
								개인정보 제공에 대한 동의를 거부할 권리가 있으며, 동의를 거부할 경우 마케팅 정보를 받을 수 없습니다.
							</p>
						</li><!-- tos_box end -->
					</ul><!-- tos_list end -->

					<div class="org_tos">
						<input type="checkbox" name="org_enroll" id="org_enroll" value="org_enroll">
						<label for="org_enroll">전시관계자 회원가입</label>
						<p>
							'티글'에 전시정보를 등록할 전시관계자는 반드시 체크하세요.
						</p>
					</div><!-- org_tos end -->

					<button type="submit" class="agree_btn" id="agreeBtn" disabled>동의</button>
				</form><!-- tos_form end -->
			</div><!-- tos_content end -->

			<div class="tos_move_home">
				<a href="main.do">홈으로 이동</a>
			</div>
		</div><!-- tos_wrap end -->
	</div><!-- tos_section end -->
	<!-- 이용약관 페이지 end -->
	


	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
</body>
</html>