package com.bin.hibernate.sample.entity.compoundkey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 * 
 */
public class CompoundDemo4 {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(CompoundDemo4.class.getResource("/hibernate.compoundkey.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        
        Transaction tx = null;
        try{
        	tx = session.beginTransaction();
        	
        	User user = new User();
        	user.setUserName("a1");
        	user.setPassword("b1");
        	session.save(user);
        	
        	user = new User();
        	user.setUserName("a2");
        	user.setPassword("b2");
        	session.save(user);
        	
        	Role role = new Role();
        	role.setName("r1");
        	session.save(role);
        	
        	role = new Role();
        	role.setName("r2");
        	session.save(role);
        	
        	User u1 = (User) session.load(User.class, 1);
        	Role r1 = (Role) session.load(Role.class, 1);
        	UserRole userRole = new UserRole();
        	UserRolePk id = new UserRolePk();
        	id.setUser(u1);
        	id.setRole(r1);
        	userRole.setId(id);
        	session.save(userRole);
        	
        	User u2 = (User) session.load(User.class, 1);
        	Role r2 = (Role) session.load(Role.class, 2);
        	UserRole userRole2 = new UserRole();
        	UserRolePk id2 = new UserRolePk();
        	id2.setUser(u2);
        	id2.setRole(r2);
        	userRole2.setId(id2);
        	session.save(userRole2);
        	
        	tx.commit();
        }catch(Exception exc){
        	exc.printStackTrace();
        	tx.rollback();
        }
        session.close();        
        
        
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();

        	User u3 = (User) session.load(User.class, 1);
        	System.out.println( u3.getUserRoles().size() );//2
        	
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
