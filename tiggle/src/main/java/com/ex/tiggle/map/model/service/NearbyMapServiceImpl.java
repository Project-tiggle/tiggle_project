package com.ex.tiggle.map.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.map.model.dao.NearbyMapDao;

@Service("nearbyMapService")
public class NearbyMapServiceImpl implements NearbyMapService {
	
	@Autowired
	private NearbyMapDao nearbyMapDao;
}// NearbyMapService end
