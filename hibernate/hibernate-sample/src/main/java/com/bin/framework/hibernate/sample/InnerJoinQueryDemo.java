package com.bin.framework.hibernate.sample;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.framework.hibernate.sample.entity.onetomany.Role;
import com.bin.framework.hibernate.sample.entity.onetomany.User;

/**
 * Hello world!
 * 
 */
public class InnerJoinQueryDemo {
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(InnerJoinQueryDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        
        
        // Query On List
        System.out.println("\nQuery On List");
        Session session = sessionFactory.openSession();
		String hsql = "select o from " + Role.class.getName() + " o, "
				+ User.class.getName()
				+ " u where o.id = u.role.id and u.id = 1";
        Query query = session.createQuery(hsql);
        List<Role> roles = query.list();
        for(Role r : roles){
        	System.out.println(r.getName());
        }
        
        session.close();
        

        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
        
    }
}
