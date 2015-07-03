package com.bin.framework.web.jsf.backingbeans;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.event.PostValidateEvent;
import javax.faces.event.PreRenderComponentEvent;
import javax.faces.event.PreValidateEvent;

import com.bin.framework.web.jsf.beans.Address;
import com.bin.framework.web.jsf.beans.User;

@ManagedBean(name = "mybean")
@RequestScoped
public class MyBean {

	private User user;
	private Address address;
	
	private Integer number;
	
	public void preRenderComponent(PreRenderComponentEvent event){
		number = 10;
	}
	
	public void postAddToView(PostAddToViewEvent event){
		number = 10;
	}
	
	public void preValidate(PreValidateEvent event){
		number = 10;
	}
	
	public void postValidate(PostValidateEvent event){
		number = 10;
	}

	public User getUser() {
		if (user == null) {
			int id = (int) (Math.random() * 1000);
			try {
				user = new User(id, "Username Of Id [" + id + "]",
						"First Name Of Id [" + id + "]", "Last Name Of Id ["
								+ id + "]",
						"This is the full address of the user", new Date(),
						new URL("http://www.adevedo.com"));
			} catch (MalformedURLException e) {

			}
		}
		return user;
	}

	public Address getAddress() {
		if (address == null) {
			address = new Address((int) (Math.random() * 100),
					(int) (Math.random() * 100), "this is the street address",
					"Cairo");
		}
		return address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
