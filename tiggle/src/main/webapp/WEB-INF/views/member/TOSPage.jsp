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
	<c:import url="/WEB-INF/views/common/header.jsp" />


	<!-- 이용약관 페이지 -->
	<div class="tos_section">
		<div class="tos_wrap">
			<div class="tos_title">
				<img src="/tiggle/resources/images/tiggle_logo.png" alt="tiggle_logo">
				<p>약관동의</p>
			</div>

			





			<!-- <div class="all_check">
				<label class="tos_checkbox">
					<input type="checkbox" class="tos_all">
					<p class="tos_txt">모두 동의합니다.</p>
				</label>
				<p>
					전체 동의는 필수 및 선택정보에 대한 동의도 포함되어 있으며, 개별적으로도 동의를 선택하실 수 있습니다. 선택항목에 대한 동의를 거부하시는 경우에도 서비스는 이용이 가능합니다.
				</p>
			</div>
			
			<ul class="tos_list">
				<li class="tos_list_item">
					<label class="tos_checkbox">
						<input type="checkbox" required class="tos_chk_btn">
						<p class="tos_txt">[필수] 이용약관 동의</p>
					</label>
					<button type="button" class="tos_txt_btn">내용보기</button>
				</li>
				<li class="tos_list_item">
					<label class="tos_checkbox">
						<input type="checkbox" required class="tos_chk_btn">
						<p class="tos_txt">[필수] 개인정보 수집 및 이용 동의</p>
					</label>
					<button type="button" class="tos_txt_btn">내용보기</button>
				</li>
				<li class="tos_list_item">
					<label class="tos_checkbox">
						<input type="checkbox" class="tos_chk_btn">
						<p class="tos_txt">[선택] 자사 마케팅 수집 및 이용 동의</p>
					</label>
					<p>개인정보 제공에 대한 동의를 거부할 권리가 있으며, 동의를 거부할 경우 마케팅 정보를 받을 수 없습니다.</p>
				</li>
			</ul>

			<div class="org_agree_wrap">
				<label class="org_agree">
					<input type="checkbox" class="org_agree_check">
					<p class="tos_txt">전시관계자 회원가입</p>
				</label>
				<p>
					'티글'에 전시정보를 등록할 전시관계자는 반드시 체크하세요.
				</p>
			</div>

			<button type="button" class="agree_btn">동의</button> -->
		</div><!-- tos_wrap end -->
	</div><!-- tos_section end -->
	<!-- 이용약관 페이지 end -->
	
	
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>