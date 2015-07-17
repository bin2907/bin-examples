package com.bin.web.jsf.validator.sample;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bin.web.jsf.converter.sample.MyData;

@ManagedBean(eager=true)
@SessionScoped
public class MyValidatorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private MyData myData = new MyData();

	public MyData getMyData() {
		return myData;
	}

	public void setMyData(MyData myData) {
		this.myData = myData;
	}
	
}
