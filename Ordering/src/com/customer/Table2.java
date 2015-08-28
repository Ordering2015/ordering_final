package com.customer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Table2")
//@XmlType(propOrder = {"add_type", "add_line1", "add_line2", "city","state","state_code","zip_code"})
public class Table2 {
	private String add_type;
	private String add_line1;
	private String add_line2;
	private String city;
	private String state;
	private String state_code;
	private int zip_code;
	public Table2(){}
	public Table2(String add_type, String add_line1, String add_line2,
			String city, String state, String state_code, int zip_code) {
		super();
		this.add_type = add_type;
		this.add_line1 = add_line1;
		this.add_line2 = add_line2;
		this.city = city;
		this.state = state;
		this.state_code = state_code;
		this.zip_code = zip_code;
	}
	public String getAdd_type() {
		return add_type;
	}
	public void setAdd_type(String add_type) {
		this.add_type = add_type;
	}
	public String getAdd_line1() {
		return add_line1;
	}
	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}
	public String getAdd_line2() {
		return add_line2;
	}
	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	
}
