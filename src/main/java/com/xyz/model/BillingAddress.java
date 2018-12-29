package com.xyz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillingAddress {
	
	@Id
	private String billingaddressid;
	private String houseno;
	private String street;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;
	public String getBillingaddressid() {
		return billingaddressid;
	}
	public void setBillingaddressid(String billingaddressid) {
		this.billingaddressid = billingaddressid;
	}
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}