<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>1:1 문의</title>

<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/member_style.css">
<link rel="stylesheet" href="/tiggle/resources/css/custBoard_style.css">

<script type="text/javascript">
$(function(){
	//input 태그의 name이 item인 radio 값이 바뀌면(change) 작동되는 이벤트 핸들러 작성
	//jQuery('태그선택자').실행할메소드명(.....); => jQuery 는 줄여서  $로 표시함
	$('input[name=item]').on('change', function(){
		//3개의 item 중에 체크표시가 된 radio 를 선택 => 반복 처리 : each() 메소드 사용
		$('input[name=item]').each(function(index){
			//선택된 radio 순번대로 하나씩 checked 인지 확인함 : is() 메소드 사용
			if($(this).is(':checked')){
				//체크 표시된 아이템에 대한 폼이 보여지게 처리함
				$('form.sform').eq(index).css('display', 'block');
			}else{
				//체크 표시 안된 아이템에 대한 폼이 안 보여지게 처리함
				$('form.sform').eq(index).css('display', 'none');
			}
		});  //each
		
	});  //onchange
}); //document.ready
</script>

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
				<p>1:1문의 (관리자용)</p>
			</div>
			<!-- myinfo_title end -->

			<div id="boardTable">
				<table id="dataTable">
					<thead>
						<tr>
							<th align="center">No</th>
							<th align="center">처리상태</th>
							<th align="center">제목</th>
							<th align="center">첨부파일</th>
							<th align="center">작성자</th>
							<th align="center">등록일</th>
							<th align="center">수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ requestScope.list }" var="list">
							<tr>
								<td align="center">${ list.cId }</td>
																
								<td align="center">
									<c:if test="${ list.replyYn eq 'N' and empty list.deletedAt }">
										<b style="color: #ff5f2c;">답변대기</b>
									</c:if>
								</td>
								
								<!-- 제목 -->
								<td style="text-align: left;">
									<c:url var="cDetail" value="custbDetail.do">
										<c:param name="cId" value="${ list.cId }" />
										<c:param name="page" value="${ currentPage }" />
									</c:url>
									
									<c:if test="${ list.cLev eq 1 }">
										<a href="${ cDetail }">
											<c:if test="${ empty list.deletedAt }">
												<b>${ list.title }</b>
											</c:if>
											<c:if test="${ !empty list.deletedAt }">
												[${ list.deletedAt } 삭제] <del>${ list.title }</del>
											</c:if>
										</a>
									</c:if>
									<c:if test="${ list.cLev eq 2 }">
										<a href="${ cDetail }">
											<c:if test="${ empty list.deletedAt }">
												&#x21B3; [Re:No.${ list.refNo }] ${ list.title }
											</c:if>
											<c:if test="${ !empty list.deletedAt }">
												&#x21B3; [Re:No.${ list.refNo }] <del>${ list.title }</del>
											</c:if>
										</a>
									</c:if>
								</td>
								<!-- 제목 여기까지 -->
								
								<td align="center">
									<c:if test="${ empty list.fileUrl }"></c:if>
									<c:if test="${ !empty list.fileUrl }">
										<img src="/tiggle/resources/images/attach_file_icon.png" style="width: 24px; position: relative; top: 2px;">
									</c:if>
								</td>

								<td align="center">${ list.id }</td>
								<td align="center">${ list.createdAt }</td>
								<td align="center">${ list.updatedAt }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
			<div class="">
				<form action="cbSearch.do" method="get" id="cbSearch">
					<select name="sOption" class="search_option">
						<option value="">검색</option>
						<option value="cbNo">번호</option>
						<option value="cbTitle">제목</option>
						<option value="cbId">아이디</option>
					</select>

					<input type="text" name="keyword" style="padding: 5px;">
					<input type="submit" value="검색" style="padding: 5px;">
				</form>
			</div>
			<c:import url="/WEB-INF/views/common/pagingView.jsp" />
			<br><br><br><br>
		</div>
	</div>
	
	

	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>