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
import com.luv2Code.hibernate.demo.entity.Student;

public class CreateCourseReviewsDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		// create session
		Session session = sessionFactory.openSession();

		try {
			// Start the transaction
			session.beginTransaction();

			//Create the course
			Course theCourse = new Course("Course -Student Example");

			//Create Student
			Student student1 = new Student("Dreksha","Chaudhary","a@gmail.com");
			Student student2 = new Student("Tendua","Chaudhary","tendua@gmail.com");
			
			//Save student in course
			theCourse.addStudent(student1);
			theCourse.addStudent(student2);
			
			//Save student
			 session.save(student1);
			 session.save(student2);
			 System.out.println("Students: "+student1+"  "+student2);
			 System.out.println("Course Student"+theCourse.getStudents());
			 
			 session.save(theCourse);
			// commit transaction
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