package com.customer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Table1")
//@XmlType(propOrder = {"customer_fname", "customer_lname", "customer_email_id", "customer_mobile_no","customer_status","customer_type","customer_Bill_pay"})*/
public class Table1 {
	private String customer_fname;
	private String customer_lname;
	private String customer_email_id;
	private long customer_mobile_no;
	private String customer_status;
	private String customer_type;
	private String customer_Bill_pay;
	public Table1(){}
 
 	public Table1(String customer_fname, String customer_lname,
			String customer_email_id, long customer_mobile_no,
			String customer_status, String customer_type,
			String customer_Bill_pay) {
		super();
		this.customer_fname = customer_fname;
		this.customer_lname = customer_lname;
		this.customer_email_id = customer_email_id;
		this.customer_mobile_no = customer_mobile_no;
		this.customer_status = customer_status;
		this.customer_type = customer_type;
		this.customer_Bill_pay = customer_Bill_pay;
	}
	public String getCustomer_fname() {
		return customer_fname;
	}
	public void setCustomer_fname(String customer_fname) {
		this.customer_fname = customer_fname;
	}
	public String getCustomer_lname() {
		return customer_lname;
	}
	public void setCustomer_lname(String customer_lname) {
		this.customer_lname = customer_lname;
	}
	public String getCustomer_email_id() {
		return customer_email_id;
	}
	public void setCustomer_email_id(String customer_email_id) {
		this.customer_email_id = customer_email_id;
	}
	public long getCustomer_mobile_no() {
		return customer_mobile_no;
	}
	public void setCustomer_mobile_no(long customer_mobile_no) {
		this.customer_mobile_no = customer_mobile_no;
	}
	public String getCustomer_status() {
		return customer_status;
	}
	public void setCustomer_status(String customer_status) {
		this.customer_status = customer_status;
	}
	public String getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}
	public String getCustomer_Bill_pay() {
		return customer_Bill_pay;
	}
	public void setCustomer_Bill_pay(String customer_Bill_pay) {
		this.customer_Bill_pay = customer_Bill_pay;
	}
	}
