package com.cci.payment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cci.payment.config.SOAPConnector;
import com.cci.payment.model.AccountInfoClientRequest;
import com.cci.payment.model.AccountInfoClientResponse;
import com.cci.payment.stub.AccountInfo;
import com.cci.payment.stub.AccountInfoRequestRecordType;
import com.cci.payment.stub.AccountInfoRequestType;
import com.cci.payment.stub.AccountInfoResponse;
import com.cci.payment.stub.HeaderType;

import om.cci.payment.constant.PaymentConstant;

@Service
public class AccountInfoService {

	private Logger LOG = LoggerFactory.getLogger(AccountInfoService.class);
	@Autowired
	private SOAPConnector sOAPConnector;

	public AccountInfoClientResponse getPaymentInfo(AccountInfoClientRequest paymentRequest) {
		LOG.info("Getting the payment with given id:" + paymentRequest);
		AccountInfoClientResponse accountInfoClientResponse = new AccountInfoClientResponse();
		AccountInfo accountInfoRequest = new AccountInfo();
		AccountInfoRequestType accountInfoRequestType = new AccountInfoRequestType();
		HeaderType headerType = new HeaderType();
		headerType.setEnterpriseID(PaymentConstant.AC_INFO_ENTERPRISEID);
		headerType.setMessageTrackingID(PaymentConstant.AC_INFO_MESSAGE_TRACKING_ID);
		accountInfoRequestType.setHeader(headerType);
		AccountInfoRequestRecordType accountInfoRequestRecordType = new AccountInfoRequestRecordType();
		accountInfoRequestRecordType.setSearchID(PaymentConstant.AC_INFO_SEARCH_ID);
		accountInfoRequestRecordType.setSearchType(PaymentConstant.AC_INFO_SEARCH_TYPE);
		accountInfoRequestType.setRequest(accountInfoRequestRecordType);
		accountInfoRequest.setAccountInfoRequest(accountInfoRequestType);
		try {
			/*
			 * AccountInfoResponse response = (AccountInfoResponse) sOAPConnector
			 * .callWebService("https://tgptest.consolidated.com/cpi-tg/services/cpi-tg",
			 * accountInfoRequest);
			 */
			AccountInfoResponse response = sOAPConnector
					.callWebService(PaymentConstant.AC_INFO_URL, accountInfoRequest);

			LOG.info("response received from NNE ---fristName---" + response.getAccountInfoOutput().getResponseRecord().getFirstName());
			accountInfoClientResponse.setFirstname(response.getAccountInfoOutput().getResponseRecord().getFirstName());
			accountInfoClientResponse.setLasttname(response.getAccountInfoOutput().getResponseRecord().getLastName());
			accountInfoClientResponse.setAccountnumber(paymentRequest.getAccountnumber());
			accountInfoClientResponse.setRequestid(paymentRequest.getRequestId());
			accountInfoClientResponse.setSourceenvironment(paymentRequest.getSourceenvironment());
			accountInfoClientResponse.setCurrentduebalance(
					String.valueOf(response.getAccountInfoOutput().getResponseRecord().getCurrentDueBalance()));
			accountInfoClientResponse.setPaymentduedate(
					response.getAccountInfoOutput().getResponseRecord().getPaymentDueDate().toString());
			accountInfoClientResponse.setBlockach(response.getAccountInfoOutput().getResponseRecord().isCashOnly());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountInfoClientResponse;
	}

}
