package com.webservices.rest.inventory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PcPartsResponse {

	
	public String PC_PARTS_PK;
	public String PC_PARTS_TITLE;
	public String PC_PARTS_CODE;
	public String PC_PARTS_MAKER;
	public String PC_PARTS_AVAIL;
	public String PC_PARTS_DESC;
	//public Address address;
	
	@XmlElement(name="PC_PARTS_ADDRESS")
	public Address address;
	
	public PcPartsResponse(){
		super();
	}
	
	public PcPartsResponse(String PC_PARTS_PK, String PC_PARTS_TITLE, String PC_PARTS_CODE, String PC_PARTS_MAKER,
			String PC_PARTS_AVAIL, String PC_PARTS_DESC ,Address address) {
	
		this.PC_PARTS_PK = PC_PARTS_PK;
		this.PC_PARTS_TITLE = PC_PARTS_TITLE;
		this.PC_PARTS_CODE = PC_PARTS_TITLE;
		this.PC_PARTS_MAKER = PC_PARTS_MAKER;
		this.PC_PARTS_AVAIL = PC_PARTS_AVAIL;
		this.PC_PARTS_DESC = PC_PARTS_DESC;
		this.address = address;
		
		
	}
	
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
		/*address.setCity(city);
		address.setStreet(street);
		address.setZip(zip);*/
		//this.address=address;
		
	}
	
	public String getPC_PARTS_PK() {
		return PC_PARTS_PK;
	}
	public void setPC_PARTS_PK(String pC_PARTS_PK) {
		PC_PARTS_PK = pC_PARTS_PK;
	}
	public String getPC_PARTS_TITLE() {
		return PC_PARTS_TITLE;
	}
	public void setPC_PARTS_TITLE(String pC_PARTS_TITLE) {
		PC_PARTS_TITLE = pC_PARTS_TITLE;
	}
	public String getPC_PARTS_CODE() {
		return PC_PARTS_CODE;
	}
	public void setPC_PARTS_CODE(String pC_PARTS_CODE) {
		PC_PARTS_CODE = pC_PARTS_CODE;
	}
	public String getPC_PARTS_MAKER() {
		return PC_PARTS_MAKER;
	}
	public void setPC_PARTS_MAKER(String pC_PARTS_MAKER) {
		PC_PARTS_MAKER = pC_PARTS_MAKER;
	}
	public String getPC_PARTS_AVAIL() {
		return PC_PARTS_AVAIL;
	}
	public void setPC_PARTS_AVAIL(String pC_PARTS_AVAIL) {
		PC_PARTS_AVAIL = pC_PARTS_AVAIL;
	}
	public String getPC_PARTS_DESC() {
		return PC_PARTS_DESC;
	}
	public void setPC_PARTS_DESC(String pC_PARTS_DESC) {
		PC_PARTS_DESC = pC_PARTS_DESC;
	}
	
	
	
	public String toString() {
		return PC_PARTS_PK + PC_PARTS_TITLE + PC_PARTS_CODE +PC_PARTS_MAKER + PC_PARTS_AVAIL + PC_PARTS_DESC + address.city + address.street + address.zip;
	}
	
	
	
}
