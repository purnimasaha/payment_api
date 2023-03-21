package com.cci.payment.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cci.payment.model.CsvRecord;
import com.cci.payment.model.PostPaymentRequest;
import com.cci.payment.model.PostPaymentResponse;
import com.cci.payment.model.AccountInfoErrorResponse;
import com.cci.payment.model.AccountInfoClientRequest;
import com.cci.payment.model.AccountInfoClientResponse;
import com.cci.payment.service.AccountInfoService;
import com.cci.payment.service.PostPaymentService;

import om.cci.payment.constant.PaymentConstant;

@RestController
@RequestMapping("/payment")
/*@Api(value = "PaymentControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)*/
public class PaymentController {
	
	@Autowired
    private PostPaymentService paymentService;
    private Logger log = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping(value = "**/postPayment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> postPayment(@RequestBody PostPaymentRequest postPaymentRequest,
			@RequestHeader Map<String, String> headers) {
		log.info("Start postPayment::" + postPaymentRequest.getAccountnumber());
		postPaymentRequest.setMessagetrackingid(headers.get("messagetrackingid"));
		postPaymentRequest.setEnterpriseid(headers.get("enterpriseid"));
		/*headers.forEach((key, value) -> {
			log.info(String.format("Header '%s' = %s", key, value));
	    });*/
		PostPaymentResponse paymentResponse = new PostPaymentResponse();
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
		    paymentResponse =paymentService.getPostPaymentInfo(postPaymentRequest);
		//}
		return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
	}

}
