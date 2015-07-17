package com.bin.hibernate.sample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.hibernate.sample.entity.onetomany.User;

/**
 * Hello world!
 * 
 */
public class GetEntityNameDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(GetEntityNameDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = sessionFactory.openSession();
        
        User user = (User) session.get(User.class, 1);
        
        String entityName = session.getEntityName(user); // user object must exist in db if not will throw exception
        
        System.out.println(entityName);
        
        
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}
