package com.bin.framework.hibernate.sample.entity.jointable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="user_role",
			joinColumns={@JoinColumn(name="role_id")},
			inverseJoinColumns={@JoinColumn(name="user_id")}
			)
	private List<Role> roles;
	
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
