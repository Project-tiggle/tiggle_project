package com.ex.tiggle.reserve.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




	@Controller
	public class TossController {
	
	private static final Logger logger = LoggerFactory.getLogger(TossController.class);		
	
	@RequestMapping("/success.do")
	public void paySuccess () throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
		    .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
		    .header("Authorization", "Basic dGVzdF9za18yNkRsYlhBYVYwMTBZNEtkRTBicXJxWTUwUTlSOg==")
		    .header("Content-Type", "application/json")
		    .method("POST", HttpRequest.BodyPublishers.ofString("{\"paymentKey\":\"tviva20241015180007V4ZJ3\",\"amount\":100000000,\"orderId\":\"PcF5hhvpMbd01R7mvp_av\"}"))
		    .build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());	
	logger.info(response.body());
    }
}   

