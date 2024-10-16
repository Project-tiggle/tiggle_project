<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="shortcut icon" href="/tiggle/resources/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
</head>
<body>
    <!-- footer start -->
    <footer class="footer">
        <div class="f_top">
            <nav>
                <ul class="f_menu">
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">위치기반서비스 이용약관</a></li>
                    <li><a href="#">티켓판매안내</a></li>
                    <c:if test="${ empty sessionScope.loginMember }">
                    	<li><a href="noneMemCBoard.do">고객센터</a></li>
                    </c:if>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ADMIN' }">
                    	<li><a href="adminCustBoard.do">고객센터</a></li>
                    </c:if>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType ne 'ADMIN' }">
                    	<li><a href="userCustBoard.do">고객센터</a></li>
                    </c:if>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ORGANIZER' }">
                    	<li><a href="orgRegistPage.do">전시등록</a></li>
                    </c:if>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ADMIN' }">
                    	<li><a href="orgRegistAd.do">전시등록</a></li>
                    </c:if>
                    <c:if test="${ empty sessionScope.loginMember or (!empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'USER') }">
                    	<li><a href="loginPage.do">전시등록</a></li>
                    </c:if>
                </ul><!-- f_menu end -->
            </nav>
        </div><!-- f_top end -->

        <div class="f_bt">
            <div class="f_info">
                <div class="f_left">
                    <p>TIGGLE</p>
                    <p>주소 &ndash; 서울시 서초구 서초대로77길 41, 4층(서초동, 대동II)</p>
                    <p>사업자등록번호 &ndash; 012-34-56789</p>
                    <p>통신판매업신고 &ndash; 2024-서울서초-1234</p>
                    <p>대표이사 &ndash; 아캔두</p>
                </div><!-- f_left end -->

                <div class="f_right">
                    <p>고객센터</p>
                    <p>전화번호 02-123-4567</p>
                    <p>팩스번호 02-123-4568</p>
                    <p>이메일 tiggle@tiggle.com</p>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ADMIN' }">
                    	<p><a href="adminCustBoard.do">1:1 문의</a></p>
                    </c:if>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ORGANIZER' }">
                    	<p><a href="inquiry.do">1:1 문의</a></p>
                    </c:if>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'USER' }">
                    	<p><a href="inquiry.do">1:1 문의</a></p>
                    </c:if>
                    <c:if test="${ empty sessionScope.loginMember }">
                    	<p><a href="loginPage.do">1:1 문의</a></p>
                    </c:if>
                </div><!-- f_right end -->
            </div><!-- f_info end -->

            <div class="f_copy">
                <p>(주)티글은 티글서비스의 통신판매중개자로서 통신판매의 대상자가 아니므로, 전시관계자가 등록한 전시에 대해서 (주)티글은 일체 책임을 지지 않습니다.</p>
                <p>Copyright &copy; Tiggle Corp. All Rights Reserved.</p>
            </div><!-- f_copy end -->
        </div><!-- f_bt end -->
    </footer><!-- footer end -->

    <script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
    <script src="/tiggle/resources/js/script.js"></script>
</body>
</html>