package com.bin.framework.hibernate.sample;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.framework.hibernate.sample.entity.manytomany.User;

/**
 * Hello world!
 * 
 */
public class NamedQueryDemo {
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(NamedQueryDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try{
        	
        	tx = session.beginTransaction();
        	
	        Query query = session.getNamedQuery("User.FindAll"); // User.FindAll is defined in User.java
	        List<User> users = query.list();
	        
	        System.out.println("users.size(): "+users.size());
	     	
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
