package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class primaryKeyDemo {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();  
		
		//create session
		Session session = sessionFactory.openSession();

		try {
			System.out.println(" Save 3 Student Object");
			Student student1 = new Student("dreksha","chaudhary","chaudharydreksha@gmail.com");
			Student student2 = new Student("preksha","haudhary","haudharydreksha@gmail.com");
			Student student3 = new Student("areksha","audhary","audharydreksha@gmail.com");
			
			Transaction t = session.beginTransaction();
			System.out.println("Student saving");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			t.commit();
			//sessionFactory.getTransaction().commit();
			System.out.println("Done");

			//Steps
			//1)Session Factory object created
			//2)session get current session
			//3)make student obje
			//4)start transaction
			//5)save
			//6)SF close transaction

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
		}

	}
}
