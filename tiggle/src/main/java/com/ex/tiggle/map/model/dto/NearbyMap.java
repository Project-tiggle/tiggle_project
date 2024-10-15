package com.ex.tiggle.map.model.dto;

import java.sql.Date;

public class NearbyMap implements java.io.Serializable {
	private static final long serialVersionUID = 6413124231248555348L;

	private String uuid;			//	UUID			VARCHAR2(36 BYTE)		Yes		1	고유식별자
	private String totalId;			//	TOTAL_ID		VARCHAR2(16 BYTE)		No		2	전시박람회통합ID
	private String title;			//	TITLE			VARCHAR2(4000 BYTE)		Yes		3	제목
	private String localId;			//	LOCAL_ID		VARCHAR2(1000 BYTE)		Yes		4	전시ID
	private String contributor;		//	CONTRIBUTOR		VARCHAR2(1000 BYTE)		Yes		5	주최/후원
	private String cntcInsttNm;		//	CNTC_INSTT_NM	VARCHAR2(1000 BYTE)		Yes		6	연계 기관
	private String eDescription;	//	E_DESCRIPTION	LONG					Yes		7	소개
	private String eventSite;		//	EVENT_SITE		VARCHAR2(4000 BYTE)		Yes		8	장소
	private String detailEventSite;	//	DETAIL_EVENT_SITE	VARCHAR2(4000 BYTE)	Yes		9	상세주소
	private double latitude;		//	LATITUDE		VARCHAR2(1000 BYTE)		Yes		10	위도
	private double longitude;		//	LONGITUDE		VARCHAR2(1000 BYTE)		Yes		11	경도
	private String genre;			//	GENRE			VARCHAR2(1000 BYTE)		Yes		12	장르
	private String contactPoint;	//	CONTACT_POINT	VARCHAR2(1000 BYTE)		Yes		13	문의
	private int viewCounter;		//	VIEW_COUNTER	NUMBER					Yes		14	조회수
	private String eUrl;			//	E_URL			VARCHAR2(1000 BYTE)		Yes		15	홈페이지 주소
	private String preiod;			//	PERIOD			VARCHAR2(100 BYTE)		Yes		16	전시 기간
	private Date startDate;			//	START_DATE		DATE					Yes		17	시작날짜
	private Date endDate;			//	END_DATE		DATE					Yes		18	종료날짜
	private String approvalStatus;	//	APPROVAL_STATUS	CHAR(1 BYTE)			Yes		19	승인여부
	private int eCategory;			//	E_CATEGORY		NUMBER					Yes		20	분류
	private String fileUrl;			//	FILE_URL		VARCHAR2(4000 BYTE)		Yes		21	첨부파일URL
	private String charge;			//	CHARGE			VARCHAR2(1000 BYTE)		Yes		22	가격 할인정보
	
	public NearbyMap() {
		super();
	}

	public NearbyMap(String uuid, String totalId, String title, String localId, String contributor, String cntcInsttNm,
			String eDescription, String eventSite, String detailEventSite, double latitude, double longitude,
			String genre, String contactPoint, int viewCounter, String eUrl, String preiod, Date startDate,
			Date endDate, String approvalStatus, int eCategory, String fileUrl, String charge) {
		super();
		this.uuid = uuid;
		this.totalId = totalId;
		this.title = title;
		this.localId = localId;
		this.contributor = contributor;
		this.cntcInsttNm = cntcInsttNm;
		this.eDescription = eDescription;
		this.eventSite = eventSite;
		this.detailEventSite = detailEventSite;
		this.latitude = latitude;
		this.longitude = longitude;
		this.genre = genre;
		this.contactPoint = contactPoint;
		this.viewCounter = viewCounter;
		this.eUrl = eUrl;
		this.preiod = preiod;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approvalStatus = approvalStatus;
		this.eCategory = eCategory;
		this.fileUrl = fileUrl;
		this.charge = charge;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTotalId() {
		return totalId;
	}

	public void setTotalId(String totalId) {
		this.totalId = totalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public String getCntcInsttNm() {
		return cntcInsttNm;
	}

	public void setCntcInsttNm(String cntcInsttNm) {
		this.cntcInsttNm = cntcInsttNm;
	}

	public String geteDescription() {
		return eDescription;
	}

	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}

	public String getEventSite() {
		return eventSite;
	}

	public void setEventSite(String eventSite) {
		this.eventSite = eventSite;
	}

	public String getDetailEventSite() {
		return detailEventSite;
	}

	public void setDetailEventSite(String detailEventSite) {
		this.detailEventSite = detailEventSite;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getContactPoint() {
		return contactPoint;
	}

	public void setContactPoint(String contactPoint) {
		this.contactPoint = contactPoint;
	}

	public int getViewCounter() {
		return viewCounter;
	}

	public void setViewCounter(int viewCounter) {
		this.viewCounter = viewCounter;
	}

	public String geteUrl() {
		return eUrl;
	}

	public void seteUrl(String eUrl) {
		this.eUrl = eUrl;
	}

	public String getPreiod() {
		return preiod;
	}

	public void setPreiod(String preiod) {
		this.preiod = preiod;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int geteCategory() {
		return eCategory;
	}

	public void seteCategory(int eCategory) {
		this.eCategory = eCategory;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NearbyMap [uuid=" + uuid + ", totalId=" + totalId + ", title=" + title + ", localId=" + localId
				+ ", contributor=" + contributor + ", cntcInsttNm=" + cntcInsttNm + ", eDescription=" + eDescription
				+ ", eventSite=" + eventSite + ", detailEventSite=" + detailEventSite + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", genre=" + genre + ", contactPoint=" + contactPoint + ", viewCounter="
				+ viewCounter + ", eUrl=" + eUrl + ", preiod=" + preiod + ", startDate=" + startDate + ", endDate="
				+ endDate + ", approvalStatus=" + approvalStatus + ", eCategory=" + eCategory + ", fileUrl=" + fileUrl
				+ ", charge=" + charge + "]";
	}
	
}
