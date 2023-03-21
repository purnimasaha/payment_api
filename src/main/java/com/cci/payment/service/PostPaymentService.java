package com.cci.payment.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cci.payment.config.SOAPConnector;
import com.cci.payment.model.PostPaymentRequest;
import com.cci.payment.model.PostPaymentResponse;
import com.cci.payment.stub.HeaderType;
import com.cci.payment.stub.ObjectFactory;
import com.cci.payment.stub.PayAndRestore;
import com.cci.payment.stub.PayAndRestoreRequestRecordType;
import com.cci.payment.stub.PayAndRestoreRequestType;
import com.cci.payment.stub.PayAndRestoreResponse;

import om.cci.payment.constant.PaymentConstant;

@Service
public class PostPaymentService {

	private Logger LOG = LoggerFactory.getLogger(PostPaymentService.class);
	@Autowired
	private SOAPConnector sOAPConnector;

	public PostPaymentResponse getPostPaymentInfo(PostPaymentRequest paymentRequest) {
		LOG.info("Getting the payment with given id:" + paymentRequest.getRequestId());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		Date date;
		XMLGregorianCalendar xmlGregCal = null;
		try {
			date = format.parse(paymentRequest.getDatetime());
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);

			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (ParseException | DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<Long> jaxbElementFeeAmount = objectFactory.createPayAndRestoreRequestRecordTypeFeeAmount(paymentRequest.getFeeamount());

		PostPaymentResponse postPaymentResponse = new PostPaymentResponse();
		PayAndRestore payAndRestoreRequest = new PayAndRestore();
		PayAndRestoreRequestType payAndRestoreRequestType = new PayAndRestoreRequestType();
		HeaderType headerType = new HeaderType();
		headerType.setEnterpriseID(paymentRequest.getEnterpriseid());
		headerType.setMessageTrackingID(paymentRequest.getMessagetrackingid());
		payAndRestoreRequestType.setHeader(headerType);
		PayAndRestoreRequestRecordType payAndRestoreRequestRecordType = new PayAndRestoreRequestRecordType();
		payAndRestoreRequestRecordType.setBAN(paymentRequest.getAccountnumber());
		payAndRestoreRequestRecordType.setAmount(paymentRequest.getAmount());
		payAndRestoreRequestRecordType.setFeeAmount(jaxbElementFeeAmount);
		payAndRestoreRequestRecordType.setDate(xmlGregCal);
		payAndRestoreRequestRecordType.setAnnotation(paymentRequest.getAnnotation());
		payAndRestoreRequestRecordType.setTransSource(paymentRequest.getTranssource());
		payAndRestoreRequestRecordType.setTransType(paymentRequest.getTranstype());
		payAndRestoreRequestType.setRequest(payAndRestoreRequestRecordType);
		payAndRestoreRequest.setPayAndRestoreRequest(payAndRestoreRequestType);
		try {
			PayAndRestoreResponse response = sOAPConnector.callPostPaymentWebService(PaymentConstant.AC_INFO_URL,
					payAndRestoreRequest);

			LOG.info("response received from NNE PostPayment---TrackingId---"
					+ response.getPayAndRestoreOutput().getResponseRecord().getTrackingID());
			LOG.info("response received from NNE PostPayment---New pst duebalance---"
					+ response.getPayAndRestoreOutput().getResponseRecord().getNewPastDueBalance());
			postPaymentResponse.setRequestId(paymentRequest.getRequestId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return postPaymentResponse;
	}

}
