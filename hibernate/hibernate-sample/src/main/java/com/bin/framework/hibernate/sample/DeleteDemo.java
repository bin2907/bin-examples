package com.bin.framework.hibernate.sample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bin.framework.hibernate.sample.entity.onetomany.Role;
import com.bin.framework.hibernate.sample.entity.onetomany.User;

/**
 * Hello world!
 * 
 */
public class DeleteDemo {
	public static void main( String[] args )
    {
        System.out.println( "Hibernate smaple is running" );
        
        Configuration configuration = new Configuration().configure(DeleteDemo.class.getResource("/hibernate.one.to.many.cfg.xml"));
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        Session session = null;
        Role role = null;
        Transaction tx = null;
        
        // Delete Role and user references
        System.out.println("\nDelete Role and user references");
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	role = (Role) session.load(Role.class, 1);
        	session.delete(role);// role object must be loaded from session then we can delete it and childs (depend on config at mapping)
        	
        	tx.commit();
        }catch(Exception exc){
        	exc.printStackTrace();
        	tx.rollback();
        }
        session.close();
        
        
        // Delete User from Role. WAY 1: CAN'T DELETE
       /* System.out.println("\nDelete User from Role. WAY 1 CAN'T DELETE");
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	
        	query = session.createQuery("select o from " + Role.class.getName() + " o where o.id = 3");
            role = (Role) query.uniqueResult();
            
			List<User> list = role.getUsers(); // users have not been existed in
												// session yet. They is loaded
												// when use objects inside list
												// (invoke get method of
												// list, ...) => All objects CAN
												// NOT DELETE in this transaction
            
            // If use: list.get(0).getId(); then 2 delete command below will CAN NOT DELETE
            int id = list.get(0).getId();
            System.out.println(id);
            
            user  = (User) session.load(User.class, 6); // 6 is id of object inside above list
            session.delete(user);
            
            user  = (User) session.load(User.class, 7); // 7 is id of object inside above list
            session.delete(user);
            
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        session.close();*/
        
        // Delete User from Role. WAY 2: CAN DELETE 
       /* System.out.println("\nDelete User from Role. WAY 2: CAN DELETE");
        session = sessionFactory.openSession();
        try{
        	tx = session.beginTransaction();
        	
            role = (Role) session.load(Role.class, 3);
			List<User> list = role.getUsers(); 
			user = list.get(0);

			// Delete
			list.remove(0);
			session.delete(user);
            
        	tx.commit();
        }catch(Exception exc){
        	
        	tx.rollback();
        }
        session.close();*/
        
        //Update User from Role
        /*System.out.println("\nUpdate User from Role");
         session = sessionFactory.openSession();
         try{
         	tx = session.beginTransaction();
         	
            role = (Role) session.load(Role.class, 3);
 			List<User> list = role.getUsers(); 
 			list.get(0).setUserName("666666");
 			list.get(1).setUserName("777777");

 			session.update(role);
 			
         	tx.commit();
         }catch(Exception exc){
         	
         	tx.rollback();
         }
         session.close();*/
        
        
        //Delete User from Role. WAY 3: orphanRemoval=true => DELETE OK
       /* System.out.println("\nDelete User from Role. WAY 3: orphanRemoval=true");
         session = sessionFactory.openSession();
         try{
         	tx = session.beginTransaction();
         	
            role = (Role) session.load(Role.class, 3);
 			List<User> list = role.getUsers(); 
 			list.clear();
 			
 			//session.delete(role);
 			//or
 			//session.update(role);
 			//or nothing
         	
 			tx.commit();
         }catch(Exception exc){
         	
         	tx.rollback();
         }
         session.close();*/
        
        
        // Close session factory
        sessionFactory.close();
        
        System.out.println( "Hibernate sample stopped" );
    }
}
