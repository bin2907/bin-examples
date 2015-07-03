package com.bin.framework.web.jsf.error.handler;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "errorBean")
public class ErrorBean {

	@SuppressWarnings("unused")
	public String errorTest() {

		try{
			Integer intnumber = Integer.valueOf("345s");
		}catch(Exception e){
			handleException(e);
		}

		return "";
	}

	public void handleException(Throwable exception) {
		FacesMessage facesMessage = new FacesMessage(exception.getMessage());
		FacesContext.getCurrentInstance().addMessage(null,  facesMessage);
	}

}
