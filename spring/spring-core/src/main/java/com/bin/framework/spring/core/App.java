package com.bin.framework.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Spring sample running");

		// Load beans
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		// Get beans
		SampleService sampleService = (SampleService) appCtx
				.getBean("sampleService");

		// Invoke method
		int results = sampleService.insert();
		System.out.println("Result: = " + results);
		
		System.out.println("Stop");

	}
}
