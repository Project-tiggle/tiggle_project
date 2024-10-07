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
	private String contributor; 	// contributor : String	
	private String description; 	// description : String	
	private String eventSite; 		// eventSite : String	
	private String detailEventSite; // detailEventSite : String	
	private double latitude;		// latitude : double	
	private double longitude;		// longitude : double	
	private String genre;			// genre : String	
	private String cotactPoint;		//contactPoint : String	
	private int viewCounter;		// viewCounter : int	
	private String url;				// url : String	
	private String period;			// period : String
	private java.sql.Date startDate;// startDate : date	
	private java.sql.Date endDate;	// endDate : date	
	private String approvalStatus;	// approvalStatus : String	
	private int category;			// category : int	
	private String fileUrl;			// fileUrl : String	

	// 기본 생성자 생성
	public Exhibition() {
	}
	
	// Not null 조건 생성자
	public Exhibition(String totalId, String uuid, String title, String contributor, String description,
			String eventSite, double latitude, double longitude, String cotactPoint, String url, String period,
			Date startDate, Date endDate, int category) {
		super();
		this.totalId = totalId;
		this.uuid = uuid;
		this.title = title;
		this.contributor = contributor;
		this.description = description;
		this.eventSite = eventSite;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cotactPoint = cotactPoint;
		this.url = url;
		this.period = period;
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
	}
	
	// getters and setters
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

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
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

	public String getCotactPoint() {
		return cotactPoint;
	}

	public void setCotactPoint(String cotactPoint) {
		this.cotactPoint = cotactPoint;
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

	
	// 전체 toString
	@Override
	public String toString() {
		return "Exhibition [totalId=" + totalId + ", uuid=" + uuid + ", title=" + title + ", contributor=" + contributor
				+ ", description=" + description + ", eventSite=" + eventSite + ", detailEventSite=" + detailEventSite
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", genre=" + genre + ", cotactPoint="
				+ cotactPoint + ", viewCounter=" + viewCounter + ", url=" + url + ", period=" + period + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", approvalStatus=" + approvalStatus + ", category=" + category
				+ ", fileUrl=" + fileUrl + "]";
	}

	
	
	
	
	
	
}
