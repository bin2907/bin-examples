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
public class CompoundDemo5 {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(CompoundDemo5.class.getResource("/hibernate.compoundkey.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	
        	User user = new User();
        	user.setUserName("a1");
        	user.setPassword("b1");
        	
        	Role role = new Role();
        	role.setName("r1");
        	session.save(role);
        	
        	Role role2 = new Role();
        	role2.setName("r2");
        	session.save(role2);
        	
        	Set<UserRole> userRoles = new HashSet<>();
        	UserRole userRole = new UserRole();
        	UserRolePk userRolePk = new UserRolePk();
        	userRolePk.setRole(role);
        	userRolePk.setUser(user);
        	userRole.setId(userRolePk);
        	userRoles.add(userRole);
        	
        	userRole = new UserRole();
        	userRolePk = new UserRolePk();
        	userRolePk.setRole(role2);
        	userRolePk.setUser(user);
        	userRole.setId(userRolePk);
        	userRoles.add(userRole);
        	
        	user.setUserRoles(userRoles);
        	session.save(user);
        	
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
