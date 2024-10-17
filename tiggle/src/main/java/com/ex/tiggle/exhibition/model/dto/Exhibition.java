package com.ex.tiggle.exhibition.model.dto;

import java.sql.Date;

//dto (vo, entity, bean) 작성 규칙
//1. 반드시 직렬화할 것
//2. 모든 필드(멤버변수, property)는 반드시 private : 캡슐화할 것.
//3. 기본 생성자, 매개변수 있는 생성자 작성
//4. 모든 필드에 대한 getter and setter 작성할 것
//5. toString() 오버라이딩
//선택사항 : equals(), clone(), hashCode() 오버라이딩

public class Exhibition implements java.io.Serializable {
	private static final long serialVersionUID = -6661928927016442490L;
		
	private String totalId;			// totalId : String	
	private String uuid; 			// uuid : String	
	private String title;			// title : String	
	private String localId;			// localId : String	
	private String contributor; 	// contributor : String
	private String cntcInsttNm; 	// cntcInsttNm : String	
	private String description; 	// description : String	
	private String eventSite; 		// eventSite : String	
	private String detailEventSite; // detailEventSite : String	
	private String latitude;		// latitude : double	
	private String longitude;		// longitude : double	
	private String genre;			// genre : String	
	private String contactPoint;	// contactPoint : String	
	private int viewCounter;		// viewCounter : int	
	private String url;				// url : String	
	private String period;			// period : String
	private java.sql.Date startDate;// startDate : date	
	private java.sql.Date endDate;	// endDate : date	
	private String approvalStatus;	// approvalStatus : String	
	private int category;			// category : int	
	private String fileUrl;			// fileUrl : String
	private String charge;			// charge : String

	// 기본 생성자 생성
	public Exhibition() {
	}
	
	// Not null 조건 생성자
	public Exhibition(String totalId) {
		super();
		this.totalId = totalId;		
	}

	public Exhibition(String totalId, String uuid, String title, String localId, String contributor, String cntcInsttNm,
			String description, String eventSite, String detailEventSite, String latitude, String longitude,
			String genre, String contactPoint, int viewCounter, String url, String period, Date startDate, Date endDate,
			String approvalStatus, int category, String fileUrl, String charge) {
		super();
		this.totalId = totalId;
		this.uuid = uuid;
		this.title = title;
		this.localId = localId;
		this.contributor = contributor;
		this.cntcInsttNm = cntcInsttNm;
		this.description = description;
		this.eventSite = eventSite;
		this.detailEventSite = detailEventSite;
		this.latitude = latitude;
		this.longitude = longitude;
		this.genre = genre;
		this.contactPoint = contactPoint;
		this.viewCounter = viewCounter;
		this.url = url;
		this.period = period;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approvalStatus = approvalStatus;
		this.category = category;
		this.fileUrl = fileUrl;
		this.charge = charge;
	}

	public String getTotalId() {
		return totalId;
	}

	public void setTotalId(String totalId) {
		this.totalId = totalId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
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
		return "Exhibition [totalId=" + totalId + ", uuid=" + uuid + ", title=" + title + ", localId=" + localId
				+ ", contributor=" + contributor + ", cntcInsttNm=" + cntcInsttNm + ", description=" + description
				+ ", eventSite=" + eventSite + ", detailEventSite=" + detailEventSite + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", genre=" + genre + ", contactPoint=" + contactPoint + ", viewCounter="
				+ viewCounter + ", url=" + url + ", period=" + period + ", startDate=" + startDate + ", endDate="
				+ endDate + ", approvalStatus=" + approvalStatus + ", category=" + category + ", fileUrl=" + fileUrl
				+ ", charge=" + charge + "]";
	}
	
	
	
}
