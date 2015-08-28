package com.model;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public class ProductClass {

	int product_id;
	int service_id;

	public int getProduct_id() {
		return product_id;
	}
	@WebMethod
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getService_id() {
		return service_id;
	}
	@WebMethod
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + product_id;
		result = prime * result + service_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductClass other = (ProductClass) obj;
		if (product_id != other.product_id)
			return false;
		if (service_id != other.service_id)
			return false;
		return true;
	}
	
	
	
}
