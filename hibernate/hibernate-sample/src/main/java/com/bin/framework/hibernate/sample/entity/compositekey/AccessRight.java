package com.bin.framework.hibernate.sample.entity.compositekey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "access_right")
public class AccessRight {

	@EmbeddedId
	private AccessRightPK accessRightPK;
	
	
	
}
