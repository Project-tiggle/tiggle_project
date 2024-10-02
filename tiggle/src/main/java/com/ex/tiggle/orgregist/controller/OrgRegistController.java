package com.ex.tiggle.orgregist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.tiggle.orgregist.model.service.OrgRegistService;

@Controller
public class OrgRegistController {

	@Autowired
	private OrgRegistService orgRegistService;
	
	@RequestMapping("orgRegistPage.do")
	public String moveOrgRegist() {
		return "orgregist/orgRegist";
	}
	
	@RequestMapping("orgRegDetail.do")
	public String moveOrgRegistDetail() {
		return "orgregist/orgRegistDetail";
	}
}
