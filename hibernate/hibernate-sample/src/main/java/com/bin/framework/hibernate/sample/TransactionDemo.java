package com.bin.hibernate.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.hibernate.sample.entity.User;

/**
 * Hello world!
 * 
 */
public class TransactionDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        User user = new User();
        user.setPassword("a1");
        user.setUserName("a1");
        
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	Integer id = (Integer) session.save(user); 
        	System.out.println("Insert user: id = " + id);
        	
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        
        session.close();
        sessionFactory.close();
        System.out.println( "Hibernate sample stopped" );
        
    }
}
