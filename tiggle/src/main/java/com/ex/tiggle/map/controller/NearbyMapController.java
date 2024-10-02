package com.ex.tiggle.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.tiggle.map.model.service.NearbyMapService;

@Controller
public class NearbyMapController {
	
	@Autowired
	private NearbyMapService nearbyMapService;
	
	@RequestMapping("nearbyMap.do")
	public String moveNearbyMap() {
		return "nearbymap/nearbyMap";
	}
}
