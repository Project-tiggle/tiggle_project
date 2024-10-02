package com.ex.tiggle.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ex.tiggle.map.model.service.NearbyMapService;

@Controller
public class NearbyMapController {
	
	@Autowired
	private NearbyMapService nearbyMapService;
}
