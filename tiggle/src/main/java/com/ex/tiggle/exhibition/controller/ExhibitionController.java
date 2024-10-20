package com.ex.tiggle.exhibition.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.common.Search;
import com.ex.tiggle.exhibition.model.dto.Exhibition;
import com.ex.tiggle.exhibition.model.service.ExhibitionService;
import com.ex.tiggle.map.model.dto.NearbyMap;
import com.ex.tiggle.member.model.dto.Member;
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
	
	// 메인 페이지가 시작했을 때 TOP-N 설정
	@RequestMapping(value = "exhibitionMainTop10.do", method = RequestMethod.POST)
	@ResponseBody
	public String exhibitionTop10ListMethod(HttpServletResponse response)  throws UnsupportedEncodingException {
		
		
		// 조회수 많은 전시회 10개 조회 요청
		ArrayList<Exhibition> list = exhibitionService.selectListTop10();
		
		// 내보낼 값에 대해 response 에 mimiType 설정
		response.setContentType("application/json; charset=utf-8");

		// 리턴된 list 를 json 배열에 옮겨 기록하기
		JSONArray jarr = new JSONArray();
		
		for (Exhibition exhibition : list) {
			// board 값들을 저장할 json 객체 생성
			JSONObject job = new JSONObject(); // org.json.simple.JSONObject 임포트함

			job.put("title", URLEncoder.encode(exhibition.getTitle(), "utf-8"));
			job.put("totalId", URLEncoder.encode(exhibition.getTotalId(), "utf-8"));
			
			if (exhibition.getCntcInsttNm() != null) {
				job.put("cnctInsttNm", URLEncoder.encode(exhibition.getCntcInsttNm(), "utf-8"));				
			}
			job.put("startDate", exhibition.getStartDate().toString());
			job.put("endDate", exhibition.getEndDate().toString());
			// 조회수
			job.put("viewCounter", exhibition.getViewCounter());
		
			//job.put("fileUrl", URLEncoder.encode(exhibition.getFileUrl(), "utf-8"));
			job.put("fileUrl", exhibition.getFileUrl());
			
			jarr.add(job); // 배열에 추가
		} // for each
		
		logger.info("job : " + jarr);
		
		// 전송용 json 객체 생성함
		JSONObject sendJson = new JSONObject();
		
		// 전송용 json 에 jarr 을 저장함
		sendJson.put("elist", jarr);
		
		return sendJson.toJSONString();
	}
	
	// sysdate와 같은 달의 전시회 조회 요청
	@RequestMapping(value = "exhibitionMainSameMon.do", method = RequestMethod.POST)
	@ResponseBody
	public String exhibitionSameMonListMethod(HttpServletResponse response)  throws UnsupportedEncodingException {
	
		// 조회수 많은 전시회 10개 조회 요청
		ArrayList<Exhibition> list = exhibitionService.selectListSameMon();
		
		// 내보낼 값에 대해 response 에 mimiType 설정
		response.setContentType("application/json; charset=utf-8");

		// 리턴된 list 를 json 배열에 옮겨 기록하기
		JSONArray jarr = new JSONArray();
		
		for (Exhibition exhibition : list) {
			// board 값들을 저장할 json 객체 생성
			JSONObject job = new JSONObject(); // org.json.simple.JSONObject 임포트함

			job.put("title", URLEncoder.encode(exhibition.getTitle(), "utf-8"));
			job.put("totalId", URLEncoder.encode(exhibition.getTotalId(), "utf-8"));
			
			if (exhibition.getCntcInsttNm() != null) {
				job.put("cnctInsttNm", URLEncoder.encode(exhibition.getCntcInsttNm(), "utf-8"));				
			}
			job.put("startDate", exhibition.getStartDate().toString());
			job.put("endDate", exhibition.getEndDate().toString());
			// 조회수
			job.put("viewCounter", exhibition.getViewCounter());
		
			//job.put("fileUrl", URLEncoder.encode(exhibition.getFileUrl(), "utf-8"));
			job.put("fileUrl", exhibition.getFileUrl());
			
			jarr.add(job); // 배열에 추가
		} // for each
		
		logger.info("job : " + jarr);
		
		// 전송용 json 객체 생성함
		JSONObject sendJson = new JSONObject();
		
		// 전송용 json 에 jarr 을 저장함
		sendJson.put("elist", jarr);
		
		return sendJson.toJSONString();
		}
	
	// 클릭한 포스터와 같은 전시의 내용을 담은 상세 정보 페이지로 이동
	@RequestMapping(value = "exhibitionDetail.do")
	public ModelAndView exhibitionDetailMethod(@RequestParam("no") String totalId , ModelAndView mv, HttpSession session) {
		
		Exhibition exhibition = exhibitionService.selectExhibitionOne(totalId);
		// 같은 totalId 를 갖는 전시 리스트
		
		String ak = new NearbyMap().getAppKeyUrl();	//APPKEY포함 URL
		String searchLat = exhibition.getLatitude();
		String searchLon = exhibition.getLongitude();

		int currentPage = 1;
		// 한 페이지에 출력할 한줄평 갯수 10개로 지정
		int limit = 10;
		// 총 목록갯수 조회해서 총 페이지 수 계산
		
		int listCount = reviewService.selectListCount(totalId);
		
		int uuidCount = 1;
		if(session.getAttribute("loginMember") != null) {
		Review review = new Review();
		
		String uuid = ((Member)session.getAttribute("loginMember")).getUuid(); 
		review.setUuid(uuid);
		review.setTotalId(totalId);
		uuidCount = reviewService.reviewWriterCount(review);
		logger.info("Review : " + review);
		}
		
		Paging paging = new Paging(listCount, limit, currentPage, "exhibitionDetail.do");
		paging.calculate();
		
		// 조회수 1 증가 처리
		exhibitionService.updateAddReadCount(totalId);
		
		ReviewPaging reviewPaging = new ReviewPaging();
		reviewPaging.setTotalId(totalId);
		reviewPaging.setStartRow(paging.getStartRow());
		reviewPaging.setEndRow(paging.getEndRow());
		// logger.info("a" + reviewPaging);
		
		ArrayList<Review> list = reviewService.selectList(reviewPaging);
		
		if (exhibition != null) {
			mv.addObject("searchLat", searchLat);
			mv.addObject("searchLon", searchLon);
			mv.addObject("link", ak);
			mv.addObject("uuidCount", uuidCount);
			mv.addObject("exhibition", exhibition);
			mv.addObject("list", list);
			mv.setViewName("exhibition/exhibitionDetail");
			}
		return mv;
	}
	
	// 한줄평 등록창에 해당 전시/한줄평 리스트를 전달해주는 메소드
	@RequestMapping(value = "rinsert.do")
	public ModelAndView reviewInsertMethod(@RequestParam("no") String totalId , ModelAndView mv) {
		
		// 같은 totalId 를 갖는 전시 리스트 조회
		Exhibition exhibition = exhibitionService.selectExhibitionOne(totalId);
		
		int currentPage = 1;
		// 한 페이지에 출력할 한줄평 갯수 10개로 지정
		int limit = 10;
		// 총 목록갯수 조회해서 한줄평 총 페이지 수 계산
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
		logger.info("apiDbSave.do 작동 확인");
		// param 에 저장된 json string 을 json 배열 객체로 바꿈 : parsing
		JSONParser jparser = new JSONParser();
		JSONArray jarr = (JSONArray) jparser.parse(param);
		
		logger.info("jarr 길이 :" + jarr.size());
		// jarr 이 가진 
		
		exhibitionService.deleteApi();
		
		// json 객체가 가진 각 필드(property) 값을 추출해서 dto(vo, entity) 객체에 저장
		for(int i = 0; i < jarr.size(); i++) {
			JSONObject job = (JSONObject)jarr.get(i);
			
			Exhibition exhibition = new Exhibition();
			exhibition.setTitle((String) job.get("TITLE"));
			exhibition.setLocalId((String) job.get("LOCAL_ID"));		
			exhibition.setCntcInsttNm((String) job.get("CNTC_INSTT_NM"));
			exhibition.setDescription((String) job.get("DESCRIPTION"));
			exhibition.setFileUrl((String) job.get("IMAGE_OBJECT"));
			exhibition.setUrl((String) job.get("URL"));
			exhibition.setEventSite((String) job.get("EVENT_SITE"));
			exhibition.setGenre((String) job.get("GENRE"));
			exhibition.setContactPoint((String) job.get("CONTACT_POINT"));
			exhibition.setContributor((String) job.get("CONTRIBUTOR"));
			exhibition.setCharge((String) job.get("CHARGE"));
			exhibition.setPeriod((String) job.get("PERIOD"));
			logger.info(exhibition.toString());
			
			// 새 전시회 데이터 등록 처리용 메소드 실행
			int result = exhibitionService.insertExhibition(exhibition);
			
			// 에러 발생 또는 데이터 등록 실패시
			if(result <= 0) {
				return new ResponseEntity<String>("failed", HttpStatus.REQUEST_TIMEOUT);
			}
			
		} // for

		// ResponseEntity<T> : 클라이언트에게 응답하는 용도의 객체임 (Spring 이 제공)
		// View 리졸버가 아닌 출력 스트림으로 나감
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	// 전시 제목 검색용 메소드 (페이징 처리 포함)
	@RequestMapping("esearchTitle.do")
	public ModelAndView exhibitionSearchTitleMethod(ModelAndView mv, 
			@RequestParam(name= "action", defaultValue="POST") String action,
			@RequestParam("keyword") String keyword,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {

		// page : 출력할 페이지, limit : 한 페이지에 출력할 목록 갯수
			logger.info("action" + action);
			// 페이징 처리
			int currentPage = 1;
			if (page != null) {
				currentPage = Integer.parseInt(page);
			}
		
			// 한 페이지에 출력할 공지 갯수 10개로 지정
			int limit = 10;
			if (slimit != null) {
				limit = Integer.parseInt(slimit);
			}
		
			// 검색 결과가 적용된 총 목록 갯수 조회후 총 페이지 수 계산
			int listCount = exhibitionService.selectSearchTitleCount(keyword);
	
		// 페이지 관련 항목 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "esearchTitle.do");
		paging.calculate();
	
		// mybatis Mapper 에서 사용되는 메소드는 Object 1개만 전달할 수 있음
		// paging.startRow, paging.endRow + keyword 가 같이 전달해야 하므로 => 하나의 객체로 만들어야 함
		Search search = new Search();
		search.setKeyword(keyword);
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
	
		// 서비스로 목록 조회 요청하고 결과 받기
		ArrayList<Exhibition> list = exhibitionService.selectSearchTitle(search);
		logger.info("list size = " + list.size());
		
		for( Exhibition test : list ) {
			logger.info(test.toString());
		};
			if (list != null && list.size() > 0) {
				mv.addObject("list", list);
				mv.addObject("paging", paging);
				mv.addObject("currentPage", currentPage);
				mv.addObject("action", action);
				mv.addObject("keyword", keyword);
		
				mv.setViewName("exhibition/exhibitionSearchResult");
			} else {
				mv.addObject("message","'" + keyword + "'" + " 에 대한 검색 결과가 존재하지 않습니다.");
				mv.setViewName("common/error");
			}
			return mv;
		}

}
