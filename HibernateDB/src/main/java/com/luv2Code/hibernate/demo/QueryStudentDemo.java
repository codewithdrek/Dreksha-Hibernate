package com.luv2Code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
	public static void main(String[] args) {
	
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();  
		
		//create session
		Session session = sessionFactory.openSession();

		try {
			Transaction t = session.beginTransaction();
			
			//Select * from Student Query
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudent(students);
			
			
			//Select * from Student where last name ="Chaudhary"
			students = session.createQuery("from Student s where s.lastName ='chaudhary'").getResultList();
			System.out.println("Last Name:");
			displayStudent(students);
			
			
			//Select * from Student where last name ="Chaudhary" or firsyName="Dreksha"
			students=session.createQuery("from Student s where "
					+ " s.lastName='chaudhary' OR s.firstName='DUKC'").getResultList();
			System.out.println("OR Query");
			displayStudent(students);
			
			
			//Select * from Student where emailId ="@gmail.com"
			students= session.createQuery("from Student s where s.email LIKE '%gmail.com' ").getResultList();
			System.out.println("EMAIL check");
			displayStudent(students);
			
			
			t.commit();
			
			System.out.println("Done");

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
		}

	}

	private static void displayStudent(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
			
			}
	}

	
}

