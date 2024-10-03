package com.ex.tiggle.orgregist.model.dto;

import java.sql.Date;

public class OrgRegist implements java.io.Serializable {
	private static final long serialVersionUID = 6700511157757941396L;

	//tb_exhibition_fair
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
	//tb_member
	private String name;			//	EMAIL	VARCHAR2(50 BYTE)
	private String mngDept;			//	MNG_DEPT	VARCHAR2(50 BYTE)
	private String mngJobId;		//	MNG_JOBID	VARCHAR2(20 BYTE)
    private String phone;			//	PHONE	VARCHAR2(15 BYTE)
    private String email;			//	EMAIL	VARCHAR2(50 BYTE)
	
    
    public OrgRegist() {
		super();
	}


	public OrgRegist(String uuid, String totalId, String title, String contributor, String eDescription,
			String eventSite, String detailEventSite, double latitude, double longitude, String genre,
			String contactPoint, int viewCounter, String eUrl, Date startDate, Date endDate, String approvalStatus,
			int eCategory, String fileUrl, String name, String mngDept, String mngJobId, String phone, String email) {
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
		this.name = name;
		this.mngDept = mngDept;
		this.mngJobId = mngJobId;
		this.phone = phone;
		this.email = email;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMngDept() {
		return mngDept;
	}


	public void setMngDept(String mngDept) {
		this.mngDept = mngDept;
	}


	public String getMngJobId() {
		return mngJobId;
	}


	public void setMngJobId(String mngJobId) {
		this.mngJobId = mngJobId;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "OrgRegist [uuid=" + uuid + ", totalId=" + totalId + ", title=" + title + ", contributor=" + contributor
				+ ", eDescription=" + eDescription + ", eventSite=" + eventSite + ", detailEventSite=" + detailEventSite
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", genre=" + genre + ", contactPoint="
				+ contactPoint + ", viewCounter=" + viewCounter + ", eUrl=" + eUrl + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", approvalStatus=" + approvalStatus + ", eCategory=" + eCategory
				+ ", fileUrl=" + fileUrl + ", name=" + name + ", mngDept=" + mngDept + ", mngJobId=" + mngJobId
				+ ", phone=" + phone + ", email=" + email + "]";
	}
   
    
	
}
