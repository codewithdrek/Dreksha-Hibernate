package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UpdateStudentDemo {
	public static void main(String[] args) {
	
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();  
		
		//create session
		Session session = sessionFactory.openSession();

		try {
			int studentId=3;
			//Updating in Table by Hibernate Query
		    Student stu = session.get(Student.class, studentId);
		   System.out.println("Updating Student....");
		   stu.setFirstName("Lallu");
		    
			
			Transaction t = session.beginTransaction();
		    System.out.println("Updating Student. in bulk...");
		    session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
        
		  
			session.getTransaction().commit();
		    
			System.out.println("Done");
			
		} catch (Exception ex) {
             ex.printStackTrace();
        }finally{
            if(session != null){
                session.close();
            }
        }
	}
}

