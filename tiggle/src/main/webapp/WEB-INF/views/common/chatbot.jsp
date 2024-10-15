<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="currentLimit" value="${ requestScope.limit }" />
<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>챗봇</title>
<link rel="stylesheet" href="resources/css/chatbot.css">
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="resources/js/jquery-3.7.1.min.js"></script>
<script src="https://kit.fontawesome.com/57c4d26627.js" crossorigin="anonymous"></script>
</head>
<body>
	<section id="cb_box">
		<div class="s_cb_top">
			<a href="main.do">
				<img class="logo_img" src="/tiggle/resources/images/tiggle_logo.png" alt="logo">
				<span>TIGGLE 챗봇</span>
			</a>
		</div><!-- s_cb_top end -->

		<div class="s_cb">
			<div id="s_cb_title">
				<p>챗봇 모바일 상담 서비스</p>
			</div><!-- s_cb_title end -->
			
			<div id="ch_setting">
				<div class="chatbot-container">
					<div id="chatbot">
						<div id="conversation">
							<div class="chatbot-message">
								<p class="chatbot-text">안녕하세요! 티켓이 와글와글<br>'티글'의 챗봇 티티입니다.<br>무엇을 검색하시겠어요? <i class='fa-regular fa-face-smile'></i></p><!-- chatbot-text end -->
							</div><!-- chatbot-message end -->
						</div><!-- conversation end -->
						
						<form id="input-form">
							<message-container>
								<input type="text" id="input-field" placeholder="질문을 입력하세요">
								<button type="submit" id="submitBtn">제출</button>
							</message-container>
						</form><!-- input-form end -->
					</div><!-- chatbot end -->
				</div><!-- chatbot-container end -->
			</div><!-- ch_setting end -->
		</div><!-- s_cb end -->
	</section><!-- cb_box end -->

	<div class="cb_move_home">
		<a href="main.do">홈으로 이동</a>
	</div>
	
	<script type="text/javascript">
		// Add event listener to input form
		inputForm
				.addEventListener(
						'submit',
						function(event) {
							// Prevent form submission
							event.preventDefault();

							// Get user input
							const input = inputField.value;

							// Get checked checkbox values
							const checkedItems = [];
							const checkboxA = document
									.getElementById('checkboxA');
							const checkboxB = document
									.getElementById('checkboxB');
							if (checkboxA.checked) {
								checkedItems.push(checkboxA.value);
							}
							if (checkboxB.checked) {
								checkedItems.push(checkboxB.value);
							}

							// Clear input field
							inputField.value = '';
							const currentTime = new Date()
									.toLocaleTimeString([], {
										hour : '2-digit',
										minute : "2-digit"
									});

							// Add user input to conversation
							let message = document.createElement('div');
							message.classList.add('chatbot-message',
									'user-message');
							message.innerHTML = `<p class="chatbot-text" sentTime="${currentTime}">${input}</p>`;
							conversation.appendChild(message);

							// Generate chatbot response
							const response = generateResponse(input,
									checkedItems);

							// Add chatbot response to conversation
							message = document.createElement('div');
							message.classList.add('chatbot-message',
									'chatbot');
							message.innerHTML = `<p class="chatbot-text" sentTime="${currentTime}">${response}</p>`;
							conversation.appendChild(message);
							message.scrollIntoView({
								behavior : "smooth"
							});
						});
	</script>
	<script src="resources/js/chatbot.js"></script>
</body>
</html>