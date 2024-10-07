package com.ex.tiggle.orgregist.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ex.tiggle.common.FileNameChange;
import com.ex.tiggle.common.KakaoXY;
import com.ex.tiggle.member.model.dto.Member;
import com.ex.tiggle.orgregist.model.dto.OrgRegist;
import com.ex.tiggle.orgregist.model.service.OrgRegistService;

@Controller
public class OrgRegistController {
	private static final Logger logger = LoggerFactory.getLogger(OrgRegistController.class);
	
	@Autowired
    private OrgRegistService orgRegistService;
    
    // 전시/박람회 메인 페이지로 이동
    @RequestMapping("orgRegistPage.do")
    public String moveOrgRegist() {
        return "orgregist/orgRegist";
    }

    // 전시/박람회 등록 상세 페이지로 이동
    @RequestMapping("orgRegDetail.do")
    public String moveOrgRegistDetail(
    		HttpSession session,
    		Model model) {
    	Member loginMember = (Member) session.getAttribute("loginMember");
    	
    	OrgRegist orgRegist = orgRegistService.selectOrgRegistByUuid(loginMember.getUuid());
        model.addAttribute("orgRegist", orgRegist);
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
    public String updateOrgRegist(OrgRegist orgRegist, Model model) {
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

    //전시등록
    @RequestMapping(value = "orgRegist.do", method = RequestMethod.POST)
    public String registerOrgRegist(
            OrgRegist orgRegist,
            Model model,
            HttpSession session,
            HttpServletRequest request,
            @RequestParam(name="photofile", required = false) MultipartFile mfile) {
    	
    	
    	//***************  Session안에 loginMember 객체 정보를 orgRegist에 담음
    	Member loginMember = (Member) session.getAttribute("loginMember");
    	
    	orgRegist.setUuid(loginMember.getUuid());
    	orgRegist.setTotalId(String.valueOf(orgRegistService.selectMaxTotalId() + 1));	//가장 큰 번호를 불러와서 +1, varchar2형식으로 변환
    	orgRegist.setApprovalStatus("N");	// 등록시 관리자 확인전까지는 기본 설정값 'N' 값을 넣음
    	// ************** orgRegist 셋팅 마무리
    	
    	String detailEventSite = orgRegist.getDetailEventSite();	//API 쉽게 사용하기 위한 변수
    	logger.info("orgRegist.do : " + orgRegist);
    	
    	String savePath = request.getSession().getServletContext().getRealPath("resources/images/exhibit_files");
    	logger.info("savePath : " + savePath);
    	
    	// 첨부파일이 있을 때
		if (!mfile.isEmpty()) {
			// 전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			String renameFileName = null;

			// 저장폴더에는 변경된 이름을 저장 처리함
			// 파일 이름바꾸기함 : 년월일시분초.확장자
			if (fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기
				renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
				// 바뀐 파일명 확인
				logger.info("첨부파일명 확인 : " + renameFileName);

				try {
					// 저장 폴더에 파일명 바꾸어 저장하기
					mfile.transferTo(new File(savePath + "\\" + renameFileName));
				} catch (Exception e) {
					model.addAttribute("message", "첨부파일 저장 실패!");
					return "common/error";
				}
			} // 파일명 바꾸기

			orgRegist.setFileUrl(renameFileName);
		} // 첨부파일이 있을 때
    	
        try {
            // 상세 주소를 기반으로 좌표 데이터를 얻어오기
            KakaoXY kakaoXy = new KakaoXY();
            String response = kakaoXy.getCoordinateFromAddress(detailEventSite);
            
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.getJSONArray("documents").length() > 0) {
                JSONObject addressInfo = jsonResponse.getJSONArray("documents").getJSONObject(0);
                String xCoord = addressInfo.getJSONObject("address").getString("x");
                String yCoord = addressInfo.getJSONObject("address").getString("y");

                // DTO에 경도와 위도 값 설정
                orgRegist.setLongitude(Double.parseDouble(xCoord));
                orgRegist.setLatitude(Double.parseDouble(yCoord));
                //경도위도 확인 로거
                logger.info("x, y (check) : " + orgRegist);
            }

            // 서비스 호출, 반환된 값에 따라 성공 여부를 판단
            int resultInsert = orgRegistService.insertOrgRegist(orgRegist);
            int resultUpdate = orgRegistService.updateOrgRegist(orgRegist);
            
            if (resultInsert > 0 && resultUpdate > 0) {
                model.addAttribute("message", "전시/박람회가 성공적으로 등록되었습니다.");
                return "common/success";
            } else {
                model.addAttribute("message", "등록 중 오류가 발생했습니다.");
                return "common/error";
            }

        } catch (Exception e) {
            model.addAttribute("message", "등록 중 오류가 발생했습니다.");
            return "common/error";
        }
    }

}
