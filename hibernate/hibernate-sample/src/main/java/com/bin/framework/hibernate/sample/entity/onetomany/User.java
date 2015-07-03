package com.bin.framework.hibernate.sample.entity.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
	name = "User.FindAll",
	query = "from User u"
	)
})
@Entity
@Table(name = "user")
@EntityListeners({UserListener.class})
public class User {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id", nullable=true)
	private Role role;
	
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@PostLoad
	public void postLoad() {
		log("postLoad", 0);
	}

	@PrePersist
	public void prePersist() {
		log("prePersist", 1);
	}

	@PostPersist
	public void postPersist() {
		log("postPersist", 2);
	}

	@PreUpdate
	public void preUpdate() {
		log("preUpdate", 3);
	}

	@PostUpdate
	public void postUpdate() {
		log("postUpdate", 4);
	}

	@PreRemove
	public void preRemove() {
		log("preRemove", 5);
	}

	@PostRemove
	public void postRemove() {
		log("postRemove", 6);
	}
	private void log(String method, int index) {
		System.out.println("Method: " + method);
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
