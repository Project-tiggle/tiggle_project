package com.ex.tiggle.exhibition.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.exhibition.model.service.ExhibitionService;
import com.ex.tiggle.member.controller.MemberController;
import com.ex.tiggle.review.model.dto.Review;
import com.ex.tiggle.review.model.dto.ReviewPaging;
import com.ex.tiggle.review.model.service.ReviewService;

@Controller
public class ExhibitionController {
	private static final Logger logger = LoggerFactory.getLogger(ExhibitionController.class);
	@Autowired
	private ExhibitionService exhibitionService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	
	// 전시 페이지 관련 컨트롤러
	// 전시 페이지로 이동
	@RequestMapping("exhibitionMain.do")
	public ModelAndView exhibitionListMethod(ModelAndView mv, @RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {
		// page : 출력할 페이지, limit : 한 페이지에 출력할 목록 갯수

		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);

		}

		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 25;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		// 총 목록갯수 조회해서 총 페이지 수 계산
		int listCount = exhibitionService.selectListCount();

		// 페이지 관련 항목 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "exhibitionMain.do");
		paging.calculate();

		// 서비스로 목록 조회 요청하고 결과 받기
		ArrayList<Exhibition> list = exhibitionService.selectList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);

			mv.setViewName("exhibition/exhibitionMain");
		} else {
			mv.addObject("message", "목록 조회 실패!");
			mv.setViewName("common/error");
		}

		return mv;
	}
	
	

	// 클릭한 포스터와 같은 전시의 내용을 담은 상세 정보 페이지로 이동
	@RequestMapping(value = "exhibitionDetail.do")
	public ModelAndView exhibitionDetailMethod(@RequestParam("no") String totalId , ModelAndView mv) {
		
		Exhibition exhibition = exhibitionService.selectListOne(totalId);
		// 같은 totalId 를 갖는 한줄평 조회

		int currentPage = 1;
		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		// 총 목록갯수 조회해서 총 페이지 수 계산
		int listCount = reviewService.selectListCount(totalId);
		
		Paging paging = new Paging(listCount, limit, currentPage, "exhibitionList.do");
		paging.calculate();
		
				
		ReviewPaging reviewPaging = new ReviewPaging();
		reviewPaging.setTotalId(totalId);
		reviewPaging.setStartRow(paging.getStartRow());
		reviewPaging.setEndRow(paging.getEndRow());
		// logger.info("a" + reviewPaging);
		
		ArrayList<Review> list = reviewService.selectList(reviewPaging);
		
		if (exhibition != null) {
			mv.addObject("exhibition", exhibition);
			mv.addObject("list", list);
			mv.setViewName("exhibition/exhibitionDetail");
			}
		
		
		return mv;
	}
	
	// 클릭한 포스터와 같은 전시의 내용을 담은 상세 정보 페이지로 이동
	@RequestMapping(value = "rinsert.do")
	public ModelAndView reviewInsertMethod(@RequestParam("no") String totalId , ModelAndView mv) {
		
		Exhibition exhibition = exhibitionService.selectListOne(totalId);
		// 같은 totalId 를 갖는 한줄평 조회
		
		int currentPage = 1;
		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		// 총 목록갯수 조회해서 총 페이지 수 계산
		int listCount = reviewService.selectListCount(totalId);
		
		Paging paging = new Paging(listCount, limit, currentPage, "reviewList.do");
		paging.calculate();
		
		ArrayList<Exhibition> list = exhibitionService.selectList(paging);
		
		if (exhibition != null) {
			mv.addObject("exhibition", exhibition);
			mv.addObject("list", list);
			mv.setViewName("exhibition/reviewWriteForm");
		}
		
		
		return mv;
	}



	// 전시회 데이터 저장
	@RequestMapping(value = "apiDbSave.do", method = RequestMethod.POST)
	public ResponseEntity<String> apiDbSave(@RequestBody String param) throws ParseException {
		// post 로 request body 에 기록된 json 배열 문자열을 꺼내서 param 변수에 저장하라는 의미임

		// param 에 저장된 json string 을 json 배열 객체로 바꿈 : parsing
		JSONParser jparser = new JSONParser();
		JSONArray jarr = (JSONArray) jparser.parse(param);

		// jarr 이 가진 
		// json 객체가 가진 각 필드(property) 값을 추출해서 dto(vo, entity) 객체(Notice)에 저장
		for(int i = 0; i < jarr.size(); i++) {
			JSONObject job = (JSONObject)jarr.get(i);
			
			Exhibition exhibition = new Exhibition();
			exhibition.setTitle((String) job.get("TITLE"));
			exhibition.setContributor((String) job.get("CNTC_INSTT_NM"));
			exhibition.setDescription((String) job.get("DESCRIPTION"));
			exhibition.setFileUrl((String) job.get("IMAGE_OBJECT"));
			exhibition.setUrl((String) job.get("URL"));
			exhibition.setEventSite((String) job.get("EVENT_SITE"));
			exhibition.setGenre((String) job.get("GENRE"));
			exhibition.setContactPoint((String) job.get("CONTACT_POINT"));
			exhibition.setContributor((String) job.get("CONTRIBUTOR"));
			exhibition.setCharge((String) job.get("CHARGE"));
			exhibition.setPeriod((String) job.get("PERIOD"));
		
			// 새 공지글 등록 처리용 메소드 실행
			int result = exhibitionService.insertExhibition(exhibition);
			
			// 에러 발생 또는 공지글 등록 실패시
			if(result <= 0) {
				return new ResponseEntity<String>("failed", HttpStatus.REQUEST_TIMEOUT);
			}
			
		} // for

		// ResponseEntity<T> : 클라이언트에게 응답하는 용도의 객체임 (Spring 이 제공)
		// View 리졸버가 아닌 출력 스트림으로 나감
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
	
}
