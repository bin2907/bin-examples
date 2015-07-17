package com.bin.web.jsf.converter.sample;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(eager=true)
@SessionScoped
public class MyConverterBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private MyData myData;

	public MyData getMyData() {
		return myData;
	}

	public void setMyData(MyData myData) {
		this.myData = myData;
	}
	
}
