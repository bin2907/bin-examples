package com.bin.web.jsf.sample;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
	public HelloWorld() {
	}

	public String getMessage() {
		return "Hello World!";
	}
}
