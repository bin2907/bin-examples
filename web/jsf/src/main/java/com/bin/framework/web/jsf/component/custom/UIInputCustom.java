package com.bin.framework.web.jsf.component.custom;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(value = "com.bin.jsf2.component.custom.UIInputCustom", createTag = true)
public class UIInputCustom extends UIInput {
 
    @Override
    public String getFamily() {        
        return "my.custom.uiinput";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
 
        String value = (String) getAttributes().get("value");
 
        if (value != null) {        
            ResponseWriter writer = context.getResponseWriter();
            writer.write(value.toUpperCase());
        }
    }
}