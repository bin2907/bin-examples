package com.bin.framework.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class AppPropertyPlaceholderConfigurer {
	public static void main(String[] args) {
		System.out.println("Spring sample running");

		// Load beans
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		// Get beans
		Config config = (Config) appCtx
				.getBean("config");

		// Invoke method
		System.out.println( config.getName() );
		System.out.println( config.getVersion() );
		
		System.out.println("Stop");

	}
}
