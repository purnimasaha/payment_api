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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NoteRequest" type="{http://www.consolidated.com/cpi}NoteRequestType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "noteRequest"
})
@XmlRootElement(name = "Note")
public class Note {

    @XmlElement(name = "NoteRequest", required = true)
    protected NoteRequestType noteRequest;

    /**
     * Gets the value of the noteRequest property.
     * 
     * @return
     *     possible object is
     *     {@link NoteRequestType }
     *     
     */
    public NoteRequestType getNoteRequest() {
        return noteRequest;
    }

    /**
     * Sets the value of the noteRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteRequestType }
     *     
     */
    public void setNoteRequest(NoteRequestType value) {
        this.noteRequest = value;
    }

}
