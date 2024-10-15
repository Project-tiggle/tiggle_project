package com.ex.tiggle.review.model.dto;

import java.sql.Date;

public class Review implements java.io.Serializable {
	private static final long serialVersionUID = 5943858491540436837L;
	
	
	private String totalId;  	// TOTAL_ID	VARCHAR2(100 BYTE)
	private String uuid; 		// UUID	VARCHAR2(36 BYTE)
	private int rNum; 			// R_NUM	NUMBER
	private String nickname;	// NICKNAME	VARCHAR2(50 BYTE)
	private String rContents; 	// R_CONTENTS	VARCHAR2(500 BYTE)
	private Date writeDate; 	// WRITE_DATE	DATE
	private Date updateDate; 	// UPDATE_DATE	DATE
	private String updateYN; 	// UPDATED_YN	CHAR(1 BYTE)
	private Date deleteDate; 	// DELETE_AT	DATE
	private String deleteYN; 	// DELETE_YN	CHAR(1 BYTE)
	
	
	
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
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public String getNickName() {
		return nickname;
	}
	public void setNickName(String nickname) {
		this.nickname = nickname;
	}
	public String getrContents() {
		return rContents;
	}
	public void setrContents(String rContents) {
		this.rContents = rContents;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateYN() {
		return updateYN;
	}
	public void setUpdateYN(String updateYN) {
		this.updateYN = updateYN;
	}
	public Date getDeletedDate() {
		return deleteDate;
	}
	public void setDeletedDate(Date deletedDate) {
		this.deleteDate = deletedDate;
	}
	public String getDeleteYN() {
		return deleteYN;
	}
	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}
	
	
	
	public Review() {
	}
	
	public Review(String totalId, String uuid, int rNum, String nickname, String rContents, Date writeDate) {
		super();
		this.totalId = totalId;
		this.uuid = uuid;
		this.rNum = rNum;
		this.nickname = nickname;
		this.rContents = rContents;
		this.writeDate = writeDate;
	}
	
	
	public Review(String totalId, String uuid, int rNum, String nickname, String rContents, Date writeDate,
			Date updateDate, String updateYN, Date deletedDate, String deleteYN) {
		super();
		this.totalId = totalId;
		this.uuid = uuid;
		this.rNum = rNum;
		this.nickname = nickname;
		this.rContents = rContents;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
		this.updateYN = updateYN;
		this.deleteDate = deletedDate;
		this.deleteYN = deleteYN;
	}
	
	@Override
	public String toString() {
		return "Review [totalId=" + totalId + ", uuid=" + uuid + ", rNum=" + rNum + ", nickname=" + nickname
				+ ", rContents=" + rContents + ", writeDate=" + writeDate + ", updateDate=" + updateDate + ", updateYN="
				+ updateYN + ", deletedDate=" + deleteDate + ", deleteYN=" + deleteYN + "]";
	}
	
	
	
	
}
