package com.ex.tiggle.review.model.dto;

public class ReviewPaging implements java.io.Serializable {
   private static final long serialVersionUID = -8649527407666546438L;
   
   private int startRow;      //해당 페이지에 출력할 시작행 (쿼리문에 적용)
   private int endRow;      //해당 페이지에 출력할 끝행 (쿼리문에 적용)
   private String totalId;
      
   
public ReviewPaging() {
}

public ReviewPaging(int startRow, int endRow, String totalId) {
	super();
	this.startRow = startRow;
	this.endRow = endRow;
	this.totalId = totalId;
}

public int getStartRow() {
	return startRow;
}

public void setStartRow(int startRow) {
	this.startRow = startRow;
}

public int getEndRow() {
	return endRow;
}

public void setEndRow(int endRow) {
	this.endRow = endRow;
}

public String getTotalId() {
	return totalId;
}

public void setTotalId(String totalId) {
	this.totalId = totalId;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "ReviewPaging [startRow=" + startRow + ", endRow=" + endRow + ", totalId=" + totalId + "]";
}



   
}
