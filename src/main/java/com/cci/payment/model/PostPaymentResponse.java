package com.cci.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostPaymentResponse {

	@JsonProperty("requestId")
	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
}
