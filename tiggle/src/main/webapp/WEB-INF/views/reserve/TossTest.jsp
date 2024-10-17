<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- SDK 추가 -->
    <script src="https://js.tosspayments.com/v2/standard"></script>
<title>Insert title here</title>
</head>
<body>

    <script>
      // ------  SDK 초기화 ------
      // @docs https://docs.tosspayments.com/sdk/v2/js#토스페이먼츠-초기화
      const clientKey = "test_ck_BX7zk2yd8yLNpMR6DEQLrx9POLqK";
      const customerKey = "tallKjqbva9sa7ofyyJTo";
      const tossPayments = TossPayments(clientKey);
      // 회원 결제
      // @docs https://docs.tosspayments.com/sdk/v2/js#tosspaymentspayment
      const payment = tossPayments.payment({ customerKey });
      // 비회원 결제
      // const payment = tossPayments.payment({customerKey: TossPayments.ANONYMOUS})

      // ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
      // @docs https://docs.tosspayments.com/sdk/v2/js#paymentrequestpayment
      async function requestPayment() {
        // 결제를 요청하기 전에 orderId, amount를 서버에 저장하세요.
        // 결제 과정에서 악의적으로 결제 금액이 바뀌는 것을 확인하는 용도입니다.
        await payment.requestPayment({
          method: "CARD", // 카드 결제
          amount: {
            currency: "KRW",
            value: 100000000,
          },
          orderId: "nXH5S0LE-er-23TMWl56l", // 고유 주분번호
          orderName: "ㅇㅇ 전시회 입장권",
          successUrl: window.location.origin + "/success.do", // 결제 요청이 성공하면 리다이렉트되는 URL
          failUrl: window.location.origin + "/fail", // 결제 요청이 실패하면 리다이렉트되는 URL
          customerEmail: "customer123@gmail.com",
          customerName: "홍길동",
          customerMobilePhone: "01012341234",
        
          // 카드 결제에 필요한 정보
          card: {
            useEscrow: false,
            flowMode: "DEFAULT", // 통합결제창 여는 옵션
            useCardPoint: false,
            useAppCardOnly: false,
          },
        });
      }
          console.log(window.location.origin); 
    </script>
</body>
</html>