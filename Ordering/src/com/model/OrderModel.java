package com.model;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class OrderModel {

	 String status;

	public String getStatus() {
		return status;
	}
	@WebMethod
	public void setStatus(String status) {
		this.status = status;
	}

	
}
