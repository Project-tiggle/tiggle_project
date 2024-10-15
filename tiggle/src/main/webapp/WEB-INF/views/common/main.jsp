<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>티글</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />

	
	<!-- main section start -->
	<div class="main">
		<div class="main_slide">
			 <div class="swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<a href="${ pageContext.servletContext.contextPath }/exhibitionDetail.do?no=12">
							<img src="/tiggle/resources/images/pc_slide_1.jpg" alt="main_img1" class="main_img1">
						</a>
					</div>
					<div class="swiper-slide">
						<a href="${ pageContext.servletContext.contextPath }/exhibitionDetail.do?no=46">
							<img src="/tiggle/resources/images/pc_slide_2.jpg" alt="main_img2" class="main_img2">
						</a>
					</div>
					<div class="swiper-slide">
						<a href="${ pageContext.servletContext.contextPath }/exhibitionDetail.do?no=13">
							<img src="/tiggle/resources/images/pc_slide_3.jpg" alt="main_img3" class="main_img3">
						</a>
					</div>
					<div class="swiper-slide">
						<a href="${ pageContext.servletContext.contextPath }/exhibitionDetail.do?no=44">
							<img src="/tiggle/resources/images/pc_slide_4.jpg" alt="main_img4" class="main_img4">
						</a>
					</div>
					<div class="swiper-slide">
						<a href="${ pageContext.servletContext.contextPath }/exhibitionDetail.do?no=26">
							<img src="/tiggle/resources/images/pc_slide_5.jpg" alt="main_img5" class="main_img5">
						</a>
					</div>
				</div><!-- swiper_wrapper end -->

    			<div class="swiper-button-prev"></div>
				<div class="swiper-button-next"></div>

				<div class="swiper-pagination"></div>
			 </div><!-- swiper-container end -->
		</div><!-- main_slide end -->
	
	
	
		<!-- 맨 하단에 공지사항 출력 -->
		<div class="main_notice">
			<div class="main_notice_top">
				<p>새로운 공지사항</p>
				<p>
					<a href="nlist.do?page=1">전체보기 <span>&gt;</span></a>
				</p>
			</div><!-- main_notice_top end -->

			<!-- <div class="new_notice_top">
				<p>NO</p>
				<p>제목</p>
				<p>등록날짜</p>
			</div> -->
			<!-- new_notice_top -->

			<div class="swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<div class="new_notice" id="new_notice1">
							<p></p><!-- 번호 -->
							<p></p><!-- 제목 -->
							<p></p><!-- 등록날짜 -->
						</div>
					</div><!-- swiper-slide end 1 -->
					<div class="swiper-slide">
						<div class="new_notice" id="new_notice2">
							<p></p><!-- 번호 -->
							<p></p><!-- 제목 -->
							<p></p><!-- 등록날짜 -->
						</div>
					</div><!-- swiper-slide end 2 -->
					<div class="swiper-slide">
						<div class="new_notice" id="new_notice3">
							<p></p><!-- 번호 -->
							<p></p><!-- 제목 -->
							<p></p><!-- 등록날짜 -->
						</div>
					</div><!-- swiper-slide end 3 -->
				</div><!-- swiper-wrapper end -->
			</div><!-- swiper-container end -->
		</div><!-- main_notice end -->
	</div><!-- main end -->
	<!-- main section end -->
	
	<a href="chatbot.do" class="chatbot_wrap"><img src="/tiggle/resources/images/chatbot.png" alt="챗봇로고"></a>
	
	<c:import url="/WEB-INF/views/common/footer.jsp" />

	<script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
	<script src="/tiggle/resources/js/script.js"></script>
</body>
</html>




















