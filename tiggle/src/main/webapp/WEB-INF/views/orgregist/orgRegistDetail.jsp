<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전시회 신청서</title>
<style>
header, footer {
    width: 100%;
    background-color: #fff;
    box-sizing: border-box;
    padding: 20px;
}

#container {
    width: 100%;
    min-height: calc(100vh - 200px);
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
    box-sizing: border-box;
}

#exreg {
    width: 100%;
    max-width: 600px;
    padding: 20px;
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
    box-sizing: border-box;
}

#title, #applicantInfoTitle {
    text-align: center;
    color: #ff5f2c;
}

#exreg label {
    font-weight: bold;
    color: #333;
    display: block;
    margin-top: 10px;
}

#exreg input, #exreg select {
    width: 100%;
    padding: 10px;
    margin-top: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

#submitBtn, #resetBtn {
    width: 100%;
    padding: 10px;
    margin-top: 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

#submitBtn {
    background-color: #ff5f2c;
    color: white;
}

#submitBtn:hover {
    background-color: #e6551e;
}

#resetBtn {
    background-color: #777;
    color: white;
}

#resetBtn:hover {
    background-color: #555;
}

#ptPhoto {
    margin: 0 auto;
    width: 225px;
    height: 400px;
    padding: 10px;
    border: 1px solid #ccc;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #f5f5f5;
    overflow: hidden;
}

#photo {
    width: 100%;
    height: 100%;
    object-fit: contain;
}

#outer {
    margin: 20px auto;
    text-align: center;
    border: 1px solid #ccc;
    padding: 20px;
    border-radius: 5px;
    background-color: #ffffff;
}

.file-actions {
    display: block;
    margin-top: 10px;
}

#deleteBtn {
    background-color: #f5f5f5;
    color: #333;
    border: 1px solid #ccc;
    padding: 8px 12px;
    cursor: pointer;
    border-radius: 5px;
    font-size: 14px;
    margin-top: 10px;
    display: block;
    width: 100%;
    box-sizing: border-box;
}

#deleteBtn:hover {
    background-color: #e9e9e9;
}
</style>
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

    <!-- 메뉴바 -->
    <header>
        <c:import url="/WEB-INF/views/common/header.jsp" />
    </header>

    <!-- 메인 컨테이너 -->
    <div id="container">
        <form id="exreg" action="orgRegist.do" method="post" enctype="multipart/form-data">
            <h2 id="title">전시 / 박람회 등록신청</h2>
            <!-- 분야 -->
            <label for="field">*분야:</label>
            <select id="field" name="field">
                <option value="exhibition">전시회</option>
                <option value="fair">박람회</option>
            </select>

            <!-- 전시/박람회명 -->
            <label for="exhibitionName">*전시/박람회명:</label>
            <input type="text" id="exhibitionName" name="exhibitionName" required>

            <!-- 행사 일정 -->
            <label for="eventStartDate">*행사 일정 (시작):</label>
            <input type="date" id="eventStartDate" name="eventStartDate" required>

            <label for="eventEndDate">*행사 일정 (종료):</label>
            <input type="date" id="eventEndDate" name="eventEndDate" required>

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

            <!-- 개최지 상세 주소 -->
            <label for="venueAddress">*개최지 상세 주소:</label>
            <input type="text" id="venueAddress" name="venueAddress" required>

            <!-- 참가 기업명 -->
            <label for="companyName">*참가 기업명:</label>
            <input type="text" id="companyName" name="companyName" required>

            <!-- 홈페이지 -->
            <label for="website">홈페이지:</label>
            <input type="url" id="website" name="website">

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
            <input type="text" id="applicantName" name="applicantName" required>

            <label for="department">부서:</label>
            <input type="text" id="department" name="department">

            <label for="position">직책:</label>
            <input type="text" id="position" name="position">

            <label for="phoneNumber">*연락처:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>

            <label for="email">*이메일:</label>
            <input type="email" id="email" name="email" required>

            <!-- 버튼 -->
            <input type="submit" id="submitBtn" value="등록하기">
            <input type="reset" id="resetBtn" value="등록취소">
        </form>
    </div>

    <!-- 푸터 -->
    <footer>
        <c:import url="/WEB-INF/views/common/footer.jsp" />
    </footer>

</body>
</html>
