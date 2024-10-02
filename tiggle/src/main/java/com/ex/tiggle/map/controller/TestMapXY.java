package com.ex.tiggle.map.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject; // JSON 파싱을 위한 라이브러리 (org.json)

public class TestMapXY {

    private static final String API_KEY = "83c9ede8284039881680b8405433b70e"; // 발급받은 카카오 REST API 키

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("위도 경도를 추적할 아무 주소나 입력하세요(도로명만으로도가능) : ");
        String address = sc.nextLine(); // 변환할 주소
        try {
            // 주소를 좌표로 변환
            String response = getCoordinateFromAddress(address);

            // JSON 응답 파싱
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.getJSONArray("documents").length() > 0) {
                JSONObject addressInfo = jsonResponse.getJSONArray("documents").getJSONObject(0);
                String xCoord = addressInfo.getJSONObject("address").getString("x");
                String yCoord = addressInfo.getJSONObject("address").getString("y");

                // 좌표 출력
                System.out.println("X 좌표 (경도): " + xCoord);
                System.out.println("Y 좌표 (위도): " + yCoord);
            } else {
                System.out.println("주소 검색 결과가 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCoordinateFromAddress(String address) throws Exception {
        // 주소 검색을 위한 카카오 API URL 생성
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json?query=" + java.net.URLEncoder.encode(address, "UTF-8");
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

        int responseCode = conn.getResponseCode();
        BufferedReader br;

        if (responseCode == 200) { // 요청 성공
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {  // 요청 실패
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();

        return response.toString(); // JSON 결과 반환
    }
}