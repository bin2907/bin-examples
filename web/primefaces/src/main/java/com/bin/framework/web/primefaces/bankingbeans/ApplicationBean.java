package com.bin.framework.web.primefaces.bankingbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean(eager=true)
public class ApplicationBean {

	private String test;
	
	@PostConstruct
	public void init(){
		test = "This is test in application bean";
		System.out.println("ApplicationBean init");
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
