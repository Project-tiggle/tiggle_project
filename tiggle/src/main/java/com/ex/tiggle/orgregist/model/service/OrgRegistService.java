package com.ex.tiggle.orgregist.model.service;

import com.ex.tiggle.orgregist.model.dto.OrgRegist;

public interface OrgRegistService {

	int insertOrgRegist(OrgRegist orgRegist);		//전시 등록
	int updateMember(OrgRegist orgRegist);			//전시 등록(멤버 정보 업데이트)
	int selectMaxTotalId();		//전시 등록용(TotalId Max 번호 조회하기)
	
	OrgRegist selectOrgRegistByUuid(String uuid);	//수정페이지 내용 불러오기
	int updateOrgRegist(OrgRegist orgRegist);		//전시 수정하기
	int deleteOrgRegist(String uuid);				//전시 등록 삭제하기
	
	
    
	
}
