package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		// create session
		Session session = sessionFactory.openSession();

		try {
			
			session.beginTransaction();

		 int id=3;
		 InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
		 System.out.println("Instructor Details "+instructorDetail);
		 
		 //Bi directional MApping in below line
		 System.out.println("Associated Instructor"+instructorDetail.getInstructor());
		session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}