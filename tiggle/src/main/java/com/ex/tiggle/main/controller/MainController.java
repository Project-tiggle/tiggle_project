package com.ex.tiggle.main.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.tiggle.main.service.MainService;
import com.ex.tiggle.notice.model.dto.Notice;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	
	//메인 공지사항(ajax)
	@RequestMapping(value="ntop3.do", method=RequestMethod.POST)
	@ResponseBody
	public String noticeNewTop3Method(HttpServletResponse response) throws UnsupportedEncodingException {
		ArrayList<Notice> list = mainService.selectNTop3();
		
		// 내보낼 값에 대해 response 에 mimiType 설정
		response.setContentType("application/json; charset=utf-8");
		
		// 리턴된 list 를 json 배열에 옮겨 기록하기
		JSONArray jarr = new JSONArray();
		
		for (Notice notice : list) {
			// notice 값들을 저장할 json 객체 생성
			JSONObject job = new JSONObject(); // org.json.simple.JSONObject 임포트함

			job.put("nNo", notice.getnNo());
			// 문자열값에 한글이 포함되어 있다면, 반드시 인코딩해서 저장해야 함
			// java.net.URLEncoder 의 static 메서드인 encode('문자열값', '문자셋') 사용함
			job.put("nTitle", URLEncoder.encode(notice.getnTitle(), "utf-8"));
			// 날짜데이터는 반드시 문자열로 바꿔서 저장할 것 : 날짜 그대로 저장하면 뷰에서 json 전체 출력 안 됨
			job.put("nDate", notice.getnDate().toString());

			jarr.add(job); // 배열에 추가
		} // for each
		
		// 전송용 json 객체 생성함
		JSONObject sendJson = new JSONObject();
		// 전송용 josn 에 jarr 을 저장함
		sendJson.put("nlist", jarr);

		return sendJson.toJSONString();
	}//noticeNewTop3Method() end
	
	
	
}//MainController end
