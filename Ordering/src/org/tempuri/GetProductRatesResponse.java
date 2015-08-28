
package org.tempuri;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetProductRatesResult" type="{http://tempuri.org/}ArrayOfProductRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getProductRatesResult"
})
@XmlRootElement(name = "GetProductRatesResponse")
public class GetProductRatesResponse {

    @XmlElement(name = "GetProductRatesResult")
    protected ArrayOfProductRate getProductRatesResult;

    /**
     * Gets the value of the getProductRatesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProductRate }
     *     
     */
    public ArrayOfProductRate getGetProductRatesResult() {
        return getProductRatesResult;
    }

    /**
     * Sets the value of the getProductRatesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProductRate }
     *     
     */
    public void setGetProductRatesResult(ArrayOfProductRate value) {
        this.getProductRatesResult = value;
    }

}
