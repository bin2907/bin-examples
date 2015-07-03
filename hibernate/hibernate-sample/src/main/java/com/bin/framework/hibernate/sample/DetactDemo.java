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
public class DetactDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(DetactDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = null;
        Transaction tx = null;
        User user = null;
        
        // CASE 1
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	
        	user = (User) session.get(User.class, 1);
        	user.setUserName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");// THIS will update down database
        	
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        
        session.close();
        
        
        // CASE 2
        session = sessionFactory.openSession();
        user = (User) session.get(User.class, 2);
    	user.setUserName("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");// THIS will NOT update down database
        session.close();
        
        
        // CASE 3
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	
        	user = (User) session.get(User.class, 2);
        	user.setUserName("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");// THIS will NOT update down database BECAUSE 'evict' method below
        	
        	session.evict(user);// Detact object out session
        	
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        
        
        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}
