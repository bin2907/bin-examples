package com.bin.framework.hibernate.sample.entity.embeddedid;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

	@EmbeddedId // HERE can not use @Id because do not mark @Embeddable at UserRolePk
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
