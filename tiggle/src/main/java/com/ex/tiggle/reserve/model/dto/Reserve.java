package com.ex.tiggle.reserve.model.dto;

import java.sql.Date;

public class Reserve implements java.io.Serializable {
	private static final long serialVersionUID = 8379421771928452928L;
	
	
	private String uuid; // UUID	VARCHAR2(36 BYTE)
	private String totalId; // TOTAL_ID	VARCHAR2(16 BYTE)
	private String rId; // R_ID	VARCHAR2(16 BYTE)
	private Date viewDate; // VIEW_DATE	DATE
	private int ticketCount; // TICKET_COUNT	NUMBER
	private Date cancleAbleDate; // CANCEL_ABLE_DATE	DATE
	private String reserveStatus; // RESERVE_STATUS	CHAR(1 BYTE)
	private int ticketMethod; // TICKET_METHOD	NUMBER
	private int ticketPrice; // TICKET_PRICE	NUMBER
	private int basicPrice; // BASIC_PRICE	NUMBER
	private int discountPrice; // DISCOUNT_PRICE	NUMBER
	private int reserveFEE; // RESERVE_FEE	NUMBER
	private int shippingFEE; // SHIPPING_FEE	NUMBER
	private String payMethod; //PAY_METHOD	CHAR(1 BYTE)
	private String payCardName; // PAY_CARDNAME	VARCHAR2(50 BYTE)
	private int payAmount; // PAY_AMOUNT	NUMBER
	private Date payDate; // PAY_DATE	DATE
	private int cancelPenalty; // CANCEL_PENALTY	NUMBER
	private Date cancelDate; // CANCEL_DATE	DATE
	private int refundAmount; // REFUND_AMOUNT	NUMBER
	
	
	
	
	public Reserve() {
		super();
	}


	public Reserve(String uuid, String totalId, String rId, Date viewDate, int ticketCount, Date cancleAbleDate,
			String reserveStatus, int ticketMethod, int ticketPrice, int basicPrice, int discountPrice, int reserveFEE,
			int shippingFEE, String payMethod, String payCardName, int payAmount, Date payDate, int cancelPenalty,
			Date cancelDate, int refundAmount) {
		super();
		this.uuid = uuid;
		this.totalId = totalId;
		this.rId = rId;
		this.viewDate = viewDate;
		this.ticketCount = ticketCount;
		this.cancleAbleDate = cancleAbleDate;
		this.reserveStatus = reserveStatus;
		this.ticketMethod = ticketMethod;
		this.ticketPrice = ticketPrice;
		this.basicPrice = basicPrice;
		this.discountPrice = discountPrice;
		this.reserveFEE = reserveFEE;
		this.shippingFEE = shippingFEE;
		this.payMethod = payMethod;
		this.payCardName = payCardName;
		this.payAmount = payAmount;
		this.payDate = payDate;
		this.cancelPenalty = cancelPenalty;
		this.cancelDate = cancelDate;
		this.refundAmount = refundAmount;
	}
	
	
	// getters and setters
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
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public Date getViewDate() {
		return viewDate;
	}
	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public Date getCancleAbleDate() {
		return cancleAbleDate;
	}
	public void setCancleAbleDate(Date cancleAbleDate) {
		this.cancleAbleDate = cancleAbleDate;
	}
	public String getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public int getTicketMethod() {
		return ticketMethod;
	}
	public void setTicketMethod(int ticketMethod) {
		this.ticketMethod = ticketMethod;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getReserveFEE() {
		return reserveFEE;
	}
	public void setReserveFEE(int reserveFEE) {
		this.reserveFEE = reserveFEE;
	}
	public int getShippingFEE() {
		return shippingFEE;
	}
	public void setShippingFEE(int shippingFEE) {
		this.shippingFEE = shippingFEE;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getPayCardName() {
		return payCardName;
	}
	public void setPayCardName(String payCardName) {
		this.payCardName = payCardName;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public int getCancelPenalty() {
		return cancelPenalty;
	}
	public void setCancelPenalty(int cancelPenalty) {
		this.cancelPenalty = cancelPenalty;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public int getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	
	@Override
	public String toString() {
		return "Reserve [uuid=" + uuid + ", totalId=" + totalId + ", rId=" + rId + ", viewDate=" + viewDate
				+ ", ticketCount=" + ticketCount + ", cancleAbleDate=" + cancleAbleDate + ", reserveStatus="
				+ reserveStatus + ", ticketMethod=" + ticketMethod + ", ticketPrice=" + ticketPrice + ", basicPrice="
				+ basicPrice + ", discountPrice=" + discountPrice + ", reserveFEE=" + reserveFEE + ", shippingFEE="
				+ shippingFEE + ", payMethod=" + payMethod + ", payCardName=" + payCardName + ", payAmount=" + payAmount
				+ ", payDate=" + payDate + ", cancelPenalty=" + cancelPenalty + ", cancelDate=" + cancelDate
				+ ", refundAmount=" + refundAmount + "]";
	}

	
	
	
	
	
}
