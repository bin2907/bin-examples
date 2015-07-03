package com.bin.framework.hibernate.sample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.framework.hibernate.sample.entity.onetomany.User;

/**
 * Hello world!
 * 
 */
public class SaveOrUpdateDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(SaveOrUpdateDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try{
        	
        	tx = session.beginTransaction();
        	
	        User user = new User();
	    	user.setUserName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	    	user.setPassword("bbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	    	session.saveOrUpdate(user); // Save new because do not set id
	    	
	    	// NOTE HERE we set id = 1. In this case we assume that id = 1 has existed in db already
	    	User user2 = new User();
	    	user2.setId(1); // <= NOTE HERE. Data will be updated it existed in db
	     	user2.setUserName("a2");
	     	user2.setPassword("b2");
	     	session.saveOrUpdate(user2);
	     	
	     	tx.commit();
        }catch(Exception exc){
        	exc.printStackTrace();
        	tx.rollback();
        }
        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}
