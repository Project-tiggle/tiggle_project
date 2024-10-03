package com.ex.tiggle.orgregist.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.tiggle.orgregist.model.dto.OrgRegist;
import com.ex.tiggle.orgregist.model.service.OrgRegistService;

@Controller
public class OrgRegistController {
	private static final Logger logger = LoggerFactory.getLogger(OrgRegistController.class);
	
	@Autowired
    private OrgRegistService orgRegistService;
    private static final String API_KEY = "83c9ede8284039881680b8405433b70e"; // 카카오 REST API 키

    // 전시/박람회 페이지로 이동
    @RequestMapping("orgRegistPage.do")
    public String moveOrgRegist() {
        return "orgregist/orgRegist";
    }

    // 전시/박람회 등록 상세 페이지로 이동
    @RequestMapping("orgRegDetail.do")
    public String moveOrgRegistDetail() {
        return "orgregist/orgRegistDetail";
    }
    
    // 특정 UUID로 데이터를 조회하여 수정 페이지로 이동
    @RequestMapping("orgRegEdit.do")
	public String editOrgRegist(/* @RequestParam("uuid") String uuid, */ Model model) {
        String uuid = "1b2c3d4e-5f6g-7h8i-9j0k-1l2m3n4o5p6q";
    	// 해당 UUID에 해당하는 전시/박람회 정보를 조회
        OrgRegist orgRegist = orgRegistService.selectOrgRegistByUuid(uuid);
        model.addAttribute("orgRegist", orgRegist);
        return "orgregist/orgRegistEdit"; // 편집 화면으로 이동
    }

    // 수정 처리
    @RequestMapping("updateOrgRegist.do")
    public String updateOrgRegist(@ModelAttribute OrgRegist orgRegist, Model model) {
        int result = orgRegistService.updateOrgRegist(orgRegist); // 수정 처리 서비스 호출

        if (result > 0) {
            // 수정 성공 시 메시지와 함께 페이지 이동 (다시 목록으로 리다이렉트)
            model.addAttribute("message", "수정이 완료되었습니다.");
            return "redirect:/orgRegistPage.do";
        } else {
            // 실패 시 에러 메시지와 함께 오류 페이지로 이동
            model.addAttribute("message", "수정에 실패했습니다.");
            return "error";
        }
    }

    // 삭제 처리
    @RequestMapping("deleteOrgRegist.do")
    public String deleteOrgRegist(@RequestParam("uuid") String uuid, Model model) {
        int result = orgRegistService.deleteOrgRegist(uuid); // 삭제 처리 서비스 호출

        if (result > 0) {
            // 삭제 성공 시 메시지와 함께 페이지 이동 (다시 목록으로 리다이렉트)
            model.addAttribute("message", "삭제가 완료되었습니다.");
            return "redirect:/orgRegistPage.do";
        } else {
            // 실패 시 에러 메시지와 함께 오류 페이지로 이동
            model.addAttribute("message", "삭제에 실패했습니다.");
            return "error";
        }
    }

    // 등록 처리 (POST 요청)
    @PostMapping("registerOrgRegist.do")
    public String registerOrgRegist(
            @ModelAttribute OrgRegist orgRegist, // DTO 자동 매핑
            @RequestParam("detailEventSite") String detailEventSite, // 상세 주소
            Model model) {
    	
    	logger.info("orgRegist : " + orgRegist);
    	logger.info("detailEventSite :" + detailEventSite);
    	
        try {
            // 1. 상세 주소를 기반으로 좌표 데이터를 얻어오기
            String response = getCoordinateFromAddress(detailEventSite);

            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.getJSONArray("documents").length() > 0) {
                JSONObject addressInfo = jsonResponse.getJSONArray("documents").getJSONObject(0);
                String xCoord = addressInfo.getJSONObject("address").getString("x");
                String yCoord = addressInfo.getJSONObject("address").getString("y");

                // 2. DTO에 경도와 위도 값 설정
                orgRegist.setLongitude(Double.parseDouble(xCoord));
                orgRegist.setLatitude(Double.parseDouble(yCoord));
            }

            // 3. 서비스 호출, 반환된 값에 따라 성공 여부를 판단
            int result = orgRegistService.insertOrgRegist(orgRegist);
            
            if (result > 0) {
                // 등록 성공
                model.addAttribute("message", "전시/박람회가 성공적으로 등록되었습니다.");
                return "redirect:/orgRegistPage.do";  // 성공 시 등록 페이지로 리다이렉트
            } else {
                // 등록 실패
                model.addAttribute("message", "등록 중 오류가 발생했습니다.");
                return "orgregist/orgRegistDetail";  // 실패 시 다시 등록 폼으로 이동
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "등록 중 오류가 발생했습니다.");
            return "orgregist/orgRegistDetail";  // 실패 시 다시 등록 폼으로 이동
        }
    }

    // 주소에서 좌표를 가져오는 메서드 (카카오 API 호출)
    public String getCoordinateFromAddress(String address) throws Exception {
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json?query=" + java.net.URLEncoder.encode(address, "UTF-8");
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
