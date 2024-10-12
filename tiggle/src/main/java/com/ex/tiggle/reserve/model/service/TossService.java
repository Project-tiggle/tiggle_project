package com.ex.tiggle.reserve.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ex.tiggle.member.controller.MemberController;

@Service
public class TossService {
	 private final RestTemplate restTemplate = new RestTemplate();
	private static final Logger logger = LoggerFactory.getLogger(TossService.class);
	   
	@Value("${toss.api.key}")
	    private String apiKey;
	  
	    
		
	    public String confirmPayment(String paymentKey, String orderId, int amount) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", apiKey);  // 환경 변수에서 API 키 가져오기
	        logger.info(apiKey);
	        headers.set("Content-Type", "application/json");

	        String requestBody = String.format("{\"paymentKey\":\"%s\",\"orderId\":\"%s\",\"amount\":%d}", paymentKey, orderId, amount);
	        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

	        ResponseEntity<String> response = restTemplate.exchange(
	                "https://api.tosspayments.com/v1/payments/confirm",
	                HttpMethod.POST,
	                requestEntity,
	                String.class
	        );
	        return response.getBody();
	    }
	
	
	
}
