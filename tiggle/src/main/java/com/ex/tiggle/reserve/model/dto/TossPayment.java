package com.ex.tiggle.reserve.model.dto;

public class TossPayment implements java.io.Serializable {
	private static final long serialVersionUID = 1532722539971889256L;
	
	
	 private String orderId; // orderId", orderId);
	 private int amount;// amount", amount);
	 private String cardNumber;  // cardNumber", cardNumber);
	 private String cardExpirationYear;  // cardExpirationYear", cardExpirationYear);
	 private String cardExpirationMonth;  // cardExpirationMonth", cardExpirationMonth);
	 private String cardPassword;  // cardPassword", cardPassword);
	 private String customerBirthday;  // customerBirthday", customerBirthday);
	 private String cardInstallmentPlan;  // cardInstallmentPlan", cardInstallmentPlan);
	 private String customerEmail;  // customerEmail", customerEmail);
	 private String customerName;  // customerName", customerName);
	 private String orderName;  // orderName", orderName);
	
	 
	 public TossPayment() {
		super();
	}


	public TossPayment(String orderId, int amount, String cardNumber, String cardExpirationYear,
			String cardExpirationMonth, String cardPassword, String customerBirthday, String cardInstallmentPlan,
			String customerEmail, String customerName, String orderName) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.cardExpirationYear = cardExpirationYear;
		this.cardExpirationMonth = cardExpirationMonth;
		this.cardPassword = cardPassword;
		this.customerBirthday = customerBirthday;
		this.cardInstallmentPlan = cardInstallmentPlan;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.orderName = orderName;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCardExpirationYear() {
		return cardExpirationYear;
	}


	public void setCardExpirationYear(String cardExpirationYear) {
		this.cardExpirationYear = cardExpirationYear;
	}


	public String getCardExpirationMonth() {
		return cardExpirationMonth;
	}


	public void setCardExpirationMonth(String cardExpirationMonth) {
		this.cardExpirationMonth = cardExpirationMonth;
	}


	public String getCardPassword() {
		return cardPassword;
	}


	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}


	public String getCustomerBirthday() {
		return customerBirthday;
	}


	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}


	public String getCardInstallmentPlan() {
		return cardInstallmentPlan;
	}


	public void setCardInstallmentPlan(String cardInstallmentPlan) {
		this.cardInstallmentPlan = cardInstallmentPlan;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "TossPayment [orderId=" + orderId + ", amount=" + amount + ", cardNumber=" + cardNumber
				+ ", cardExpirationYear=" + cardExpirationYear + ", cardExpirationMonth=" + cardExpirationMonth
				+ ", cardPassword=" + cardPassword + ", customerBirthday=" + customerBirthday + ", cardInstallmentPlan="
				+ cardInstallmentPlan + ", customerEmail=" + customerEmail + ", customerName=" + customerName
				+ ", orderName=" + orderName + "]";
	}

	
	

}
