package com.bin.framework.hibernate.sample.entity.filter;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * 
 */
public class CreateFilterDemo {
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(CreateFilterDemo.class.getResource("/hibernate.filter.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = sessionFactory.openSession();
        
	    try{
	    	
	    	session.beginTransaction();
	    	
	    	
	    	/**
	    	 * 
	    	 * 
	    	 * NOTE: Only work on the collection was referenced
	    	 * 
	    	 * 
	    	 * 
	    	 */
	    	
	    	
	    	Role role = (Role)session.get(Role.class, 2);
	    	List<User> users = session.createFilter(role.getUsers(), "where this.active = :activeParam").setParameter("activeParam", new Boolean(false)).list();
	    	
	    	// This is error = > The collection was unreferenced
	    	//List<User> usersQuery = session.createCriteria(User.class).list();
	    	//List<User> users = session.createFilter(usersQuery, "where this.active = :activeParam").setParameter("activeParam", new Boolean(false)).list();
	    	
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
