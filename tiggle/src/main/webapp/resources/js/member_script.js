//TOSPage.jsp
const form = document.querySelector('#tos_form');
const checkAll = document.querySelector('.tos_check_all input');
const checkBoxes = document.querySelectorAll('.tos_box input');
const submitButton = document.querySelector('.agree_btn');

const agreements = {
    tos1: false,
    tos2: false,
    tos3: false,
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
    const { tos1, tos2, tos3 } = agreements;
    if (tos1 && tos2 && tos3) {
      checkAll.checked = true;
    } else {
      checkAll.checked = false;
    }
  }
  
  function toggleSubmitButton() {
    const { tos1, tos2 } = agreements;
    if (tos1 && tos2) {
      submitButton.disabled = false;
    } else {
      submitButton.disabled = true;
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
//TOSPage.jsp end