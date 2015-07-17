package com.bin.hibernate.sample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.hibernate.sample.entity.onetoone.Role;
import com.bin.hibernate.sample.entity.onetoone.User;

/**
 * Hello world!
 * 
 */
public class SaveRefObjBeforeDemo {
	/**
	 * @param args
	 */
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(SaveRefObjBeforeDemo.class.getResource("/hibernate.one.to.one.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        
        Session session = null;
        
        // Insert User
        System.out.println("\nInsert User");
        session = sessionFactory.openSession();
        User user = new User();
        user.setPassword("user1");
        user.setUserName("user1");
        
        Role role = new Role();
        role.setName("role1");
        
        
        // "cascade=CascadeType.ALL" is different with "cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE}"
        // "cascade=CascadeType.ALL" => save the transient instance (object references) before. HERE is "role" instance
        
        // Save role before if we don't use cascade=CascadeType.ALL
        //session.save(role);
        
        user.setRole(role);
         
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	session.save(user);
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        session.flush(); // NOTE this
        session.close();
        

        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
        
    }
}
