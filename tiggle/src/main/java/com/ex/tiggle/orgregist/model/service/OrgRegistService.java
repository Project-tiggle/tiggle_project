package com.ex.tiggle.orgregist.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.ex.tiggle.common.Paging;
import com.ex.tiggle.orgregist.model.dto.OrgRegist;

public interface OrgRegistService {

	int selectListCount(String uuid);				//등록 전시 전체 갯수 조회용
	ArrayList<OrgRegist> selectList(Map<String, Object> uuidNpaging);	//한 페이지에 출력할 목록 조회용, orgRegist.jsp
	
	int insertOrgRegist(OrgRegist orgRegist);		//전시 등록
	int updateMember(OrgRegist orgRegist);			//전시 등록(멤버 정보 업데이트)
	int selectMaxTotalId();							//전시 등록용(TotalId Max 번호 조회하기)
	
	OrgRegist selectOrgRegistByUuid(String uuid);	//등록페이지 내용 불러오기
	OrgRegist selectOrgTotalId(String num);			//수정페이지 내용 불러오기
	int updateOrgRegist(OrgRegist orgRegist);		//전시 수정하기
	int deleteOrgRegist(String totalId);			//전시 등록 삭제하기
	
	/* 관리자용 */
	int selectApCount();							//approvalStatus에서 N값만 받아옴
	ArrayList<OrgRegist> selectApList(Paging paging);	//N값 불러오기
	int apStatusYn(String totalId); 				//전시등록 승인처리
	
	/* API용 */
	ArrayList<OrgRegist> selectLocation();			//API용 전체 전시 조회
	int updateLocation(OrgRegist orgRegist);		//API용 위치 등록
	int updateApiApprovalY();						//API용 자료 등록 승인처리
	int updateNotNull();							//API용 NULL자료 처리용
	
}
