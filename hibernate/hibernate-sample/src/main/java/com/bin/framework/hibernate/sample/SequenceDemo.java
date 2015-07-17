package com.bin.hibernate.sample;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.hibernate.sample.entity.sequence.Address;
import com.bin.hibernate.sample.entity.sequence.User;

/**
 * Hello world!
 * 
 */
public class SequenceDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(SequenceDemo.class.getResource("/hibernate.sequence.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	
        	User user = new User();
        	user.setUserName("aaa");
        	user.setPassword("pppp");
        	Serializable serializable = session.save(user);
        	System.out.println("serializable: " + serializable);
        	
        	user = new User();
        	user.setUserName("bbb");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb3");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb4");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb5");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb6");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb7");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb8");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb9");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb10");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("bbb11");
        	user.setPassword("vvv");
        	session.save(user);
        	
        	Address address = new Address();
        	address.setAddress("address");
        	address.setUser(user);
        	session.save(address);
        	
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        
        session.close();
        sessionFactory.close();
        System.out.println( "Hibernate sample stopped" );
        
    }
}
