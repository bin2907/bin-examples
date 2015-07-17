package com.bin.hibernate.sample.entity.onetomany;

import java.util.Iterator;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.hibernate.EmptyInterceptor;

public class UserListener extends EmptyInterceptor{
	
	// called before commit into database
	public void preFlush(Iterator iterator) {
		System.out.println("preFlush");
	}

	// called after committed into database
	public void postFlush(Iterator iterator) {
		System.out.println("postFlush");
	}

	private void log(String method, int index) {
		System.out.println("Method: " + method);
	}

}
