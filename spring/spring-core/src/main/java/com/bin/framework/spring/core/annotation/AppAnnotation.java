package com.bin.framework.spring.core.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class AppAnnotation {
	public static void main(String[] args) {
		System.out.println("Spring sample running");

		// Load beans
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		// Get beans
		SampleAnnotationService sampleAnnotationService = (SampleAnnotationService) appCtx
				.getBean("sampleAnnotationService");

		// Invoke method
		int results = sampleAnnotationService.delete();
		System.out.println("Result: = " + results);
		
		System.out.println("Stop");

	}
}
