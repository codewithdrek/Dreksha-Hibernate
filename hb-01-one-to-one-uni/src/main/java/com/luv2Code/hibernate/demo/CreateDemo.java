package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		// create session
		Session session = sessionFactory.openSession();

		try {
			System.out.println("Instructor Object");

			session.beginTransaction();

		//	Instructor instructor = new Instructor("dreksha", "chaudhary", "chaudharydreksha@gmail.com");
   
	    //		InstructorDetail instructorDetail = new InstructorDetail("dreksha@youtubeChannle.com", "Love to code");


			Instructor instructor = new Instructor("XYZ", "chaudhary", "XYZ@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("XYZ@youtubeChannle.com", "Love to Enjoy");

			
			instructor.setInstructorDetail(instructorDetail);
            
			session.save(instructor);
			System.out.println("Saving Object"+instructor);
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