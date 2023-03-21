package com.cci.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AccountInfoClientResponse {
	
	@JsonProperty("accountnumber")
	private String accountnumber;
	@JsonProperty("requestid")
	private String requestid;
	@JsonProperty("sourceenvironment")
	private String sourceenvironment;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lasttname")
	private String lasttname;
	@JsonProperty("currentduebalance")
	private String currentduebalance;
	@JsonProperty("paymentduedate")
	private String paymentduedate;
	@JsonProperty("blockach")
	private boolean blockach;
	
	
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

	public String getSourceenvironment() {
		return sourceenvironment;
	}

	public void setSourceenvironment(String sourceenvironment) {
		this.sourceenvironment = sourceenvironment;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLasttname() {
		return lasttname;
	}

	public void setLasttname(String lasttname) {
		this.lasttname = lasttname;
	}

	public String getCurrentduebalance() {
		return currentduebalance;
	}

	public void setCurrentduebalance(String currentduebalance) {
		this.currentduebalance = currentduebalance;
	}

	public String getPaymentduedate() {
		return paymentduedate;
	}

	public void setPaymentduedate(String paymentduedate) {
		this.paymentduedate = paymentduedate;
	}

	public boolean isBlockach() {
		return blockach;
	}

	public void setBlockach(boolean blockach) {
		this.blockach = blockach;
	}

	@Override
	public String toString() {
		return "PaymentResponse [accountnumber=" + accountnumber + ", requestid=" + requestid + ", sourceenvironment="
				+ sourceenvironment + ", firstname=" + firstname + ", lasttname=" + lasttname + ", currentduebalance="
				+ currentduebalance + ", paymentduedate=" + paymentduedate + ", blockach=" + blockach + "]";
	}
	
	
}
