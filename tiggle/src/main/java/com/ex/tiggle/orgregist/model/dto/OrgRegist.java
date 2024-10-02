package com.ex.tiggle.orgregist.model.dto;

import java.sql.Date;

public class OrgRegist implements java.io.Serializable {
	private static final long serialVersionUID = 6700511157757941396L;

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
	private java.sql.Date startDate;//	START_DATE	DATE
	private java.sql.Date endDate;	//	END_DATE	DATE
	private String approvalStatus;	//	APPROVAL_STATUS	CHAR(1 BYTE)
	private int eCategory;			//	E_CATEGORY	NUMBER
	private String fileUrl;			//	FILE_URL	VARCHAR2(300 BYTE)
	
	
	public OrgRegist() {
		super();
	}


	public OrgRegist(String uuid, String totalId, String title, String contributor, String eDescription,
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


	public OrgRegist(String uuid, String totalId, String title, String contributor, String eDescription,
			String eventSite, String detailEventSite, double latitude, double longitude, String genre,
			String contactPoint, String eUrl, Date startDate, Date endDate, String approvalStatus, int eCategory) {
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
		this.eUrl = eUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approvalStatus = approvalStatus;
		this.eCategory = eCategory;
	}


	@Override
	public String toString() {
		return "OrgRegist [uuid=" + uuid + ", totalId=" + totalId + ", title=" + title + ", contributor=" + contributor
				+ ", eDescription=" + eDescription + ", eventSite=" + eventSite + ", detailEventSite=" + detailEventSite
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", genre=" + genre + ", contactPoint="
				+ contactPoint + ", viewCounter=" + viewCounter + ", eUrl=" + eUrl + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", approvalStatus=" + approvalStatus + ", eCategory=" + eCategory
				+ ", fileUrl=" + fileUrl + "]";
	}
	
	
}
