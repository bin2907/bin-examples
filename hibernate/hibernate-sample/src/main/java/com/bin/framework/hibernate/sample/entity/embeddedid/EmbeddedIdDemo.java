package com.bin.hibernate.sample.entity.embeddedid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 * 
 */
public class EmbeddedIdDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(EmbeddedIdDemo.class.getResource("/hibernate.embeddedid.cfg.xml"));
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
