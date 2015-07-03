package com.bin.framework.web.jsf.components.outputoject;

@java.lang.annotation.Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value={java.lang.annotation.ElementType.METHOD})
public @interface OutputObjectAttribute {
	String label();
	int order();
}
