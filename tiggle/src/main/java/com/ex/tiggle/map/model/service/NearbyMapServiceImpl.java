package com.ex.tiggle.map.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.map.model.dao.NearbyMapDao;
import com.ex.tiggle.map.model.dto.NearbyMap;

@Service("nearbyMapService")
public class NearbyMapServiceImpl implements NearbyMapService {
	
	@Autowired
	private NearbyMapDao nearbyMapDao;

	@Override
	public int selectTotalCount() {
		return nearbyMapDao.selectTotalCount();
	}

	@Override
	public ArrayList<NearbyMap> selectLocList() {
		return nearbyMapDao.selectLocList();
	}

}
