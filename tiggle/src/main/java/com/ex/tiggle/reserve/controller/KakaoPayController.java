package com.ex.tiggle.reserve.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.tiggle.reserve.model.service.KakaoPayService;



@Controller

public class KakaoPayController {
	private static final Logger logger = LoggerFactory.getLogger(KakaoPayController.class);
   @Autowired
    private KakaoPayService kakaoPay;

    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {

    }

    @PostMapping("/kakaoPay")
    public String kakaoPay(){
        logger.info("kakaoPay post.....................");

        return "redirect:" + kakaoPay.kakaoPayReady();
    }

    @GetMapping("/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token")String pg_token, Model model) {
        logger.info("kakaoPay Success get................");
        logger.info("kakaoPaySuccess pg_token : " + pg_token);
    }
}