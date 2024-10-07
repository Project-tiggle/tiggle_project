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


//회원가입 이메일 인증번호 보냄
var certifyCode='';
function mailSend() {
  var enrollEmail = $('#enroll_email').val();

  // 이메일 입력 여부 확인
  if (enrollEmail === '') {
    alert('이메일을 입력해 주세요.');
    $('#enroll_email').focus();
    return false;
  }

  // 인증번호 필드 초기화
  $('#mail_check_input').attr('disabled', false).val(''); // 필드 활성화 및 값 초기화

  $.ajax({
    url: 'mailCheck.do',
    type: 'post',
    data: { email: enrollEmail },
    cache: false,
    success: function(data){
      if(data == 'error') {
        alert('이메일 주소가 올바르지 않습니다.\n유효한 이메일 주소를 입력해주세요.');
        $('#enroll_email').attr('autofocus', true);
      }else{
        alert('인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호 확인을 해주십시오.');
        certifyCode = data;
      }
    },//success end
    error: function() {
      alert('인증메일 발송 중 오류가 발생했습니다. 다시 시도해 주세요.');
    },
  });//ajax end

  return false; // 폼이 전송되지 않도록 막음
};//mailSend() end

function mailValidate() {
  if ($('#mail_check_input').val() == '') {
    alert('인증번호를 입력해 주세요.');
    $('#mail_check_input').focus();
    return false;
  }

   if($('#mail_check_input').val() == certifyCode) {
      alert('인증번호가 일치합니다.');
      $('#email_double_check').val('true');
      $('#mail_check_input').attr('disabled', true);
    }else {
      alert('인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.');
      $('#email_double_check').val('false');
      $('#mail_check_input').attr('autofocus', true);
    }
  
  return false;
};//mailValidate() end


//enrollPage.jsp, orgEnrollPage.jsp end



//myInfoPage.jsp
function validatePwd2() {
  //전송보내기 전에 입력값을 유효한 값인지 확인하는 하는 작업
  
  //암호와 암호확인이 일치하지 않는지 확인
  var pwdValue = document.getElementById('myinfo_pwd').value;
  var pwdValue2 = document.getElementById('myinfo_pwd2').value;
  
  if(pwdValue !== pwdValue2) {
    alert('암호와 암호확인이 일치하지 않습니다. 다시 입력하세요.');
    document.getElementById('myinfo_pwd').value = ''; //기록된 값 지우기
    document.getElementById('myinfo_pwd2').value = ''; //기록된 값 지우기
    document.getElementById('myinfo_pwd').focus(); //입력커서 지정함
    
    return false; //전송 취소함
  }

  return true; //전송보냄
}//validate() end
//myInfoPage.jsp end



//deleteMemberPage.jsp
//체크박스 중 하나만 선택되도록 제어하는 함수
function oneDelCheck(checkbox) {
  const checkboxes = document.getElementsByName('delReason'); //id 속성이 같은 체크박스들을 가져옴
  checkboxes.forEach((item) => {
      item.checked = false;
  });
  checkbox.checked = true;
}//oneDelCheck() end
//deleteMemberPage.jsp end