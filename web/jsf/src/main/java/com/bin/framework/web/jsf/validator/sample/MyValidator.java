package com.bin.framework.web.jsf.validator.sample;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.bin.framework.web.jsf.validator.sample.MyValidator")
public class MyValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent component,
			Object value) throws ValidatorException {

		try{
			Integer number = Integer.parseInt(value.toString());
			if (number.intValue() > 0) {
				FacesMessage msg = new FacesMessage("Error validation Number","Number must less than 0");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}catch(Exception exc){
			FacesMessage msg = new FacesMessage("Error validation Number","Invalid number format");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
