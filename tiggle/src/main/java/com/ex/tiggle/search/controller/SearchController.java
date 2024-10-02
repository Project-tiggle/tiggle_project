package com.ex.tiggle.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ex.tiggle.search.model.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
}
