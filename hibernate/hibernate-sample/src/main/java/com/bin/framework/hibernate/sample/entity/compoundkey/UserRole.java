package com.bin.hibernate.sample.entity.compoundkey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

	@Id
	private UserRolePk id;
	
	private Boolean active;

	public UserRolePk getId() {
		return id;
	}

	public void setId(UserRolePk id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
