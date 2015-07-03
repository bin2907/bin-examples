package com.bin.framework.hibernate.sample.entity.filter;


import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * 
 */
public class FilterDemo {
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(FilterDemo.class.getResource("/hibernate.filter.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = sessionFactory.openSession();
        
	    try{
	    	
	    	Filter filter = session.enableFilter("activeFilter");
	    	filter.setParameter("activeParam", new Boolean(true));
	    	
	    	session.beginTransaction();
	    	
	    	Query query = session.createQuery("select o from User o");
	    	List<User> users = query.list();
	    	for ( User user : users )
	    	{
	    		System.out.println(user.getActive());
	    	}
	    	
	    	
	    	session.getTransaction().commit();
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	session.disableFilter("activeFilter");
	    	session.beginTransaction();
	    	
	    	query = session.createQuery("select o from User o");
	    	users = query.list();
	    	for ( User user : users )
	    	{
	    		System.out.println(user.getActive());
	    	}
	    	
	    	
	    	session.getTransaction().commit();
	    	
	    	
	    	
	    	
	    	

	    	session.enableFilter("activeFilter").setParameter("activeParam", new Boolean(false));
	    	session.beginTransaction();
	    	
	    	query = session.createQuery("select o from User o");
	    	users = query.list();
	    	for ( User user : users )
	    	{
	    		System.out.println(user.getActive());
	    	}
	    	
	    	
	    	session.getTransaction().commit();
	    	
	    	
	    }catch(Exception exc){
	    	exc.printStackTrace();
	    	session.getTransaction().rollback();
	    }
        
	    session.close();
	    
	    
	    
	    
	    
	    
	    
	    session = sessionFactory.openSession();
        
	    try{
	    	
	    	session.beginTransaction();
	    	
	    	Query query = session.createQuery("select o from User o");
	    	List<User> users = query.list();
	    	for ( User user : users )
	    	{
	    		System.out.println(user.getActive());
	    	}
	    	
	    	session.getTransaction().commit();
	    	
	    }catch(Exception exc){
	    	exc.printStackTrace();
	    	session.getTransaction().rollback();
	    }
	    session.close();
        
        
	    
	    
        sessionFactory.close();
        
        
        System.out.println( "Hibernate sample stopped" );
    }
}
