package com.bin.web.jsf.component.custom;

import java.io.IOException;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class HelloWorldComponent extends UIComponentBase {
	public String getFamily() {
		return "HELLO_WORLD_FAMILY";
	}

	@Override
	public void encodeBegin(FacesContext ctx) throws IOException {
		System.out.println("HelloWorldComponent: encodeBegin");
		ResponseWriter responseWriter = ctx.getResponseWriter();
		String helloworld = (String) getAttributes().get("helloworld");
		responseWriter.startElement("b", this);
		if (helloworld != null) {
			responseWriter.writeText(helloworld, "helloworld");
		} else {
			responseWriter.writeText(
					"This is a simple Hello World JSF custom component!", null);
		}
		responseWriter.endElement("b");
	}
}
