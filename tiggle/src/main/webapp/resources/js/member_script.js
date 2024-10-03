//TOSPage#ids.jsp
const form = document.querySelector('#tos_form');
const checkAll = document.querySelector('.tos_check_all input');
const checkBoxes = document.querySelectorAll('.tos_box input');
const submitAgreeButton = document.querySelector('.agree_btn');

const agreements = {
    tos1: false,
    tos2: false,
    marketingYN: false,
}

form.addEventListener('submit', (e) => e.preventDefault()); // 새로고침(submit) 되는 것 막음

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
  if (tos1 && tos2 && marketingYN) {
    checkAll.checked = true;
  } else {
    checkAll.checked = false;
  }
}

function toggleSubmitButton() {
  const { tos1, tos2 } = agreements;
  if (tos1 && tos2) {
    submitAgreeButton.disabled = false;
  } else {
    submitAgreeButton.disabled = true;
  }
}

checkAll.addEventListener('click', (e) => {
  const { checked } = e.target;
  if (checked) {
    checkBoxes.forEach((item) => {
      item.checked = true;
      agreements[item.id] = true;
      item.parentNode.classList.add('active');
    });
  } else {
    checkBoxes.forEach((item) => {
      item.checked = false;
      agreements[item.id] = false;
      item.parentNode.classList.remove('active');
    });
  }
  toggleSubmitButton();
});


//전시관계자 동의클릭시 전시관계자 회원가입 페이지로 이동
document.getElementById('agreeBtn').addEventListener('click', function() {
  const checkbox = document.getElementById('org_enroll');
  
  if (checkbox.checked) {
      // 체크박스가 체크된 경우
      location.href = 'orgEnrollPage.do';
  } else {
      // 체크박스가 체크되지 않은 경우
      location.href = 'enrollPage.do';
  }
});


//TOSPage.jsp end



//enrollPage.jsp, orgEnrollPage.jsp
//e_success_btn -> required 속성의 input 모두 입력시 버튼 활성화하기
function validate() {
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