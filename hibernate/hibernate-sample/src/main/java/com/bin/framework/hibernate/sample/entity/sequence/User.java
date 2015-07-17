package com.bin.hibernate.sample.entity.sequence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hs_user")
public class User {

	@Id
	@Column(name = "id")
	
	// If user SEQUENCE strategy then must check database support or NOT
	// PostgreSQL support this
	// Hibernate auto create sequence with name is 'hibernate_sequence'
	// NOTE: Becareful when use 'hibernate_sequence' for more than one entity. It should be used separated.
	// Statement to create: CREATE SEQUENCE address_sequence START WITH 1 INCREMENT BY 1;
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(
		    name="user_seq",
		    sequenceName="hibernate_sequence",
		    initialValue=1,
		    allocationSize=1
		)
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
