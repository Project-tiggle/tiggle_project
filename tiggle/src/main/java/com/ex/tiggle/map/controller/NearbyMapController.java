package com.ex.tiggle.map.controller;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.tiggle.common.KakaoXY;
import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.map.model.dto.NearbyMap;
import com.ex.tiggle.map.model.service.NearbyMapService;

@Controller
public class NearbyMapController {
	
	@Autowired
	private NearbyMapService nearbyMapService;
	
	@RequestMapping("nearbyMap.do")
	public String moveNearbyMap(
			Model model,
			@RequestParam(name="keyword", required = false) String keyword) {
				
		int totalCount = nearbyMapService.selectTotalCount();
		ArrayList<NearbyMap> exhibitList = nearbyMapService.selectLocList();
		String ak = new NearbyMap().getAppKeyUrl();	//dto에서 appkey 전체 url 받아옴
		
		// 검색 값이 있을때만 작동-------------------------------------------------------------------
		if (keyword != null && keyword.length() > 0) {
			try {
	            // 상세 주소를 기반으로 좌표 데이터를 얻어오기
	            KakaoXY kakaoXy = new KakaoXY();
	            String response = kakaoXy.getCoordinateFromAddress(keyword);
	            
	            JSONObject jsonResponse = new JSONObject(response);
	            if (jsonResponse.getJSONArray("documents").length() > 0) {
	                JSONObject addressInfo = jsonResponse.getJSONArray("documents").getJSONObject(0);
	                String xCoord = addressInfo.getJSONObject("address").getString("x");
	                String yCoord = addressInfo.getJSONObject("address").getString("y");
	
	                model.addAttribute("searchLon", xCoord);
	                model.addAttribute("searchLat", yCoord);
	                model.addAttribute("keyword", keyword);
	            }
	
	        } catch (Exception e) {
	        	model.addAttribute("message", "주소를 정확히 입력해주세요");
	        	return "common/error";
	        }
		} // 검색 값이 있을때만 작동------------------------------------------------------------------
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("exList", exhibitList);
		model.addAttribute("link", ak);
		return "nearbymap/nearbyMap";
	}
	
	@RequestMapping("directions.do")
	public String moveDirectionsTab(
			NearbyMap nearbyMap,
			@RequestParam(name = "totalId", required = false) String totalId,
			Model model) {
		String ak = new NearbyMap().getAppKeyUrl();	//dto에서 appkey 전체 url 받아옴
		totalId="100";
		nearbyMap = nearbyMapService.selectDirections(totalId);
		
		double searchLat = nearbyMap.getLatitude();
		double searchLon = nearbyMap.getLongitude();
		
		model.addAttribute("searchLat", searchLat);
		model.addAttribute("searchLon", searchLon);
		model.addAttribute("link", ak);
		return "nearbymap/directions";
	}
}
