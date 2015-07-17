package com.bin.hibernate.sample.entity.compoundkey;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 * 
 */
public class CompoundDemo2 {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(CompoundDemo2.class.getResource("/hibernate.compoundkey.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	
        	Role role = new Role();
        	role.setName("r1");
        	session.save(role);
        	
        	Role role2 = new Role();
        	role2.setName("r2");
        	session.save(role2);
        	
        	//NOT WORK => STUDY @JoinTable
        	/*User user = new User();
        	user.setUserName("a1");
        	user.setPassword("b1");
        	Set<Role> roles = new HashSet<>();
        	roles.add(role);
        	roles.add(role2);
        	user.setRoles(roles);
        	session.save(user);*/
        	
        	tx.commit();
        }catch(Exception exc){
        	exc.printStackTrace();
        	tx.rollback();
        }
        
        session.close();
        sessionFactory.close();
        System.out.println( "Hibernate sample stopped" );
        
    }
}
