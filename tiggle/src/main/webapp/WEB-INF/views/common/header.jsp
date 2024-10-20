<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
</head>
<body>
	<!-- header start -->
	<header class="header">
        <c:if test="${ empty sessionScope.loginMember }"><%-- 로그인 안함 --%>
            <div class="h_top">
                <nav>
                    <ul class="lnb">
                        <li><a href="noneMemCBoard.do">고객센터</a></li>
                        <li><a href="TOSPage.do">회원가입</a></li>
                        <li><a href="loginPage.do">로그인</a></li>
                        <li><a href="loginPage.do">마이페이지</a></li>
                    </ul><!-- lnb end -->
                </nav>
            </div><!-- h_top end -->
        </c:if>
        
        <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType ne 'ADMIN' }"><%-- 로그인 함 --%>
            <div class="h_top">
                <nav>
                    <ul class="lnb">
                    	<c:if test="${ !empty sessionScope.loginMember.name  }">
                        	<li><a href="#" style="color: #333 !important; font-weight: normal !important; cursor: default !important;">${ sessionScope.loginMember.name } 님</a></li>
                    	</c:if>
                    	<c:if test="${ empty sessionScope.loginMember.name && !empty sessionScope.loginMember.nickname  }">
                        	<li><a href="#" style="color: #333 !important; font-weight: normal !important; cursor: default !important;">${ sessionScope.loginMember.nickname } 님</a></li>
                    	</c:if>
                    	<c:if test="${ empty sessionScope.loginMember.name && empty sessionScope.loginMember.nickname  }">
                        	<li><a href="#" style="color: #333 !important; font-weight: normal !important; cursor: default !important;">${ sessionScope.loginMember.id } 님</a></li>
                    	</c:if>
                        <li><a href="logout.do">로그아웃</a></li>
                        <li><a href="myInfo.do?uuid=${ sessionScope.loginMember.uuid }">마이페이지</a></li>
                    </ul><!-- lnb end -->
                </nav>
            </div><!-- h_top end -->
        </c:if>
        
        <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ADMIN' }"><%-- 관리자 로그인 --%>
            <div class="h_top">
                <nav>
                    <ul class="lnb">
                        <li><a href="#" style="color: #333 !important; font-weight: normal !important; cursor: default !important;">${ sessionScope.loginMember.name } 님</a></li>
                        <li><a href="logout.do">로그아웃</a></li>
                        <li><a href="ulist.do?page=1">관리자페이지</a></li>
                    </ul><!-- lnb end -->
                </nav>
            </div><!-- h_top end -->
        </c:if>

        <div class="h_bt">
            <div class="logo">
                <a href="main.do">
                    <img class="logo_img" src="/tiggle/resources/images/tiggle_logo.png" alt="logo">
                    <span>TIGGLE</span>
                </a>
            </div><!-- logo end -->

            <div class="search_box">
                <form action="esearchTitle.do" method="get" name="action">
                    <input type="search" name="keyword" placeholder="검색">
                    <div class="search_btn">
                        <img src="/tiggle/resources/images/search_icon_bk.png" alt="search_btn">
                    </div><!-- search_btn end -->
                </form>
            </div><!-- search_box end -->

            <nav>
                <ul class="gnb">
                    <li><a href="exhibitionMain.do">전시회</a></li>
                    <li><a href="nearbyMap.do">내 주변?</a></li>
                    <li><a href="nlist.do?page=1">공지사항</a></li>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ORGANIZER' }">
                    	<li><a href="orgRegistPage.do">전시등록</a></li>
                    </c:if>
                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ADMIN' }">
                    	<li><a href="orgRegistAd.do">전시등록</a></li>
                    </c:if>
                    <c:if test="${ empty sessionScope.loginMember or (!empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'USER') }">
                    	<li><a href="loginPage.do">전시등록</a></li>
                    </c:if>
                </ul><!-- gnb end -->
            </nav>

            <div class="m_btn">
                <img src="/tiggle/resources/images/menu_icon_bk.png" alt="menu_icon">
            </div><!-- m_btn end -->
        </div><!-- h_bt end -->

        <div class="m_menu">
            <c:if test="${ empty sessionScope.loginMember }"><%-- 로그인 안함 --%>
                <div class="m_top">
                    <ul class="m_lnb">
                        <li><a href="TOSPage.do">회원가입</a></li>
                        <li><a href="loginPage.do">로그인</a></li>
                        <li class="close_btn"><span>&#10005;</span></li>
                    </ul><!-- m_lnb end -->
                </div><!-- m_top end -->
                
                <div class="m_bt">
	                <ul class="m_gnb">
	                    <li><a href="exhibitionMain.do"><span>&middot;</span>전시회</a></li>
	                    <li><a href="nearbyMap.do"><span>&middot;</span>내 주변?</a></li>
	                    <li><a href="nlist.do?page=1"><span>&middot;</span>공지사항</a></li>
	                    <li><a href="loginPage.do"><span>&middot;</span>전시등록</a></li>
	                    <li><a href="noneMemCBoard.do"><span>&middot;</span>고객센터</a></li>
	                    <li><a href="loginPage.do"><span>&middot;</span>마이페이지</a></li>
	                </ul><!-- m_gnb end -->
	            </div><!-- m_bt end -->
            </c:if>
            <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType ne 'ADMIN' }"><%-- 로그인 함 --%>
                <div class="m_top">
                    <ul class="m_lnb">
                    	<c:if test="${ !empty sessionScope.loginMember.name  }">
                        	<li><a href="#" style="color: #333 !important; font-weight: normal !important; cursor: default !important;">${ sessionScope.loginMember.name } 님</a></li>
                       	</c:if>
                    	<c:if test="${ empty sessionScope.loginMember.name  }">
                        	<li><a href="#" style="color: #333 !important; font-weight: normal !important; cursor: default !important;">${ sessionScope.loginMember.id } 님</a></li>
                       	</c:if>
                        <li><a href="logout.do">로그아웃</a></li>
                        <li class="close_btn"><span>&#10005;</span></li>
                    </ul><!-- m_lnb end -->
                </div><!-- m_top end -->

	            <div class="m_bt">
	                <ul class="m_gnb">
	                    <li><a href="exhibitionMain.do"><span>&middot;</span>전시회</a></li>
	                    <li><a href="nearbyMap.do"><span>&middot;</span>내 주변?</a></li>
	                    <li><a href="nlist.do?page=1"><span>&middot;</span>공지사항</a></li>
	                    <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ORGANIZER' }">
	                    	<li><a href="orgRegistPage.do"><span>&middot;</span>전시등록</a></li>
	                    </c:if>
	                    <c:if test="${ sessionScope.loginMember.memberType ne 'ORGANIZER' }">
	                    	<li><a href="loginPage.do"><span>&middot;</span>전시등록</a></li>
	                    </c:if>
	                    	<li><a href="userCustBoard.do"><span>&middot;</span>고객센터</a></li>
	                    <li><a href="myInfo.do?uuid=${ sessionScope.loginMember.uuid }"><span>&middot;</span>마이페이지</a></li>
	                </ul><!-- m_gnb end -->
	            </div><!-- m_bt end -->
            </c:if>
            <c:if test="${ !empty sessionScope.loginMember and sessionScope.loginMember.memberType eq 'ADMIN' }"><%-- 관리자 로그인 --%>
                <div class="m_top">
                    <ul class="m_lnb">
                        <li><a href="#" style="color: #333 !important; font-weight: normal !important; cursor: default !important;">${ sessionScope.loginMember.name } 님</a></li>
                        <li><a href="logout.do">로그아웃</a></li>
                        <li class="close_btn"><span>&#10005;</span></li>
                    </ul><!-- m_lnb end -->
                </div><!-- m_top end -->

	            <div class="m_bt">
	                <ul class="m_gnb">
	                    <li><a href="exhibitionMain.do"><span>&middot;</span>전시회</a></li>
	                    <li><a href="nearbyMap.do"><span>&middot;</span>내 주변?</a></li>
	                    <li><a href="nlist.do?page=1"><span>&middot;</span>공지사항</a></li>
	                    <li><a href="orgRegistAd.do"><span>&middot;</span>전시등록</a></li>
	                    <li><a href="adminCustBoard.do"><span>&middot;</span>고객센터</a></li>
	                    <li><a href="ulist.do?page=1"><span>&middot;</span>관리자페이지</a></li>
	                </ul><!-- m_gnb end -->
	            </div><!-- m_bt end -->
            </c:if>
        </div><!-- m_menu end -->
        
        <div class="m_search">
            <form action="" method="get">
                <input type="search" placeholder="검색">
                <div class="m_search_btn">
                    <img src="/tiggle/resources/images/search_icon_bk.png" alt="m_search_btn">
                </div><!-- m_search_btn end -->
            </form>
        </div><!-- m_search end -->
    </header>

    <script src="/tiggle/resources/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
	 	//m_menu slide
	    $(function(){
	        $('.m_btn').on('click', function(){
	            $('.m_menu').animate({right: 0}, 300);
	        });
	
	        $('.close_btn').on('click', function(){
	            $('.m_menu').animate({right : '-300px'}, 300);
	        });
	
	    });//m_menu slide end
    </script>
</body>
</html>