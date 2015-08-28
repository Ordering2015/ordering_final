
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
 *         &lt;element name="GetProductsByServiceIDResult" type="{http://tempuri.org/}ArrayOfProductClass" minOccurs="0"/>
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
    "getProductsByServiceIDResult"
})
@XmlRootElement(name = "GetProductsByServiceIDResponse")
public class GetProductsByServiceIDResponse {

    @XmlElement(name = "GetProductsByServiceIDResult")
    protected ArrayOfProductClass getProductsByServiceIDResult;

    /**
     * Gets the value of the getProductsByServiceIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProductClass }
     *     
     */
    public ArrayOfProductClass getGetProductsByServiceIDResult() {
        return getProductsByServiceIDResult;
    }

    /**
     * Sets the value of the getProductsByServiceIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProductClass }
     *     
     */
    public void setGetProductsByServiceIDResult(ArrayOfProductClass value) {
        this.getProductsByServiceIDResult = value;
    }

}
