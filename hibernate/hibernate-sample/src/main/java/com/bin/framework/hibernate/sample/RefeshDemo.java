package com.bin.hibernate.sample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.hibernate.sample.entity.onetomany.User;

/**
 * Hello world!
 * 
 */
public class RefeshDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(RefeshDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = null;
        Transaction tx = null;
        User user = null;
        
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	
        	System.out.println("Select user at thread 1");
        	user = (User) session.get(User.class, 1);
        	
        	// New thread for change data with OTHER session
        	//new Thread(new ThreadDemo(sessionFactory)).run(); => DATA is saved can not see at current thread
        	
        	// New thread for change data with session THE SAME
        	// DATA is saved can see at current thread IF  use session.flush();
        	new Thread(new ThreadDemo2(session)).run(); 
        	
        	System.out.println("WAIT FOR THREAD ABOVE PROCESS FINISH");
        	Thread.sleep(5000);
        	
        	// Assume thread above process finish
        	System.out.println("After thread2 finish");
        	// session.refresh(user);// If use this method => Data at ThreadDemo2 will be not saved if do not use session.flush();
        	
        	System.out.println("Get data");
        	// Can have 2 data different depend on session.flush() and session.refresh(user)
        	System.out.println(user.getUserName());
        	
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        
        session.close();
               
        
        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}

class ThreadDemo implements Runnable{
	
	SessionFactory sessionFactory;
	
	public ThreadDemo(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void run() {
		Session session = null;
        Transaction tx = null;
        User user = null;
		session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	
        	System.out.println("Select user at thread 2");
        	user = (User) session.get(User.class, 1); 
        	System.out.println("CHANGE DATA");
        	user.setUserName("aaaaaaaaaaaaaaaaaaaaaaa");
        	
        	session.save(user);
        	
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        
        session.close();
	}
}

class ThreadDemo2 implements Runnable{
	
	Session session;
	
	public ThreadDemo2(Session session){
		this.session = session;
	}

	@Override
	public void run() {
        System.out.println("Select user at thread 2");
        User user = (User) session.get(User.class, 1); 
    	System.out.println("CHANGE DATA");
    	user.setUserName("aaaaaaaaaaaaaaaaaaaaaaa");
    	
    	session.save(user);
    	session.flush();
	}
}
