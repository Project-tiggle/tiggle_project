package com.ex.tiggle.map.model.dto;

import java.sql.Date;

public class NearbyMap implements java.io.Serializable {
	private static final long serialVersionUID = 6413124231248555348L;

	private String uuid;			//	UUID	VARCHAR2(36 BYTE)
	private String totalId;			//	TOTAL_ID	VARCHAR2(16 BYTE)
	private String title;			//	TITLE	VARCHAR2(100 BYTE)
	private String contributor;		//	CONTRIBUTOR	VARCHAR2(30 BYTE)
	private String eDescription;	//	E_DESCRIPTION	VARCHAR2(2000 BYTE)
	private String eventSite;		//	EVENT_SITE	VARCHAR2(300 BYTE)
	private String detailEventSite;	//	DETAIL_EVENT_SITE	VARCHAR2(300 BYTE)
	private double latitude;		//	LATITUDE	NUMBER
	private double longitude;		//	LONGITUDE	NUMBER
	private String genre;			//	GENRE	VARCHAR2(30 BYTE)
	private String contactPoint;	//	CONTACT_POINT	VARCHAR2(30 BYTE)
	private int viewCounter;		//	VIEW_COUNTER	NUMBER
	private String eUrl;			//	E_URL	VARCHAR2(300 BYTE)
	private Date startDate;//	START_DATE	DATE
	private Date endDate;	//	END_DATE	DATE
	private String approvalStatus;	//	APPROVAL_STATUS	CHAR(1 BYTE)
	private int eCategory;			//	E_CATEGORY	NUMBER
	private String fileUrl;			//	FILE_URL	VARCHAR2(300 BYTE)
	
	
	public NearbyMap() {
		super();
	}


	public NearbyMap(String uuid, String totalId, String title, String contributor, String eDescription,
			String eventSite, String detailEventSite, double latitude, double longitude, String genre,
			String contactPoint, int viewCounter, String eUrl, Date startDate, Date endDate, String approvalStatus,
			int eCategory, String fileUrl) {
		super();
		this.uuid = uuid;
		this.totalId = totalId;
		this.title = title;
		this.contributor = contributor;
		this.eDescription = eDescription;
		this.eventSite = eventSite;
		this.detailEventSite = detailEventSite;
		this.latitude = latitude;
		this.longitude = longitude;
		this.genre = genre;
		this.contactPoint = contactPoint;
		this.viewCounter = viewCounter;
		this.eUrl = eUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approvalStatus = approvalStatus;
		this.eCategory = eCategory;
		this.fileUrl = fileUrl;
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


	public String getContributor() {
		return contributor;
	}


	public void setContributor(String contributor) {
		this.contributor = contributor;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "NearbyMap [uuid=" + uuid + ", totalId=" + totalId + ", title=" + title + ", contributor=" + contributor
				+ ", eDescription=" + eDescription + ", eventSite=" + eventSite + ", detailEventSite=" + detailEventSite
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", genre=" + genre + ", contactPoint="
				+ contactPoint + ", viewCounter=" + viewCounter + ", eUrl=" + eUrl + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", approvalStatus=" + approvalStatus + ", eCategory=" + eCategory
				+ ", fileUrl=" + fileUrl + "]";
	}
	
	
	
}
