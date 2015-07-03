package com.bin.framework.hibernate.sample.entity.tablestrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.TABLE,generator="AppUserIdTable")
	@TableGenerator(table = "ID_TABLE", name = "AppUserIdTable", 
					allocationSize = 1, initialValue = 1, pkColumnName = "pk", 
					valueColumnName = "value", pkColumnValue = "app_address")
	private int id;
	
	private String address;
	
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
	
}
