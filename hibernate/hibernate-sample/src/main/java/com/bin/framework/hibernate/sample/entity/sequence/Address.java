package com.bin.framework.hibernate.sample.entity.sequence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "id")
	//Statement to create: CREATE SEQUENCE address_sequence START WITH 1 INCREMENT BY 1;
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
	@SequenceGenerator(
		    name="address_seq",
		    sequenceName="address_sequence",
		    initialValue=1,
		    allocationSize=1
		)
	private int id;
	
	@Column(name = "address")
	private String address;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
