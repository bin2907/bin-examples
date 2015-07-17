package com.bin.hibernate.sample.entity.compoundkey;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	// CAN'T WORK => RUN CompoundDemo3, CompoundDemo2 => STUDY @JoinTable
	/*@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER, targetEntity=UserRole.class, mappedBy="id.role")
	private Set<Role> roles;*/
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY, mappedBy="id.user")
	private Set<UserRole> userRoles;
	
	@Transient
	private Set<Role> roles; // We can process 'userRoles' to have result to 'roles' and else
	
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
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public Set<Role> getRoles() {
		if(getUserRoles() != null){
			Iterator<UserRole> iterator = this.userRoles.iterator();
			roles = new HashSet<>();
			while(iterator.hasNext()){
				roles.add(iterator.next().getId().getRole());
			}
		}
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
		userRoles = new HashSet<>();
		Iterator<Role> iterator = this.roles.iterator();
		while(iterator.hasNext()){
			UserRole userRole = new UserRole();
			UserRolePk pk = new UserRolePk();
			pk.setUser(this);
			pk.setRole(iterator.next());
			userRole.setId(pk);
			userRoles.add(userRole);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
