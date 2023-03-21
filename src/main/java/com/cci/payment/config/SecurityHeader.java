package com.cci.payment.config;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;

import com.cci.payment.model.UsernameToken;

import om.cci.payment.constant.PaymentConstant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import java.io.IOException;

public class SecurityHeader implements WebServiceMessageCallback {

    private UsernameToken usernameToken;
    
    String userName = PaymentConstant.AC_INFO_USERNAME;
    String password = PaymentConstant.AC_INFO_PASSWORD;

    public SecurityHeader(UsernameToken usernameToken) {
        this.usernameToken = usernameToken;
    }

   /* @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
        SoapHeader soapHeader = ((SoapMessage)message).getSoapHeader();

        try {
            JAXBContext context = JAXBContext.newInstance(UsernameToken.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(usernameToken, soapHeader.getResult());

        } catch (JAXBException e) {
            throw new IOException("error while marshalling authentication.");
        }
    }*/
    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException{
        try {
            SoapMessage soapMessage = (SoapMessage)message;
            SoapHeader header = soapMessage.getSoapHeader();
            StringSource headerSource = new StringSource("<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">;   \r\n" + 
            		"         <wsse:UsernameToken>   \r\n" + 
            		"            <wsse:Username>"+userName+"</wsse:Username>    \r\n" + 
            		"            <wsse:Password>"+password+"</wsse:Password>  \r\n" + 
            		"         </wsse:UsernameToken>  \r\n" + 
            		"      </wsse:Security> ");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(headerSource, header.getResult());
        } catch (Exception e) {
            // exception handling
        }
    }
}