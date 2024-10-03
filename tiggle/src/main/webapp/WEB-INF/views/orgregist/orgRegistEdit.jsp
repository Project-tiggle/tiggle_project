<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전시회 등록 신청서 편집</title>
<link href="/tiggle/resources/css/orgRegist_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    window.onload = function(){
        var photofile = document.getElementById("photofile");
        var myphoto = document.getElementById("photo");
        var deleteBtn = document.getElementById("deleteBtn");

        photofile.addEventListener('change', function(event){
            const files = event.currentTarget.files;
            const file = files[0];

            const reader = new FileReader();  
            reader.onload = (e) => {  
                myphoto.setAttribute('src', e.target.result);
                myphoto.setAttribute('data-file', file.name);
            };
            reader.readAsDataURL(file);  
        });

        // 삭제 버튼 클릭 시 파일 초기화 및 미리보기 삭제
        deleteBtn.addEventListener('click', function() {
            photofile.value = ''; // 파일 선택 필드 초기화
            myphoto.setAttribute('src', ''); // 이미지 미리보기 초기화
            myphoto.removeAttribute('data-file'); // data-file 속성 제거
        });
    };
</script>
</head>
<body>
    <c:import url="/WEB-INF/views/common/header.jsp" />

    <!-- 메인 컨테이너 -->
    <div id="container">
        <!-- 수정 및 삭제 기능을 하나의 폼으로 합치기 -->
        <form id="exreg" action="updateOrgRegist.do" method="post" enctype="multipart/form-data">
            <h2 id="title">전시 / 박람회 수정</h2>
            
            <!-- 분야 -->
            <label for="field">*분야:</label>
            <select id="field" name="field">
                <option value="exhibition" <c:if test="${orgRegist.eCategory == 1}">selected</c:if>>전시회</option>
                <option value="fair" <c:if test="${orgRegist.eCategory == 2}">selected</c:if>>박람회</option>
            </select>

            <!-- 전시/박람회명 -->
            <label for="exhibitionName">*전시/박람회명:</label>
            <input type="text" id="exhibitionName" name="exhibitionName" value="${orgRegist.title}" required>

            <!-- 행사 일정 -->
            <label for="eventStartDate">*행사 일정 (시작):</label>
            <input type="date" id="eventStartDate" name="eventStartDate" value="${orgRegist.startDate}" required>

            <label for="eventEndDate">*행사 일정 (종료):</label>
            <input type="date" id="eventEndDate" name="eventEndDate" value="${orgRegist.endDate}" required>

            <!-- 개최 장소 -->
            <label for="venue">*개최 장소:</label>
            <select id="venue" name="venue">
                <option value="exco" <c:if test="${orgRegist.eventSite == 'exco'}">selected</c:if>>대구엑스코(EXCO)</option>
                <option value="bexco" <c:if test="${orgRegist.eventSite == 'bexco'}">selected</c:if>>벡스코(BEXCO)</option>
                <option value="setec" <c:if test="${orgRegist.eventSite == 'setec'}">selected</c:if>>세텍(SETEC)</option>
                <option value="songdo" <c:if test="${orgRegist.eventSite == 'songdo'}">selected</c:if>>송도컨벤시아(Songdo Convensia)</option>
                <option value="messe" <c:if test="${orgRegist.eventSite == 'messe'}">selected</c:if>>수원메쎄(SUWON MESSE)</option>
                <option value="coex" <c:if test="${orgRegist.eventSite == 'coex'}">selected</c:if>>코엑스(COEX)</option>
                <option value="kintex" <c:if test="${orgRegist.eventSite == 'kintex'}">selected</c:if>>킨텍스(KINTEX)</option>
                <option value="etc" <c:if test="${orgRegist.eventSite != 'exco' 
                                && orgRegist.eventSite != 'bexco' 
                                && orgRegist.eventSite != 'setec' 
                                && orgRegist.eventSite != 'songdo' 
                                && orgRegist.eventSite != 'messe' 
                                && orgRegist.eventSite != 'coex' 
                                && orgRegist.eventSite != 'kintex' 
                                && orgRegist.eventSite != ''}">selected</c:if>>기타</option>
            </select>

            <!-- 개최지 상세 주소 -->
            <label for="venueAddress">*개최지 상세 주소:</label>
            <input type="text" id="venueAddress" name="venueAddress" value="${orgRegist.detailEventSite}" required>

            <!-- 참가 기업명 -->
            <label for="companyName">*참가 기업명:</label>
            <input type="text" id="companyName" name="companyName" value="${orgRegist.contributor}" required>

            <!-- 홈페이지 -->
            <label for="website">홈페이지:</label>
            <input type="url" id="website" name="website" value="${orgRegist.eUrl}">

            <!-- 이미지 등록 -->
            <div id="outer">
                <div id="ptPhoto">
                    <img src="${orgRegist.fileUrl}" id="photo" alt="포스터 이미지를 올려주세요">
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
            <input type="text" id="applicantName" name="applicantName" value="${orgRegist.name}" required>

            <label for="department">부서:</label>
            <input type="text" id="department" name="department" value="${orgRegist.mngDept}">

            <label for="position">직책:</label>
            <input type="text" id="position" name="position" value="${orgRegist.mngJobId}">

            <label for="phoneNumber">*연락처:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${orgRegist.phone}" required>

            <label for="email">*이메일:</label>
            <input type="email" id="email" name="email" value="${orgRegist.email}" required>

            <!-- 수정하기 버튼 -->
            <input type="submit" id="submitBtn" value="수정하기">
            
            <!-- 등록삭제하기 버튼 -->
            <input type="submit" id="resetBtn" formaction="deleteOrgRegist.do" value="등록삭제하기">

        </form>
    </div>

    <c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>
