<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>전시회 신청서</title>
<link href="/tiggle/resources/css/orgRegist_style.css" rel="stylesheet"	type="text/css">
</head>
<body>
    <c:import url="/WEB-INF/views/common/header.jsp" />


    <!-- 메인 컨테이너 -->
    <div id="container">
        <form id="exreg" action="orgRegist.do" method="post" enctype="multipart/form-data">
            <h2 id="title">전시 / 박람회 등록신청</h2>
            <!-- 분야 -->
            <label for="field">*분 야:</label>
            <select id="field" name="eCategory">
                <option value="1">전시회</option>
                <option value="2">박람회</option>
            </select>

            <!-- 전시/박람회명 -->
            <label for="exhibitionName">*전시/박람회명:</label>
            <input type="text" id="exhibitionName" name="title" required>
            
            <!-- 장르 -->
            <label for="genre">*장 르:</label>
            <input type="text" id="genre" name=genre required>
            
            <!-- 전시/박람회 상세내용 -->
            <label for="eDescription">*전시 소개:</label>
            <input type="text" id="eDescription" name="eDescription" required>

            <!-- 행사 일정 -->
            <label for="eventStartDate">*행사 일정 (시작):</label>
            <input type="date" id="eventStartDate" name="startDate" required>

            <label for="eventEndDate">*행사 일정 (종료):</label>
            <input type="date" id="eventEndDate" name="endDate" required>

            <!-- 개최 장소 -->
            <label for="venue">*개최 장소:</label>
            <select id="venue" name="eventSite">
                <option value="exco">대구엑스코(EXCO)</option>
                <option value="bexco">벡스코(BEXCO)</option>
                <option value="setec">세텍(SETEC)</option>
                <option value="songdo">송도컨벤시아(Songdo Convensia)</option>
                <option value="messe">수원메쎄(SUWON MESSE)</option>
                <option value="sac">예술의전당(Seoul Art Center)</option>
                <option value="coex" selected>코엑스(COEX)</option>
                <option value="kintex">킨텍스(KINTEX)</option>
                <option value="etc">기타</option>
            </select>

            <!-- 개최지 상세 주소 -->
            <label for="venueAddress">*개최지 상세 주소:</label>
            <input type="text" id="venueAddress" name="detailEventSite" required>

            <!-- 참가 기업명 -->
            <label for="companyName">*참가 기업명:</label>
            <input type="text" id="companyName" name="contributor" value="${ orgRegist.contributor }" required>
            
            <!-- 참가 기업 연락처 -->
            <label for="contactPoint">*참가 기업 연락처:</label>
            <input type="tel" id="contactPoint" name="contactPoint" value="${ orgRegist.contactPoint }" required>

            <!-- 홈페이지 -->
            <label for="website">*홈페이지:</label>
            <input type="url" id="website" name="eUrl" value="${ orgRegist.eUrl }">

            <!-- 이미지 등록 -->
            <div id="outer">
                <div id="ptPhoto">
                    <img src="" id="photo" alt="포스터 이미지를 올려주세요">
                </div>
                <br>
                <div class="file-actions">
                    <input type="file" id="photofile" name="photofile">
                    <button type="button" id="deleteBtn">삭제</button>
                </div>
            </div>

            <!-- 신청자 정보 -->
            <h3 id="applicantInfoTitle">신청자 정보</h3>
            <label for="applicantName">*이름:</label>
            <input type="text" id="applicantName" name="name" value="${ orgRegist.name }" required>

            <label for="department">부서:</label>
            <input type="text" id="department" name="mngDept" value="${ orgRegist.mngDept }">

            <label for="position">직책:</label>
            <input type="text" id="position" name="mngJobId" value="${ orgRegist.mngJobId }">

            <label for="phoneNumber">*연락처:</label>
            <input type="text" id="phoneNumber" name="phone" value="${ orgRegist.phone }" required>

            <label for="email">*이메일:</label>
            <input type="email" id="email" name="email" value="${ orgRegist.email }" required>

            <!-- 버튼 -->
            <input type="submit" id="submitBtn" value="등록하기">
            <input type="reset" id="resetBtn" value="등록취소">
            <input type="button" id="goback" onclick="javascript:history.go(-1)" value="돌아가기">
        </form>
    </div>

        <c:import url="/WEB-INF/views/common/footer.jsp" />
  		<script src="/tiggle/resources/js/orgRegist_script.js"></script>
</body>
</html>
