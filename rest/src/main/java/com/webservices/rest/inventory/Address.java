package com.webservices.rest.inventory;

import javax.xml.bind.annotation.XmlElement;

public class Address {

	@XmlElement(name="PC_PARTS_STREET")
	public String street;
	@XmlElement(name="PC_PARTS_CITY")
	public String city;
	@XmlElement(name="PC_PARTS_ZIP")
	public String zip;
	
	public Address(){
		super();
	}
	
	public Address(String street, String city, String zip) {
		
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
