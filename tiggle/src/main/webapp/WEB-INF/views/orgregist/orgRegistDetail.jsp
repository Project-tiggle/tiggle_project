<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전시회 신청서</title>
<style type="text/css">
#exreg {
	width: 500px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
}

#exreg>input {
	width: 480px;
	padding: 8px;
	margin: 8px 0;
}

#exreg>select {
	width: 100%;
	padding: 8px;
	margin: 8px 0;
}

#exreg>label {
	font-weight: bold;
}
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp" />
	
    <h2>전시 / 박람회 등록신청</h2>
    <form id="exreg" action="orgRegist.do" method="post" enctype="multipart/form-data">
        <!-- 분야 -->
        <label for="field">*분야:</label>
        <select id="field" name="field">
            <option value="exhibition">전시회</option>
            <option value="fair">박람회</option>
        </select>
        <br>
        <!-- 전시/박람회명 -->
        <label for="exhibitFairName">*전시/박람회명:</label>
        <input type="text" id="exhibitionName" name="exhibitionName" required>
        <br>
        <!-- 행사 일정 -->
        <label for="eventStartDate">*행사 일정 (시작):</label>
        <input type="date" id="eventStartDate" name="eventStartDate" required>
        <br>
        <label for="eventEndDate">*행사 일정 (종료):</label>
        <input type="date" id="eventEndDate" name="eventEndDate" required>
        <br>
        <!-- 개최 장소 -->
        <label for="venue">*개최 장소:</label>
        <select id="venue" name="venue">
        	<option value="exco">대구엑스코(EXCO)</option>
        	<option value="bexco">벡스코(BEXCO)</option>
        	<option value="setec">세텍(SETEC)</option>
        	<option value="songdo">송도컨벤시아(Songdo Convensia)</option>
        	<option value="messe">수원메쎄(SUWON MESSE)</option>
        	<option value="coex">코엑스(COEX)</option>
            <option value="kintex">킨텍스(KINTEX)</option>
            <option value="etc">기타</option>
        </select>
        <br>
        <!-- 개최지 상세 주소 -->
        <label for="venueAddress">*개최지 상세 주소:</label>
        <input type="text" id="venueAddress" name="venueAddress" required>
        <br>
        <!-- 참가 기업명 -->
        <label for="companyName">*참가 기업명:</label>
        <input type="text" id="companyName" name="companyName" required>
        <br>
        <!-- 홈페이지 -->
        <label for="website">홈페이지:</label>
        <input type="url" id="website" name="website">
        <br>
        <!-- 이미지 등록 -->
        <label for="imageUpload">*이미지 등록:</label>
        <input type="file" id="imageUpload" name="imageUpload" required>
        <br>
        <!-- 신청자 정보 -->
        <h3>신청자 정보</h3>
        <label for="applicantName">*이름:</label>
        <input type="text" id="applicantName" name="applicantName" required>
        <br>
        <label for="department">부서:</label>
        <input type="text" id="department" name="department">
        <br>
        <label for="position">직책:</label>
        <input type="text" id="position" name="position">
        <br>
        <label for="phoneNumber">*연락처:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required>
        <br>
        <label for="email">*이메일:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <!-- 버튼 -->
        <input type="submit" value="등록하기">
        <input type="reset" value="등록취소">
    </form>
    
    <c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>