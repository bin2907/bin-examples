package com.bin.framework.web.jsf.sample;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "eventBeanTest", eager = true)
@SessionScoped
public class EventBeanTest implements Serializable {

private static final long serialVersionUID = 1L;
  
   private String data = "sample data";
	
   public void handleEvent(ComponentSystemEvent event){
      data="Hello World";
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }
}