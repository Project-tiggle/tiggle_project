package com.ex.tiggle.custboard.model.dto;

import java.sql.Date;

public class CustBoard implements java.io.Serializable {
	private static final long serialVersionUID = -2990091985037992554L;

	private String uuid;		//UUID			VARCHAR2(36 BYTE)	No				1	고유식별자
	private int cId;			//C_ID			NUMBER				No				2	글번호
	private String cCategory;	//C_CATEGORY	CHAR(1 BYTE)		No				3	카테고리
	private String title;		//TITLE			VARCHAR2(300 BYTE)	No				4	제목
	private String cContent;	//C_CONTENT		VARCHAR2(2000 BYTE)	No				5	내용
	private Date createdAt;		//CREATED_AT	DATE				No	SYSDATE 	6	작성일자
	private Date updatedAt;		//UPDATED_AT	DATE				Yes				7	수정일자
	private String replyYn;		//REPLY_YN		CHAR(1 BYTE)		Yes				8	답변유무
	private Date deletedAt;		//DELETED_AT	DATE				Yes				9	삭제일자
	private String deleteYn;	//DELETED_YN	CHAR(1 BYTE)		Yes	'Y'			10	삭제활성화여부
	private int cLev;			//C_LEVEL		NUMBER				Yes				11	분류레벨
	private int refNo;			//REFNO			NUMBER				Yes				12	참조원글번호
	private String fileUrl;		//FILE_URL		VARCHAR2(300 BYTE)	Yes				13	첨부파일 URL
	
	private String id;			//ID 멤버테이블
	
	public CustBoard() {
		super();
	}

	public CustBoard(String uuid, int cId, String cCategory, String title, String cContent, Date createdAt,
			Date updatedAt, String replyYn, Date deletedAt, String deleteYn, int cLev, int refNo, String fileUrl,
			String id) {
		super();
		this.uuid = uuid;
		this.cId = cId;
		this.cCategory = cCategory;
		this.title = title;
		this.cContent = cContent;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.replyYn = replyYn;
		this.deletedAt = deletedAt;
		this.deleteYn = deleteYn;
		this.cLev = cLev;
		this.refNo = refNo;
		this.fileUrl = fileUrl;
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcCategory() {
		return cCategory;
	}

	public void setcCategory(String cCategory) {
		this.cCategory = cCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getReplyYn() {
		return replyYn;
	}

	public void setReplyYn(String replyYn) {
		this.replyYn = replyYn;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public int getcLev() {
		return cLev;
	}

	public void setcLev(int cLev) {
		this.cLev = cLev;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustBoard [uuid=" + uuid + ", cId=" + cId + ", cCategory=" + cCategory + ", title=" + title
				+ ", cContent=" + cContent + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", replyYn="
				+ replyYn + ", deletedAt=" + deletedAt + ", deleteYn=" + deleteYn + ", cLev=" + cLev + ", refNo="
				+ refNo + ", fileUrl=" + fileUrl + ", id=" + id + "]";
	}

		
	
}
