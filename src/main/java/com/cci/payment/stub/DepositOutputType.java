//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.17 at 12:55:15 PM IST 
//


package com.cci.payment.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DepositOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DepositOutputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Header" type="{http://www.consolidated.com/cpi}HeaderType"/&gt;
 *         &lt;element name="ResponseRecord" type="{http://www.consolidated.com/cpi}DepositResponseRecordType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositOutputType", propOrder = {
    "header",
    "responseRecord"
})
public class DepositOutputType {

    @XmlElement(name = "Header", required = true)
    protected HeaderType header;
    @XmlElement(name = "ResponseRecord", required = true)
    protected DepositResponseRecordType responseRecord;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType }
     *     
     */
    public HeaderType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType }
     *     
     */
    public void setHeader(HeaderType value) {
        this.header = value;
    }

    /**
     * Gets the value of the responseRecord property.
     * 
     * @return
     *     possible object is
     *     {@link DepositResponseRecordType }
     *     
     */
    public DepositResponseRecordType getResponseRecord() {
        return responseRecord;
    }

    /**
     * Sets the value of the responseRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepositResponseRecordType }
     *     
     */
    public void setResponseRecord(DepositResponseRecordType value) {
        this.responseRecord = value;
    }

}
