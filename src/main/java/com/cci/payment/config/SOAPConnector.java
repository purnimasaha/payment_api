package com.cci.payment.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.cci.payment.model.UsernameToken;
import com.cci.payment.stub.AccountInfoResponse;
import com.cci.payment.stub.PayAndRestoreResponse;

import om.cci.payment.constant.PaymentConstant;

public class SOAPConnector extends WebServiceGatewaySupport {

		 public AccountInfoResponse callWebService(String url,Object request) {
			 //return (AccountInfoResponse) getWebServiceTemplate().marshalSendAndReceive(url,request);
		        return (AccountInfoResponse) getWebServiceTemplate()
		                .marshalSendAndReceive(request,
		                        new SecurityHeader(null));
		                                //new UsernameToken(PaymentConstant.AC_INFO_USERNAME, PaymentConstant.AC_INFO_PASSWORD)));
		    
		 }
		 
		 public PayAndRestoreResponse callPostPaymentWebService(String url,Object request) {
		        return (PayAndRestoreResponse) getWebServiceTemplate()
		                .marshalSendAndReceive(request,
		                        new SecurityHeader(null));                             
		    
		 }
		 
}