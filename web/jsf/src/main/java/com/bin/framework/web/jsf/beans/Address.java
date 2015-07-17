package com.bin.web.jsf.beans;

import com.bin.web.jsf.components.outputoject.OutputObjectAttribute;

public class Address {

	private int flatNo;
	private int buildingNo;
	private String address;
	private String city;

	public Address(int flatNo, int buildingNo, String address, String city) {
		this.flatNo = flatNo;
		this.buildingNo = buildingNo;
		this.address = address;
		this.city = city;
	}

	@OutputObjectAttribute(label = "Flat No.", order = 1)
	public int getFlatNo() {
		return flatNo;
	}

	@OutputObjectAttribute(label = "Building No.", order = 2)
	public int getBuildingNo() {
		return buildingNo;
	}

	@OutputObjectAttribute(label = "Street Address", order = 3)
	public String getAddress() {
		return address;
	}

	@OutputObjectAttribute(label = "City", order = 4)
	public String getCity() {
		return city;
	}
}
