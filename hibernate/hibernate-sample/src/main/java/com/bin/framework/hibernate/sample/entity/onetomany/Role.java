package com.bin.hibernate.sample.entity.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	/*
	 * Cascade=CascadeType.REMOVE => is a database-specific thing. It deletes
	 * the "child" row in the database when the "parent" row is deleted.
	 * If there are any references to "parent" => "children" can not delete
	 * if delete "parent"
	 * 
	 * orphanRemoval=true => is an entirely ORM-specific thing. It marks "child"
	 * entity to be removed when it's no longer referenced from the "parent"
	 * entity. It is (delete, update, or nothing) => Transaction is committed
	 */
	@OneToMany(mappedBy="role", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
