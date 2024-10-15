<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>전시회 등록 신청서 승인여부</title>
<link rel="stylesheet" href="/tiggle/resources/css/main_style.css">
<link href="/tiggle/resources/css/orgRegist_style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <c:import url="/WEB-INF/views/common/header.jsp" />

    <div id="container">
        <form id="exreg" action="apStatusYn.do" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="ofile" value="${ requestScope.ofile }">
        	<input type="hidden" name="sfile" value="${ requestScope.sfile }">
        	<input type="hidden" name="totalId" value="${ requestScope.totalId }">
            <h2 id="title">전시 / 박람회 승인 대기</h2>
            
            <!-- 분야 -->
            <label for="field">*분 야:</label>
            <select id="field" name="eCategory" disabled>
                <option value="1" <c:if test="${orgRegist.eCategory == 1}">selected</c:if>>전시회</option>
                <option value="2" <c:if test="${orgRegist.eCategory == 2}">selected</c:if>>박람회</option>
            </select>

            <!-- 전시/박람회명 -->
            <label for="exhibitionName">*전시/박람회명:</label>
            <input type="text" id="exhibitionName" name="title" value="${ orgRegist.title }" readonly>
            
            <!-- 행사 일정 -->
            <label for="eventStartDate">*행사 일정 (시작):</label>
            <input type="date" id="eventStartDate" name="startDate" value="${orgRegist.startDate}" disabled>

            <label for="eventEndDate">*행사 일정 (종료):</label>
            <input type="date" id="eventEndDate" name="endDate" value="${orgRegist.endDate}" disabled>
            
            <!-- 가격 -->
            <label for="charge">가 격:</label>
            <input type="text" id="charge" name=charge value="${orgRegist.charge}" readonly>
            
			<!-- 개최 장소 -->
            <label for="venue">*개최 장소:</label>
            <select id="venue" name="eventSite" disabled>
                <option value="exco" <c:if test="${orgRegist.eventSite == 'exco'}">selected</c:if>>대구엑스코(EXCO)</option>
                <option value="bexco" <c:if test="${orgRegist.eventSite == 'bexco'}">selected</c:if>>벡스코(BEXCO)</option>
                <option value="setec" <c:if test="${orgRegist.eventSite == 'setec'}">selected</c:if>>세텍(SETEC)</option>
                <option value="songdo" <c:if test="${orgRegist.eventSite == 'songdo'}">selected</c:if>>송도컨벤시아(Songdo Convensia)</option>
                <option value="messe" <c:if test="${orgRegist.eventSite == 'messe'}">selected</c:if>>수원메쎄(SUWON MESSE)</option>
                <option value="sac" <c:if test="${orgRegist.eventSite == 'sac'}">selected</c:if>>예술의전당(Seoul Art Center)</option>
                <option value="coex" <c:if test="${orgRegist.eventSite == 'coex'}">selected</c:if>>코엑스(COEX)</option>
                <option value="kintex" <c:if test="${orgRegist.eventSite == 'kintex'}">selected</c:if>>킨텍스(KINTEX)</option>
                <option value="etc" <c:if test="${orgRegist.eventSite != 'exco' 
                                && orgRegist.eventSite != 'bexco' 
                                && orgRegist.eventSite != 'setec' 
                                && orgRegist.eventSite != 'songdo' 
                                && orgRegist.eventSite != 'messe' 
                                && orgRegist.eventSite != 'sac'
                                && orgRegist.eventSite != 'coex' 
                                && orgRegist.eventSite != 'kintex' 
                                && orgRegist.eventSite != ''}">selected</c:if>>기타</option>
            </select>

            <!-- 개최지 상세 주소 -->
            <label for="venueAddress">*개최지 상세 주소:</label>
            <input type="text" id="venueAddress" name="detailEventSite" value="${orgRegist.detailEventSite}" readonly>

            <!-- 참가 기업명 -->
            <label for="companyName">*참가 기업명:</label>
            <input type="text" id="companyName" name="orgName" value="${orgRegist.orgName}" readonly>
            
            <!-- 참가 기업 연락처 -->
            <label for="contactPoint">*참가 기업 연락처:</label>
            <input type="tel" id="contactPoint" name="orgTel" value="${ orgRegist.orgTel }" readonly>

            <!-- 홈페이지 -->
            <label for="website">홈페이지:</label>
            <input type="url" id="website" name="eUrl" value="${orgRegist.eUrl}" readonly>

            <!-- 전시/박람회 상세내용 -->
            <label for="eDescription">*전시 소개:</label>
            <textarea id="eDescription" name="eDescription" rows="15" style="width: 100%" required>${ orgRegist.eDescription }</textarea>

            <!-- 이미지 등록 -->
            <div id="outer">
                <div id="ptPhoto">
                    <img src="/tiggle/resources/exhibit_upfiles/${orgRegist.fileUrl}" id="photo" alt="포스터 이미지를 올려주세요">
                </div>
                <br>
                <div class="file-actions">
                	${ requestScope.ofile } <br>
                </div>
            </div>

            <!-- 신청자 정보 -->
            <h3 id="applicantInfoTitle">신청자 정보</h3>
            <label for="applicantName">*이름:</label>
            <input type="text" id="applicantName" name="name" value="${orgRegist.name}" readonly>

            <label for="department">부서:</label>
            <input type="text" id="department" name="mngDept" value="${orgRegist.mngDept}" readonly>

            <label for="position">직책:</label>
            <input type="text" id="position" name="mngJobId" value="${orgRegist.mngJobId}" readonly>

            <label for="phoneNumber">*연락처:</label>
            <input type="text" id="phoneNumber" name="phone" value="${orgRegist.phone}" readonly>

            <label for="email">*이메일:</label>
            <input type="email" id="email" name="email" value="${orgRegist.email}" readonly>

            
            <input type="submit" id="submitBtn" value="등록승인">
			<input type="button" id="goback" onclick="javascript:history.go(-1)" value="등록거절/뒤로돌아가기">
			<input type="submit" id="resetBtn" formaction="deleteOrgRegist.do" value="등록삭제하기">
        </form>
    </div>

    <c:import url="/WEB-INF/views/common/footer.jsp" />
    <script src="/tiggle/resources/js/orgRegist_script.js"></script>
</body>
</html>
