package com.model;

import javax.jws.WebMethod;

public class AddressClass {
int address_id;
	String add_line1;
public int getAddress_id() {
		return address_id;
	}
@WebMethod
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAdd_line1() {
		return add_line1;
	}
	@WebMethod
	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}

	public String getAdd_line2() {
		return add_line2;
	}
	@WebMethod
	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}
	public String getCity() {
		return city;
	}
	@WebMethod
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	@WebMethod
	public void setState(String state) {
		this.state = state;
	}
	public String getState_code() {
		return State_code;
	}
	@WebMethod
	public void setState_code(String state_code) {
		State_code = state_code;
	}
	public int getZipcode() {
		return zipcode;
	}
	@WebMethod
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((State_code == null) ? 0 : State_code.hashCode());
		result = prime * result
				+ ((add_line1 == null) ? 0 : add_line1.hashCode());
		result = prime * result
				+ ((add_line2 == null) ? 0 : add_line2.hashCode());
		result = prime * result + address_id;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + zipcode;
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
		AddressClass other = (AddressClass) obj;
		if (State_code == null) {
			if (other.State_code != null)
				return false;
		} else if (!State_code.equals(other.State_code))
			return false;
		if (add_line1 == null) {
			if (other.add_line1 != null)
				return false;
		} else if (!add_line1.equals(other.add_line1))
			return false;
		if (add_line2 == null) {
			if (other.add_line2 != null)
				return false;
		} else if (!add_line2.equals(other.add_line2))
			return false;
		if (address_id != other.address_id)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipcode != other.zipcode)
			return false;
		return true;
	}
String add_line2;
String city;
String state;
String State_code;
int zipcode;
}
