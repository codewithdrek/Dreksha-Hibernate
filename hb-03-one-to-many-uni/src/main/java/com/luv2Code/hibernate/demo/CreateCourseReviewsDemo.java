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
import com.luv2Code.hibernate.demo.entity.Review;

public class CreateCourseReviewsDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		// create session
		Session session = sessionFactory.openSession();

		try {
			//Start the transaction 
			session.beginTransaction();
			
		Course theCourse= new Course("DATA in COURSE 1");
		
		theCourse.addReview(new Review("Generate Review 1"));
		theCourse.addReview(new Review("Generate Review 2"));
		theCourse.addReview(new Review("Generate Review 3"));
		
		System.out.println("Saving Data");
		System.out.println("Course"+theCourse);
		System.out.println("Review  : "+theCourse.getReviews());
		
		session.save(theCourse);
			
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