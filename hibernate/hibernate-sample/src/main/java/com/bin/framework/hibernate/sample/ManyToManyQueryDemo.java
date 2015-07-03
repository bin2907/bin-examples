package com.bin.framework.hibernate.sample;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.framework.hibernate.sample.entity.manytomany.User;

/**
 * Hello world!
 * 
 */
public class ManyToManyQueryDemo {
	@SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(ManyToManyQueryDemo.class.getResource("/hibernate.many.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	
			
        	Query query = session.createQuery("select o from " + User.class.getName() + " o left join o.roles r where r.id in (1,2)");
        	System.out.println(query.getQueryString());
        	List<User> users = (List<User>)query.list();
        	for(User user : users){
        		System.out.println(user.getUserName());
        	}
        	
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        
        session.close();
        sessionFactory.close();
        System.out.println( "Hibernate sample stopped" );
        
    }
}
