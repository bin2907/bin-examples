package com.bin.hibernate.sample.entity.onetomany;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * 
 */
public class OneToManyInsertDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(OneToManyInsertDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        
        
        Session session = null;
        Transaction tx = null;
        User user = null;
        Role role = null;
        
        // Insert User
        System.out.println("\nInsert User");
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	user = new User();
        	user.setId(5);
        	user.setUserName("boo");
        	user.setPassword("boo");
        	user.setRole(role);// Role must be loaded from session
        	session.save(user);
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        session.close();
        
        
        // Insert Role and users
        System.out.println("\nInsert Role and users");
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	role = new Role();
        	role.setId(3);
        	role.setName("Supper");
        	
        	User u1 = new User();
        	u1.setUserName("Supper User 1");
        	u1.setPassword("Supper User 1");
        	u1.setRole(role);
        	
        	User u2 = new User();
        	u2.setUserName("Supper User 2");
        	u2.setPassword("Supper User 2");
        	u2.setRole(role);
        	
        	List<User> list = new ArrayList<>();
        	list.add(u1);
        	list.add(u2);
        	
        	// set list of users
        	role.setUsers(list);
        	
        	session.save(role);
        	
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
