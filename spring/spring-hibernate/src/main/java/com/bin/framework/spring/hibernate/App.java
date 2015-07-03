package com.bin.framework.spring.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Spring sample running");

		// Load beans
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		/*LocalSessionFactoryBean sessionFactory = (LocalSessionFactoryBean)appCtx.getBean(LocalSessionFactoryBean.class);
		sessionFactory.getConfiguration().buildMapping();*/
		
		System.out.println("Stop");
    }
}
