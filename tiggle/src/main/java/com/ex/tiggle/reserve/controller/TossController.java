package com.ex.tiggle.reserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.tiggle.reserve.model.service.TossService;

@Controller
@RequestMapping("/api/payment")
public class TossController {

    private final TossService tossPaymentsService;

    @Autowired
    public TossController(TossService tossPaymentsService) {
        this.tossPaymentsService = tossPaymentsService;
    }

    // 결제 확인 요청을 처리하는 메서드
    @PostMapping("/confirm")
    @ResponseBody  // JSON 응답을 보내기 위해 사용
    public String confirmPayment(
            @RequestParam String paymentKey,
            @RequestParam String orderId,
            @RequestParam int amount) {

        try {
            // 결제 확인 API 호출
            String paymentResult = tossPaymentsService.confirmPayment(paymentKey, orderId, amount);

            // 결제 성공 시 JSON 데이터 반환
            return paymentResult;
        } catch (Exception e) {
            // 에러 발생 시 JSON 형식의 오류 메시지 반환
            return "{\"error\":\"결제 처리 중 오류 발생: " + e.getMessage() + "\"}";
        }
    }
}
