<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />



	<!-- 마이페이지 회원탈퇴 -->
	<div class="myinfo_section">
		<aside class="myinfo_aside">
			<div class="mypage_title">
				<p>마이페이지</p>
			</div><!-- mypage_title -->

			<nav>
				<ul class="left_menu">
					<li><a href="myInfo.do?uuid=${ sessionScope.loginMember.uuid }">내정보 보기</a></li>
					<li><a href="#">예약확인 / 취소</a></li>
					<li><a href="userCustBoard.do">1:1 문의내역</a></li>
					<li><a href="delMemPage.do">회원탈퇴</a></li>
				</ul><!-- left_ menu end -->
			</nav>
		</aside><!-- myinfo_aside end -->

		<div class="myinfo_content">
			<div class="myinfo_title">
				<p>회원탈퇴</p>
			</div><!-- myinfo_title end -->
			
			<div class="myinfo_wrap">
				<div class="orginfo_top">
					<c:if test="${ !empty sessionScope.loginMember.id  }">
						<p><span>${ requestScope.member.id }</span> 님</p>
					</c:if>
					<c:if test="${ empty sessionScope.loginMember.id && !empty sessionScope.loginMember.name  }">
						<p><span>${ requestScope.member.name }</span> 님</p>
					</c:if>
					<c:if test="${ empty sessionScope.loginMember.id && empty sessionScope.loginMember.name  }">
						<p><span>${ requestScope.member.nickname }</span> 님</p>
					</c:if>
					<p>정말 탈퇴하시겠어요?</p>
					<p>계정을 삭제하면 한줄평, 예약정보 등 모든 정보가 삭제됩니다.</p>
					<p>계정 삭제 후 7일간 다시 가입하지 못해요.</p>
				</div><!-- orginfo_top end -->

				<div class="orginfo_bt">
					<p>저희 서비스에서 불편사항이 있었나요?</p>
					<form action="deleteMember.do" method="post" id="del_reason_wrap">
						<input type="hidden" name="uuid" value="${ requestScope.member.uuid }">
						<div class="del_reason_list">
							<input type="checkbox" name="deletedReason" id="del_reason_check1" value="기록 삭제 목적" onclick="oneDelCheck(this);">
							<span>기록 삭제 목적</span>
						</div>
						<div class="del_reason_list">
							<input type="checkbox" name="deletedReason" id="del_reason_check2" value="이용이 불편하고 장애가 많아서" onclick="oneDelCheck(this);">
							<span>이용이 불편하고 장애가 많아서</span>
						</div>
						<div class="del_reason_list">
							<input type="checkbox" name="deletedReason" id="del_reason_check3" value="다른 사이트가 더 좋아서" onclick="oneDelCheck(this);">
							<span>다른 사이트가 더 좋아서</span>
						</div>
						<div class="del_reason_list">
							<input type="checkbox" name="deletedReason" id="del_reason_check4" value="사용 빈도가 낮아서" onclick="oneDelCheck(this);">
							<span>사용 빈도가 낮아서</span>
						</div>

						<div class="del_agree">
							<input type="checkbox" name="delAgree" id="del_agree_check" required>
							<span>안내사항을 모두 확인하였으며, 이에 동의합니다.</span>
						</div><!-- del_agree end -->

						<div class="del_btn_wrap">
							<input type="button" value="메 인">
							<input type="submit" value="회원탈퇴">
						</div><!-- del_btn_wrap end -->
					</form>
				</div><!-- orginfo_bt end -->
			</div><!-- myinfo_wrap end -->
		</div><!-- myinfo_content end -->
	</div><!-- myinfo_section end -->
	<!-- 마이페이지 회원정보 수정 end -->


	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
	<script src="/tiggle/resources/js/member_script.js"></script>
</body>
</html>