package com.bin.framework.hibernate.sample.entity.jointable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 * 
 */
public class JoinTableDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(JoinTableDemo.class.getResource("/hibernate.jointable.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	
        	
        	
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
