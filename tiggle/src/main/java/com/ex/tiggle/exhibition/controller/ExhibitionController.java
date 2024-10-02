package com.ex.tiggle.exhibition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ex.tiggle.exhibition.model.service.ExhibitionService;

@Controller
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;
}
