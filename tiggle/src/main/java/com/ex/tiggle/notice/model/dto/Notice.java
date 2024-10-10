package com.ex.tiggle.notice.model.dto;

import java.sql.Date;

public class Notice {
	//Field
	private int nNo;			//N_NO	NUMBER						공지글 번호
	private String nWriter;		//N_WRITER	VARCHAR2(100 BYTE)		공지 작성자
	private String nTitle;		//N_TITLE	VARCHAR2(100 BYTE)		공지 제목
	private java.sql.Date nDate;//N_DATE	DATE	공지 등록날짜
	private String nContent;	//N_CONTENT	VARCHAR2(2000 BYTE)		공지 내용
	private String nFileUrl;	//N_FILE_URL	VARCHAR2(300 BYTE)	첨부파일 URL
	private String nOriginalFilePath;	//N_ORIGINAL_FILEPATH	VARCHAR2(100 BYTE)	원본첨부파일명
	private String nRenameFilePath;		//N_RENAME_FILEPATH	VARCHAR2(100 BYTE)		바뀐첨부파일명
	private java.sql.Date nUpdatedAt;	//N_UPDATED_AT	DATE		공지 수정날짜
	private java.sql.Date nDeletedAt;	//N_DELETED_AT	DATE		공지 삭제날짜
	private String nYN;			//N_YN	CHAR(1 BYTE)				활성화 여부
	private int nReadCount;		//N_READCOUNT	NUMBER				공지 조회수
	
	//Constructor
	public Notice() {
		super();
	}
	
	//not null 일껄
	public Notice(int nNo, String nWriter, String nTitle, Date nDate, String nContent, String nOriginalFilePath,
			String nRenameFilePath) {
		super();
		this.nNo = nNo;
		this.nWriter = nWriter;
		this.nTitle = nTitle;
		this.nDate = nDate;
		this.nContent = nContent;
		this.nOriginalFilePath = nOriginalFilePath;
		this.nRenameFilePath = nRenameFilePath;
	}

	//전체
	public Notice(int nNo, String nWriter, String nTitle, Date nDate, String nContent, String nFileUrl,
			String nOriginalFilePath, String nRenameFilePath, Date nUpdatedAt, Date nDeletedAt, String nYN,
			int nReadCount) {
		super();
		this.nNo = nNo;
		this.nWriter = nWriter;
		this.nTitle = nTitle;
		this.nDate = nDate;
		this.nContent = nContent;
		this.nFileUrl = nFileUrl;
		this.nOriginalFilePath = nOriginalFilePath;
		this.nRenameFilePath = nRenameFilePath;
		this.nUpdatedAt = nUpdatedAt;
		this.nDeletedAt = nDeletedAt;
		this.nYN = nYN;
		this.nReadCount = nReadCount;
	}
	
	//getters and setters
	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public java.sql.Date getnDate() {
		return nDate;
	}

	public void setnDate(java.sql.Date nDate) {
		this.nDate = nDate;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnFileUrl() {
		return nFileUrl;
	}

	public void setnFileUrl(String nFileUrl) {
		this.nFileUrl = nFileUrl;
	}

	public String getnOriginalFilePath() {
		return nOriginalFilePath;
	}

	public void setnOriginalFilePath(String nOriginalFilePath) {
		this.nOriginalFilePath = nOriginalFilePath;
	}

	public String getnRenameFilePath() {
		return nRenameFilePath;
	}

	public void setnRenameFilePath(String nRenameFilePath) {
		this.nRenameFilePath = nRenameFilePath;
	}

	public java.sql.Date getnUpdatedAt() {
		return nUpdatedAt;
	}

	public void setnUpdatedAt(java.sql.Date nUpdatedAt) {
		this.nUpdatedAt = nUpdatedAt;
	}

	public java.sql.Date getnDeletedAt() {
		return nDeletedAt;
	}

	public void setnDeletedAt(java.sql.Date nDeletedAt) {
		this.nDeletedAt = nDeletedAt;
	}

	public String getnYN() {
		return nYN;
	}

	public void setnYN(String nYN) {
		this.nYN = nYN;
	}

	public int getnReadCount() {
		return nReadCount;
	}

	public void setnReadCount(int nReadCount) {
		this.nReadCount = nReadCount;
	}
	
	//toString
	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nWriter=" + nWriter + ", nTitle=" + nTitle + ", nDate=" + nDate + ", nContent="
				+ nContent + ", nFileUrl=" + nFileUrl + ", nOriginalFilePath=" + nOriginalFilePath
				+ ", nRenameFilePath=" + nRenameFilePath + ", nUpdatedAt=" + nUpdatedAt + ", nDeletedAt=" + nDeletedAt
				+ ", nYN=" + nYN + ", nReadCount=" + nReadCount + "]";
	}
	
}//Notice end
