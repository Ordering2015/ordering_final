package com.customer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Table3")
// @XmlType(propOrder = {"product_id", "product_name","product_qty",
// "product_description","product_start_date","product_end_date",
// "order_negotiation_date","order_due_date","order_status","order_type","service_id","service_name","service_end_date"})
public class Table3 {
	private String product_id;
	private String product_name;
	private String product_qty;
	private String product_description;
	private String product_start_date;
	private String product_end_date;
	private String order_negotiation_date;
	private String order_due_date;
	private String order_status;
	private String order_type;
	private String service_id;
	private String service_name;
	private String service_end_date;

	public Table3(){}
	public Table3(String product_id, String product_name, String product_qty,
			String product_description, String product_start_date,
			String product_end_date, String order_negotiation_date,
			String order_due_date, String order_status, String order_type,
			String service_id, String service_name, String service_end_date) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_qty = product_qty;
		this.product_description = product_description;
		this.product_start_date = product_start_date;
		this.product_end_date = product_end_date;
		this.order_negotiation_date = order_negotiation_date;
		this.order_due_date = order_due_date;
		this.order_status = order_status;
		this.order_type = order_type;
		this.service_id = service_id;
		this.service_name = service_name;
		this.service_end_date = service_end_date;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getOrder_negotiation_date() {
		return order_negotiation_date;
	}

	public void setOrder_negotiation_date(String order_negotiation_date) {
		this.order_negotiation_date = order_negotiation_date;
	}

	public String getOrder_due_date() {
		return order_due_date;
	}

	public void setOrder_due_date(String order_due_date) {
		this.order_due_date = order_due_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getProduct_qty() {
		return product_qty;
	}

	public void setProduct_qty(String product_qty) {
		this.product_qty = product_qty;
	}

	public String getProduct_start_date() {
		return product_start_date;
	}

	public void setProduct_start_date(String product_start_date) {
		this.product_start_date = product_start_date;
	}

	public String getProduct_end_date() {
		return product_end_date;
	}

	public void setProduct_end_date(String product_end_date) {
		this.product_end_date = product_end_date;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getService_end_date() {
		return service_end_date;
	}

	public void setService_end_date(String service_end_date) {
		this.service_end_date = service_end_date;
	}

}
