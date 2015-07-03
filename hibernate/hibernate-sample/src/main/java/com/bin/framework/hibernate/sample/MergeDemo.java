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
public class MergeDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(MergeDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = null;
        Transaction tx = null;
        User user = null;
        
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	
        	user = new User();
        	//user.setId(1); // UDPATE because 1 exist in database
        	user.setId(6);// Save NEW because 6 DO NOT exist in database
        	user.setPassword("aaaaaaaaaaaaaaaaaa");
        	user.setUserName("bbbbbbbbbbbbbbbbbb");
        	session.merge(user);
        	        	
        	tx.commit();
        }catch(Exception exc){
        	exc.printStackTrace();
        	tx.rollback();
        }
        
        session.close();
               
        
        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}
