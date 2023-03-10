package com.luv2Code.hibernate.demo;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.luv2Code.hibernate.demo.entity.Course;
import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo {
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
			
			System.out.println("instructor :"+instructor);
			
			//get cources from Instructor
			
			System.out.println("Course :"+instructor.getCourseList());
             
			for (Course course : instructor.getCourseList()) {
				System.out.println("----"+course.getTitle());
			}
			
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