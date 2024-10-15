// Get chatbot elements
const chatbot = document.getElementById('chatbot');
const conversation = document.getElementById('conversation');
const inputForm = document.getElementById('input-form');
const inputField = document.getElementById('input-field');

// Add event listener to input form
inputForm.addEventListener('submit', function(event) {
  // Prevent form submission
  event.preventDefault();

  // Get user input
  const input = inputField.value;

  // Clear input field
  inputField.value = '';
  const currentTime = new Date().toLocaleTimeString([], { hour: '2-digit', minute: "2-digit" });

  // Add user input to conversation
  let message = document.createElement('div');
  message.classList.add('chatbot-message', 'user-message');
  message.innerHTML = `<p class="chatbot-text" sentTime="${currentTime}">${input}</p>`;
  conversation.appendChild(message);

  // Generate chatbot response
  const response = generateResponse(input);

  // Add chatbot response to conversation
  message = document.createElement('div');
  message.classList.add('chatbot-message','chatbot');
  message.innerHTML = `<p class="chatbot-text" sentTime="${currentTime}">${response}</p>`;
  conversation.appendChild(message);
  message.scrollIntoView({behavior: "smooth"});
});

// Generate chatbot response function
function generateResponse(input) {
    // Add chatbot logic here
    let response = "";
    const icon = document.createElement("i");
    const ankor = document.createElement("a");

    // Check for specific conditions
    if (input.includes("안녕")) {
        response = "안녕하세요! 반가워요 <i class='fa-regular fa-face-smile'></i>";
    } else if (input.includes("고마워")) {
        response = "제가 더 고마워요!<br>더 검색하고 싶은 것이 있나요?";
    } else if (input.includes("바보")) {
        response = "미안해요 <i class='fa-regular fa-face-sad-cry'></i><br>다시 한번 검색해주시겠어요?";
    } else if (input.includes("메인")) {
        response = "메인페이지로 이동하려면 아래 링크를 클릭하세요.<br><a href='main.do'>클릭 &gt; '메인페이지'로 이동하기</a>";
    } else if(input.includes("홈페이지")) {
        response = "홈페이지로 이동하려면 아래 링크를 클릭하세요.<br><a href='main.do'>클릭 &gt; '홈페이지'로 이동하기</a>";
    } else if (input.includes("전시목록")) {
        response = "전시목록으로 이동하려면 아래 링크를 클릭하세요.<br><a href='exhibitionMain.do'>클릭 &gt; '전시목록'으로 이동하기</a>";
    } else if (input.includes("전시")) {
        response = "전시목록으로 이동하려면 아래 링크를 클릭하세요.<br><a href='exhibitionMain.do'>클릭 &gt; '전시목록'으로 이동하기</a>";
    } else if (input.includes("주변")) {
        response = "내 주변 전시를 보려면 아래 링크를 클릭하세요.<br><a href='nearbyMap.do'>클릭 &gt; '내 주변?' 페이지로 이동하기</a>";
    } else if (input.includes("공지사항")) {
        response = "공지사항으로 이동하려면 아래 링크를 클릭하세요.<br><a href='nlist.do?page=1'>클릭 &gt; '공지사항' 으로 이동하기</a>";
    } else if (input.includes("전시등록")) {
        response = "전시등록으로 이동하려면 전시관계자로<br>로그인 후 메인메뉴를 클릭하세요.<br><a href='loginPage.do'>클릭 &gt; '로그인' 페이지로 이동하기</a>";
    } else if (input.includes("고객센터")) {
        response = "고객센터로 이동하려면<br>로그인 후 메인메뉴를 클릭하세요.<br><a href='userCustBoard.do'>클릭 &gt; '로그인' 페이지로 이동하기</a>";
    } else if (input.includes("마이페이지")) {
        response = "마이페이지로 이동하려면<br>로그인 후 메인메뉴를 클릭하세요.<br><a href='loginPage.do'>클릭 &gt; '로그인' 페이지로 이동하기</a>";
    } else if (input.includes("마이")) { 
        response = "마이페이지로 이동하려면<br>로그인 후 메인메뉴를 클릭하세요.<br><a href='loginPage.do'>클릭 &gt; '로그인' 페이지로 이동하기</a>";
    } else if (input.includes("정보수정")) {
        response = "마이페이지로 이동하려면<br>로그인 후 메인메뉴를 클릭하세요.<br><a href='loginPage.do'>클릭 &gt; '로그인' 페이지로 이동하기</a>";
    } else if (input.includes("회원가입")) {
        response = "회원가입 페이지로 이동하려면<br> 아래 링크를 클릭하세요.<br><a href='TOSPage.do'>클릭 &gt; '회원가입' 페이지로 이동하기</a>";
    } else {
        // Default response
        const responses = [
            "정확한 질문을 입력해주세요"
        ];
        response = responses[Math.floor(Math.random() * responses.length)];
    }
    return response;
}