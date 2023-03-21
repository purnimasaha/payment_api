package com.cci.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cci.payment.model.CsvRecord;
import com.cci.payment.model.AccountInfoErrorResponse;
import com.cci.payment.config.EncryptionConfig;
import com.cci.payment.model.AccountInfoClientRequest;
import com.cci.payment.model.AccountInfoClientResponse;
import com.cci.payment.service.AccountInfoService;

import om.cci.payment.constant.PaymentConstant;

@RestController
@RequestMapping("/payment")
/*@Api(value = "PaymentControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)*/
public class AccountInfoController {
	
	@Autowired
    private AccountInfoService paymentService;
    private Logger log = LoggerFactory.getLogger(AccountInfoController.class);

	@PostMapping(value = "**/getCustomerInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCustomerInfo(@RequestBody AccountInfoClientRequest paymentRequest) {
		log.info("Start getProduct" + paymentRequest.getAccountnumber());
		AccountInfoClientResponse paymentResponse = new AccountInfoClientResponse();
		//after call the file based method,received the CsvRecord object
		CsvRecord csvRecord = new CsvRecord();
		/*if (csvRecord == null) {
			PaymentErrorResponse paymentErrorResponse = new PaymentErrorResponse();
			paymentErrorResponse.setTitle(PaymentConstant.AC_INFO_ERROR_TITLE);
			paymentErrorResponse.setDetail(PaymentConstant.AC_INFO_ERROR_DETAIL);
			paymentErrorResponse.setStatus(401);
			paymentErrorResponse.setInstance(PaymentConstant.AC_INFO_ERROR_INSTANCE);
			paymentErrorResponse.setAccountnumber(paymentRequest.getAccountnumber());
			paymentErrorResponse.setRequestid(paymentRequest.getRequestId());
			return new ResponseEntity<>(paymentErrorResponse, HttpStatus.UNAUTHORIZED); 
		} else {*/
		    paymentResponse = paymentService.getPaymentInfo(paymentRequest);
		    if(paymentResponse==null) {
		    	String encPin = EncryptionConfig.encryptString(paymentRequest.getEnteredpin());
		    	if(encPin.equals(csvRecord.getAccountId())){
		    		paymentResponse.setAccountnumber(csvRecord.getAccountId());
		    	}
		    }
		//}
		return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
	}

}
