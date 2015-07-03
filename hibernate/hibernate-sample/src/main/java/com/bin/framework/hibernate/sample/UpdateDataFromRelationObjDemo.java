package com.bin.framework.hibernate.sample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.framework.hibernate.sample.entity.onetomany.Role;

/**
 * Hello world!
 * 
 */
public class UpdateDataFromRelationObjDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(UpdateDataFromRelationObjDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        
        
        Session session = null;
        Transaction tx = null;
        Role role = null;
        
        // Insert Role and users
        System.out.println("\nInsert Role and users");
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	role = (Role) session.load(Role.class, 1);
        	role.setName("rename");
        	
        	role.getUsers().get(0).setUserName("rename");
        	
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
