package com.customer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Customer")
@XmlType(propOrder = { "firstName", "lastName", "emailId", "phoneNo", "status",
		"type", "billingAddress", "serviceAddress", "paymentMethod" })
public class CustomerBean {
	private String firstName;
	private String lastName;
	private String emailId;
	private long phoneNo;
	private String status;
	private String type;
	private String billingAddress;
	private String serviceAddress;
	private String paymentMethod;

	// private String password;
	//
	// @XmlTransient
	// public String getPassword() {
	// return password;
	// }
	//

	// public void setPassword(String password) {
	// this.password = password;
	// }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	// @Override
	// public String toString() {
	// return "firstName = " + firstName + " lastName=" + lastName + " emailId="
	// + emailId + " phoneNo=" + phoneNo + " status=" +
	// status + " type=" + type;
	// }

}
