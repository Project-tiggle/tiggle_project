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
    
    //수정 페이지로 이동
    @RequestMapping("orgRegEdit.do")
	public String editOrgRegist(
			HttpSession session,
    		Model model) {
    	
    	Member loginMember = (Member) session.getAttribute("loginMember");
    	OrgRegist orgRegist = orgRegistService.selectOrgRegistByUuid(loginMember.getUuid()); //uuid정보를 이용해서 orgRegist정보를 DB로부터 받아옴
    	
    	String totalId = orgRegist.getTotalId();
    	String originalFilename = null;	// 유저가 파일을 올릴때의 원래 이름
    	String saveFilename = null;	// url에 저장되어있는 이름
    	if (orgRegist.getFileUrl() != null) {
    		saveFilename = orgRegist.getFileUrl();
			originalFilename = orgRegist.getFileUrl().substring(orgRegist.getFileUrl().indexOf('_') + 1);
		}
    	    	
        model.addAttribute("totalId", totalId);
    	model.addAttribute("orgRegist", orgRegist);
        model.addAttribute("ofile", originalFilename);
        model.addAttribute("sfile", saveFilename);
        return "orgregist/orgRegistEdit";
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
    
    // 수정 처리
    @RequestMapping(value="orgRegistUpdate.do", method = RequestMethod.POST)
    public String orgRegistUpdate( OrgRegist orgRegist,
            Model model,
            HttpSession session,
            HttpServletRequest request,
            @RequestParam(name="photofile", required = false) MultipartFile mfile,
            @RequestParam("totalId") String totalId,
            @RequestParam("ofile") String originalFileName,
            @RequestParam("sfile") String saveFileName) {
        
    	//***************  Session안에 loginMember 객체 정보를 orgRegist에 담음
    	Member loginMember = (Member) session.getAttribute("loginMember");
    	
    	orgRegist.setUuid(loginMember.getUuid());
    	orgRegist.setTotalId(totalId);
    	orgRegist.setApprovalStatus("N");	// 등록시 관리자 확인전까지는 기본 설정값 'N' 값을 넣음
    	// ************** orgRegist 셋팅 마무리
    	
    	String detailEventSite = orgRegist.getDetailEventSite();	//API 쉽게 사용하기 위한 변수
    	
    	// 사진 파일첨부, 저장 폴더 경로 지정 -----------------------------------
    	String savePath = request.getSession().getServletContext().getRealPath("resources/images/exhibit_files");
        
    	// 수정된 첨부파일이 있다면
		if (!mfile.isEmpty()) {
			// 전송온 파일 이름 추출함
			String fileName = mfile.getOriginalFilename();

			// 이전 파일명과 새로 첨부된 파일명이 다른지 확인
			if (!fileName.equals(originalFileName)) {

				String renameFileName = (FileNameChange.change(fileName, "yyyyMMddHHmmss")) + "_" + fileName;

				// 저장 폴더에 저장 처리
				if (fileName != null && fileName.length() > 0) {
					try {
						mfile.transferTo(new File(savePath + "\\" + renameFileName)); // 새로운 파일저장
						new File(savePath + "\\" + saveFileName).delete(); // 기존 저장파일 삭제
					} catch (Exception e) {
						model.addAttribute("message", "첨부파일 업로드 실패!");
						return "common/error";
					}
				}

				orgRegist.setFileUrl(renameFileName);
			} // 첨부파일이 있을 때
		} else { // 수정된 첨부파일과 원래 첨부파일명이 같은 경우 (폴더에 저장된 상태임)
			orgRegist.setFileUrl(saveFileName);
		}
        
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

            int result = orgRegistService.updateOrgRegist(orgRegist); // 수정처리 service 2개 작동
            int resultUpdate = orgRegistService.updateMember(orgRegist);
            
            if (result > 0 && resultUpdate > 0) {
                model.addAttribute("message", "수정이 완료되었습니다.");
                return "common/success";
            } else {
                model.addAttribute("message", "수정에 실패했습니다.");
                return "common/error";
            }

        } catch (Exception e) {
            model.addAttribute("message", "등록 중 오류가 발생했습니다.");
            return "common/error";
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
		/* logger.info("orgRegist.do : " + orgRegist); */
    	
    	String savePath = request.getSession().getServletContext().getRealPath("resources/images/exhibit_files");
		/* logger.info("savePath : " + savePath); */
    	
    	// 첨부파일이 있을 때
		if (!mfile.isEmpty()) {
			// 전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			String renameFileName = null;

			// 저장폴더에는 변경된 이름을 저장 처리함
			// 파일 이름바꾸기함 : 년월일시분초.확장자
			if (fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기
				renameFileName = (FileNameChange.change(fileName, "yyyyMMddHHmmss")) + "_" + fileName;
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
            int resultUpdate = orgRegistService.updateMember(orgRegist);
            
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
