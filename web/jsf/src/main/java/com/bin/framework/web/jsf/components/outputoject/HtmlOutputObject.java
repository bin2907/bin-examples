package com.bin.framework.web.jsf.components.outputoject;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent("outputObject")
public class HtmlOutputObject extends UIOutput {
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		Object object = getAttributes().get("value");
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement("div", null);
		responseWriter.startElement("table", null);
		responseWriter.writeAttribute("border", "1", "border");
		responseWriter.writeAttribute("cellpadding", "5px", "cellpadding");
		HashMap<Integer, Method> methods = new HashMap<Integer, Method>();
		for (Method method : object.getClass().getDeclaredMethods()) {
			if (method.isAnnotationPresent(OutputObjectAttribute.class)) {
				OutputObjectAttribute objectAttribute = method
						.getAnnotation(OutputObjectAttribute.class);
				methods.put(objectAttribute.order(), method);
			}
		}
		for (int i = 1; i <= methods.size(); ++i) {
			Method method = methods.get(i);
			if (method.isAnnotationPresent(OutputObjectAttribute.class)) {
				printObjectAttribute(object, responseWriter, method);
			}
		}
		responseWriter.endElement("table");
		responseWriter.endElement("div");
	}

	private void printObjectAttribute(Object object,
			ResponseWriter responseWriter, Method method) throws IOException {
		responseWriter.startElement("tr", null);
		responseWriter.startElement("td", null);
		OutputObjectAttribute objectAttribute = method
				.getAnnotation(OutputObjectAttribute.class);
		responseWriter.startElement("label", null);
		responseWriter.write(objectAttribute.label());
		responseWriter.endElement("label");
		responseWriter.endElement("td");
		responseWriter.startElement("td", null);
		printObjectAttributeValue(responseWriter, object, method);
		responseWriter.endElement("td");
		responseWriter.endElement("tr");
	}

	private void printObjectAttributeValue(ResponseWriter responseWriter,
			Object object, Method method) throws IOException {
		Object value = null;
		try {
			value = method.invoke(object, new Object[] {});
		} catch (Exception e) {
			value = "Exception Thrown";
		}
		if (value instanceof URL) {
			responseWriter.startElement("a", null);
			responseWriter.writeAttribute("href", value.toString(), "href");
			responseWriter.write(value.toString());
			responseWriter.endElement("a");
		} else
			responseWriter.write(value.toString());
	}
}
