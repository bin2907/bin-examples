package com.bin.hibernate.sample.entity.tablestrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "hs_user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE,generator="AppUserIdTable")
	@TableGenerator(table = "ID_TABLE", name = "AppUserIdTable", 
					allocationSize = 1, initialValue = 1, pkColumnName = "pk", 
					valueColumnName = "value", pkColumnValue = "app_user")
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
