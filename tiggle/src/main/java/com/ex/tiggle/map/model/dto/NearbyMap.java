package com.ex.tiggle.map.model.dto;

import java.sql.Date;

public class NearbyMap implements java.io.Serializable {
	private static final long serialVersionUID = 6413124231248555348L;

	private String uuid;				//고유식별자
	private String eventSite;			//개최장소
	private double latitude;			//위도
	private double longitude;			//경도
	private String genre;				//장르
	private Date startDate;				//시작날짜
	private Date endDate;				//종료날짜
	private String approvalStatus;		//승인여부
	private int eCategory;				//분류
	private String fileURL;				//첨부파일(포스터)
	
	
	public NearbyMap() {
		super();
	}


	public NearbyMap(String uuid, String eventSite, double latitude, double longitude, String genre, Date startDate,
			Date endDate, String approvalStatus, int eCategory, String fileURL) {
		super();
		this.uuid = uuid;
		this.eventSite = eventSite;
		this.latitude = latitude;
		this.longitude = longitude;
		this.genre = genre;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approvalStatus = approvalStatus;
		this.eCategory = eCategory;
		this.fileURL = fileURL;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getEventSite() {
		return eventSite;
	}


	public void setEventSite(String eventSite) {
		this.eventSite = eventSite;
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


	public String getFileURL() {
		return fileURL;
	}


	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "NearbyMap [uuid=" + uuid + ", eventSite=" + eventSite + ", latitude=" + latitude + ", longitude="
				+ longitude + ", genre=" + genre + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", approvalStatus=" + approvalStatus + ", eCategory=" + eCategory + ", fileURL=" + fileURL + "]";
	}
	
}
