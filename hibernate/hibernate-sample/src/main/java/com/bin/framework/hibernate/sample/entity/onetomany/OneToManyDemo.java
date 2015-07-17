package com.bin.hibernate.sample.entity.onetomany;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * 
 */
public class OneToManyDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(OneToManyDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        
        // Get Role from User
        System.out.println("\nGet Role from User");
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select o from " + User.class.getName() + " o where o.id = 1");
        User user = (User) query.uniqueResult();
        System.out.println(user.getRole().getName());        
        session.close();
        
        System.out.println("");
        
        // Get Users from Role
        System.out.println("\nGet Users from Role");
        session = sessionFactory.openSession();
        query = session.createQuery("select o from " + Role.class.getName() + " o where o.id = 1");
        Role role = (Role) query.uniqueResult();
        List<User> users = role.getUsers();
        for(User u : users){
        	System.out.println(u.getUserName());
        }
        session.close();
        
        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}
