package com.model;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@WebService

@XmlRootElement(name = "Table1")
@XmlType(propOrder = {"customer_id", "service_id", "product_id", "product_desc","product_quantity","order_negotiation_date","order_type","order_due_date"})

public class XmlModel {
	int customer_id;
	String service_id;
	String product_id;
	String product_desc;
	int product_quantity;

	String order_negotiation_date;
	String order_type;
	 String order_due_date;
  public String getService_id() {
		return service_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	

  @WebMethod
public void setService_id(String service_id) {
	this.service_id = service_id;
}
  @WebMethod
public void setProduct_id(String product_id) {
	this.product_id = product_id;
}
  @WebMethod
public void setProduct_desc(String product_desc) {
	this.product_desc = product_desc;
}
 

  
public int getProduct_quantity() {
	return product_quantity;
}
@WebMethod
public void setProduct_quantity(int product_quantity) {
	this.product_quantity = product_quantity;
}
public int getCustomer_id() {
	return customer_id;
}
@WebMethod
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}

public String getOrder_negotiation_date() {
	return order_negotiation_date;
}
@WebMethod
public void setOrder_negotiation_date(String order_negotiation_date) {
	this.order_negotiation_date = order_negotiation_date;
}
public String getOrder_due_date() {
	return order_due_date;
}
@WebMethod
public void setOrder_due_date(String order_due_date) {
	this.order_due_date = order_due_date;
}
public String getOrder_type() {
	return order_type;
}
@WebMethod
public void setOrder_type(String order_type) {
	this.order_type = order_type;
}  
  

}
