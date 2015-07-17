package com.bin.web.jsf.converter.sample;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.bin.web.jsf.converter.sample.MyConverter")
public class MyConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		try{
			MyData myData = new MyData();
			myData.setNumber(Integer.parseInt(value));
			return myData;
		}catch(NumberFormatException exc){
			FacesMessage msg = new FacesMessage("Error converting Number","Invalid number format");
		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		         throw new ConverterException(msg);
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		return value.toString();
	}

	
	
}
