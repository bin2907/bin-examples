package com.bin.hibernate.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * 
 */
public class MultiDataSourceDemo {
	@SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        // Connect db1 
       Configuration configuration = new Configuration().configure(TransactionDemo.class.getResource("/hibernate.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        System.out.println( "factory1: " + factory );
        Session session = factory.openSession();

        session.close();
        factory.close();
        
        // Connect db2
        Configuration configuration2 = new Configuration().configure(TransactionDemo.class.getResource("/hibernate2.cfg.xml"));
        StandardServiceRegistryBuilder builder2 = new StandardServiceRegistryBuilder().applySettings(configuration2.getProperties());
        SessionFactory factory2 = configuration.buildSessionFactory(builder2.build());
        System.out.println( "factory2: " + factory2 );
        Session session2 = factory2.openSession();
        	
        session2.close();
        factory2.close();
        
        System.out.println( "Hibernate smaple is running" );
    }
}
