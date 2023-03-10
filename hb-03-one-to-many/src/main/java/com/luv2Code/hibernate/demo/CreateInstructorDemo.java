package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.luv2Code.hibernate.demo.entity.Course;
import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		// create session
		Session session = sessionFactory.openSession();

		try {
			//Start the transcation 
			session.beginTransaction();
			
			//bring Instructor from Instructor Table
			int id=1;
			Instructor instructor = session.get(Instructor.class, id);
			//create some courses
             Course course1= new Course("Guitar");
             Course course2= new Course("ball");
			
			//add cources to instructor
             instructor.add(course1);
             instructor.add(course2);			
			//save cources
             
             session.save(course1);
             session.save(course2);
            
             
			
			//commit transaction
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