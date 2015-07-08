package com.bin.framework.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 * 
 */
public class AppResource {
	public static void main(String[] args) {
		System.out.println("Spring sample running");

		// Load beans
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		// Get beans
		SampleResource sampleResource = (SampleResource) appCtx
				.getBean("sampleResource");

		// Invoke method
		Resource resource = sampleResource.getResource();
		System.out.println("resource: = " + resource);
		
		System.out.println("Stop");

	}
}
