package com.ex.tiggle.map.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.tiggle.map.model.dto.NearbyMap;
import com.ex.tiggle.map.model.service.NearbyMapService;

@Controller
public class NearbyMapController {
	
	@Autowired
	private NearbyMapService nearbyMapService;
	
	@RequestMapping("nearbyMap.do")
	public String moveNearbyMap(
			Model model) {
				
		int totalCount = nearbyMapService.selectTotalCount();
		ArrayList<NearbyMap> exhibitList = nearbyMapService.selectLocList();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("exList", exhibitList);
		return "nearbymap/nearbyMap";
	}
}
