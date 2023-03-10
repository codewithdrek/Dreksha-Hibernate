package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.luv2Code.hibernate.demo.entity.Instructor;

public class DeleteDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		// create session
		Session session = sessionFactory.openSession();

		try {
			System.out.println("Instructor Object");

			session.beginTransaction();
      
	         int id=2;
	         Instructor instructor = session.get(Instructor.class,id);
			
	         System.out.println("Found Instructor Id "+" "+id +" "+instructor);
			
	         session.delete(instructor);
	         

	         System.out.println("Delete Instructor Id "+" "+id +" "+instructor);
			
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}