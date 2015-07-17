package com.bin.hibernate.sample.entity.tablestrategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * 
 */
public class TableStrategyDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(TableStrategyDemo.class.getResource("/hibernate.tablestrategy.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	
        	
        	User user = new User();
        	user.setUserName("aaa");
        	user.setPassword("pppp");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("a2");
        	user.setPassword("b2");
        	session.save(user);
        	
        	Address address = new Address();
        	address.setAddress("a1");
        	session.save(address);
        	
        	address = new Address();
        	address.setAddress("a2");
        	session.save(address);
        	
        	tx.commit();
        }catch(Exception exc){
        	exc.printStackTrace();
        	tx.rollback();
        }
        
        session.close();
        sessionFactory.close();
        System.out.println( "Hibernate sample stopped" );
        
    }
}
