//TOSPage.jsp
document.addEventListener('DOMContentLoaded', function () {
  const form = document.querySelector('#tos_form');
  const checkAll = document.querySelector('.tos_check_all input');
  const checkBoxes = document.querySelectorAll('.tos_box input');
  const submitAgreeButton = document.querySelector('.agree_btn');

  const agreements = {
      tos1: false,
      tos2: false,
      marketingYN: false,
  }

  // form.addEventListener('submit', (e) => e.preventDefault()); // 새로고침(submit) 되는 것 막음

  checkBoxes.forEach((item) => item.addEventListener('input', toggleCheckbox));

  function toggleCheckbox(e) {
      const { checked, id } = e.target;
      agreements[id] = checked;
      this.parentNode.classList.toggle('active');
      checkAllStatus();
      toggleSubmitButton();
  }

  function checkAllStatus() {
      const { tos1, tos2, marketingYN } = agreements;
      checkAll.checked = tos1 && tos2; // Check all status update
  }

  function toggleSubmitButton() {
      const { tos1, tos2 } = agreements;
      submitAgreeButton.disabled = !(tos1 && tos2); // Enable/disable submit button
  }

  checkAll.addEventListener('click', (e) => {
      const { checked } = e.target;
      checkBoxes.forEach((item) => {
          item.checked = checked;
          agreements[item.id] = checked;
          item.parentNode.classList.toggle('active', checked);
      });
      toggleSubmitButton();
  });
});



//전시관계자 동의클릭시 전시관계자 회원가입 페이지로 이동
document.getElementById('agreeBtn').addEventListener('click', function() {
  // 전시관계자 체크박스 선택 여부에 따라 action 설정
  const orgEnrollCheckbox = document.getElementById('org_enroll');
  const tosForm = document.getElementById('tos_form');
  
  tosForm.action = 'enrollPage.do'; // 일반 회원가입 페이지로 이동
  console.log(document.getElementById('marketingYN').checked);
  // 전시관계자 체크박스에 따른 action 설정
  if (orgEnrollCheckbox.checked == true) {
    tosForm.action = 'orgEnrollPage.do'; // 전시관계자 페이지로 이동
  }
  
  // 폼 제출
  tosForm.submit();
});

//TOSPage.jsp end



//enrollPage.jsp, orgEnrollPage.jsp
//e_success_btn -> required 속성의 input 모두 입력시 버튼 활성화하기?

//아이디 중복 체크(ajax)
function dupIdCheck() {
  $.ajax({
    url: 'idchk.do',
    type: 'post',
    data: {id: $('#enroll_id').val() },
    success: function(data){
      console.log('success : ' + data);
      if(data == 'ok') {
        alert('사용 가능한 아이디입니다.');	
        $('#enroll_pwd').focus();
      }else {
        alert('이미 사용중인 아이디입니다.');
        $('#enroll_id').select();
      }
    },
    error: function(request, status, errorData){ //요청이 실패했을 때 실행되는 함수임
      console.log('error code : ' + request.status 
          + '\nMessage : ' + request.responseText
          + '\nError : ' + errorData);
    },

  });
}//dupIdCheck() end


//암호와 암호확인이 일치하지 않는지 확인 
function validatePwd() {
  //전송보내기 전에 입력값을 유효한 값인지 확인하는 하는 작업
  
  //암호와 암호확인이 일치하지 않는지 확인
  var pwdValue = document.getElementById('enroll_pwd').value;
  var pwdValue2 = document.getElementById('enroll_pwd2').value;
  
  if(pwdValue !== pwdValue2) {
    alert('암호와 암호확인이 일치하지 않습니다. 다시 입력하세요.');
    document.getElementById('enroll_pwd').value = ''; //기록된 값 지우기
    document.getElementById('enroll_pwd2').value = ''; //기록된 값 지우기
    document.getElementById('enroll_pwd').focus(); //입력커서 지정함
    
    return false; //전송 취소함
  }

  return true; //전송보냄
}//validate() end


//enrollPage.jsp, orgEnrollPage.jsp end