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
public class PersistDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(PersistDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try{
        	
        	tx = session.beginTransaction();
        	
	        User user = new User();
	        //user.setId(8); <= ERROR if set here
	    	user.setUserName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	    	user.setPassword("bbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	    	session.persist(user);
	    	
	    	System.out.println("user.getId(): " + user.getId());
	    	
	    	User user2 = (User) session.get(User.class, 1); // GET from db is OK
	    	user2.setUserName("a2");
	    	user2.setPassword("b2");
	    	session.persist(user2); // data will be update
	     	
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
