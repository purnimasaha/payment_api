package com.cci.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AccountInfoErrorResponse {
	
	@JsonProperty("accountnumber")
	private String accountnumber;
	@JsonProperty("requestid")
	private String requestid;
	@JsonProperty("title")
	private String title;
	@JsonProperty("detail")
	private String detail;
	@JsonProperty("status")
	private int status;
	@JsonProperty("instance")
	private String instance;

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentErrorResponse [accountnumber=" + accountnumber + ", requestid=" + requestid + ", title=" + title
				+ ", detail=" + detail + ", status=" + status + ", instance=" + instance + "]";
	}

	
}
