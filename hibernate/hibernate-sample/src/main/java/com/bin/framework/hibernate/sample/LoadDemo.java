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
public class LoadDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(LoadDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        

        Session session = sessionFactory.openSession();
        
        User user = (User) session.load(User.class, 1);
        System.out.println(user);
        
        User user3 = (User) session.load(User.class, 10); // 10 is not exist on db => throw exception
        System.out.println(user3);
        
        
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}
