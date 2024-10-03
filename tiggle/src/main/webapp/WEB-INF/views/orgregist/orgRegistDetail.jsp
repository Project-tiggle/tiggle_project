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
<script type="text/javascript">
	window.onload = function(){
		//input type="file" 이 선택한 사진파일 이미지 미리보기 처리
		var photofile = document.getElementById("photofile");
		photofile.addEventListener('change', function(event){
			const files = event.currentTarget.files;
			const file = files[0];
			console.log(file.name);  //선택한 파일명 확인
			
			//선택한 파일을 img 태그의 src 속성 값으로 적용함 :이미지 변경될 것임
			const myphoto = document.getElementById("photo");
			//myphoto.src = '서버측에 있는 이미지파일의 상대|절대경로/' + file.name; //서버측에 있는 파일일 때 사용하는 방법임
			//클라이언트 컴퓨터에 있는 파일은 src 속성으로 적용할 수 없음
			
			//클라이언트 컴퓨터에 있는 사진파일을 읽어들여서 출력되게 처리해야 함 (파일입력 > 출력처리)
			const reader = new FileReader();  //파일읽기 객체 생성
			//람다(lambda) 스트림 방식 사용
			//이벤트콜백함수 실행구문(기존 방식) : reader.onload = function(e){ 읽어들이기 처리 };
			reader.onload = (e) => {  //e : event 객체
				myphoto.setAttribute('src', e.target.result); //e.target : 이벤트 발생 대상(읽어들인 파일정보)
				myphoto.setAttribute('data-file', file.name);
			};
			reader.readAsDataURL(file);  //읽어서 img 에 적용 출력됨
		});
	};  //window.onload
</script>
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
        <table id="outer" align="center" width="700" cellspacing="5" cellpadding="0">
        <tr><th>사진첨부</th>
		<td>
			<%-- 선택한 사진파일 미리보기용 영역 지정 : 서버로는 전송되지 않음 --%>
			<div id="myphoto" style="margin:0;width:150px;height:160px;padding:0;border:1px solid navy;">
				<%-- 사진 첨부가 없을 경우를 위한 미리보기용 이미지 출력되게 설정함 --%>
				<img src="/tiggle/resources/images/${ requestScope.member.photoFileName }" id="photo" 
				style="width:150px;height:160px;border:1px solid navy;display:block;margin:0;padding:0;" 
				alt="사진을 드래그 드롭하세요.">
			</div> <br>
			<%-- <%  //첨부된 파일명이 원래 파일명으로 표시되게 처리함
				//파일명 앞에 붙은 "userid_" 글자를 제외시킴
				String filename = member.getPhotoFileName().substring(member.getPhotoFileName().indexOf('_') + 1);
			%> --%>
			${ requestScope.ofile } <br>
			변경할 사진 선택 : <input type="file" id="photofile" name="photofile"> 
			<%-- name 속성의 이름은 필드명과 별개로 지정함
				파일업로드 실패시 파일명만 문자열로 command 객체에 저장되지 않게 하기 위함
			 --%>
			</td>
		</tr>
		</table>
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