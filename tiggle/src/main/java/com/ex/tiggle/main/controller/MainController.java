package com.ex.tiggle.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ex.tiggle.main.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;

} // MainController End2
