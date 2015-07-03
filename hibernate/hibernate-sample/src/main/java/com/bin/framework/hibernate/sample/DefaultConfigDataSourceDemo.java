package com.bin.framework.hibernate.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 * 
 */
public class DefaultConfigDataSourceDemo {
	@SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        // Annotation
        // Default will be hibernate.cfg.xml if not we can specify App.class.getResource("/hibernate.cfg.xml") param
        Configuration configuration = new AnnotationConfiguration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        
        session.close();
        
        System.out.println( "Hibernate smaple is running" );
    }
}
