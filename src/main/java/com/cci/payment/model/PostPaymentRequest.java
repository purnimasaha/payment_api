package com.cci.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostPaymentRequest {
	@JsonProperty("accountnumber")
	private String accountnumber;
	@JsonProperty("sourceenvironment")
	private String sourceenvironment;
	@JsonProperty("requestId")
	private String requestId;
	@JsonProperty("amount")
	private int amount;
	@JsonProperty("feeamount")
	private Long feeamount;
	@JsonProperty("datetime")
	private String datetime;
	@JsonProperty("annotation")
	private String annotation;
	@JsonProperty("transtype")
	private int transtype;
	@JsonProperty("transsource")
	private int transsource;
	@JsonProperty("messagetrackingid")
	private String messagetrackingid;
	@JsonProperty("enterpriseid")
	private String enterpriseid;
	
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getSourceenvironment() {
		return sourceenvironment;
	}
	public void setSourceenvironment(String sourceenvironment) {
		this.sourceenvironment = sourceenvironment;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Long getFeeamount() {
		return feeamount;
	}
	public void setFeeamount(Long feeamount) {
		this.feeamount = feeamount;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public int getTranstype() {
		return transtype;
	}
	public void setTranstype(int transtype) {
		this.transtype = transtype;
	}
	public int getTranssource() {
		return transsource;
	}
	public void setTranssource(int transsource) {
		this.transsource = transsource;
	}
	
	public String getMessagetrackingid() {
		return messagetrackingid;
	}
	public void setMessagetrackingid(String messagetrackingid) {
		this.messagetrackingid = messagetrackingid;
	}
	public String getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(String enterpriseid) {
		this.enterpriseid = enterpriseid;
	}
	
}
