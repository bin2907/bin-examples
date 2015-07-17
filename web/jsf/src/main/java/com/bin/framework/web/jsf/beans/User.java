package com.bin.web.jsf.beans;

import java.net.URL;
import java.util.Date;

import com.bin.web.jsf.components.outputoject.OutputObjectAttribute;

public class User {

	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String address;
	private Date birthDate;
	private URL website;

	public User(int id, String username, String firstName, String lastName,
			String address, Date birthDate, URL website) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.website = website;
	}

	@OutputObjectAttribute(label = "User Id", order=1)
	public int getId() {
		return id;
	}

	@OutputObjectAttribute(label = "Username", order=2)
	public String getUsername() {
		return username;
	}

	@OutputObjectAttribute(label = "First Name", order=3)
	public String getFirstName() {
		return firstName;
	}

	@OutputObjectAttribute(label = "Last Name", order=4)
	public String getLastName() {
		return lastName;
	}

	@OutputObjectAttribute(label = "Address", order=5)
	public String getAddress() {
		return address;
	}

	@OutputObjectAttribute(label = "Birth Date", order=6)
	public Date getBirthDate() {
		return birthDate;
	}

	@OutputObjectAttribute(label = "Website", order=7)
	public URL getWebsite() {
		return website;
	}
}
