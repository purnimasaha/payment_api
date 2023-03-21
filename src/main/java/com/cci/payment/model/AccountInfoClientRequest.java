package com.cci.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountInfoClientRequest {
	@JsonProperty("accountnumber")
	private String accountnumber;
	@JsonProperty("enteredpin")
	private String enteredpin;
	@JsonProperty("sourceenvironment")
	private String sourceenvironment;
	@JsonProperty("RequestId")
	private String RequestId;
	
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getEnteredpin() {
		return enteredpin;
	}
	public void setEnteredpin(String enteredpin) {
		this.enteredpin = enteredpin;
	}
	public String getSourceenvironment() {
		return sourceenvironment;
	}
	public void setSourceenvironment(String sourceenvironment) {
		this.sourceenvironment = sourceenvironment;
	}
	public String getRequestId() {
		return RequestId;
	}
	public void setRequestId(String requestId) {
		RequestId = requestId;
	}
	@Override
	public String toString() {
		return "PaymentRequest [accountnumber=" + accountnumber + ", enteredpin=" + enteredpin + ", sourceenvironment="
				+ sourceenvironment + ", RequestId=" + RequestId + "]";
	}
	
	
}
