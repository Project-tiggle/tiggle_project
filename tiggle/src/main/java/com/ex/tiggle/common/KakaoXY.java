package com.ex.tiggle.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KakaoXY {
	
	private static final String API_KEY = "83c9ede8284039881680b8405433b70e"; // 카카오 REST API 키
	
	// 주소에서 좌표를 가져오는 메서드 (카카오 API 호출)
	public String getCoordinateFromAddress(String address) throws Exception {
		String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json?query="
				+ java.net.URLEncoder.encode(address, "UTF-8");
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

		int responseCode = conn.getResponseCode();
		BufferedReader br;

		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();

		return response.toString();
	}
}
