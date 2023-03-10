package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();  
		
		//create session
		Session session = sessionFactory.openSession();

		try {
			System.out.println("Student Object");
			Student student = new Student("dreksha","chaudhary","chaudharydreksha@gmail.com");
			Transaction t = session.beginTransaction();
			System.out.println("Student saving");
			session.save(student);
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


//hib-comm-anno-3.2.0
//hib-core-3.6.9
//hib-annotations-3.4.0.GA

/*

    <session-factory>

        <!-- JDBC Database connection settings -->
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp;serverTimezone=UTC</property>
        <property name="connection.username">root</property>
        <property name="connection.password">password</property>

        <!-- JDBC connection pool settings ... using built-in test pool -->
        <property name="connection.pool_size">1</property>

        <!-- Select our SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Echo the SQL to stdout -->
        <property name="show_sql">true</property>

		<!-- Set the current session context -->
		<property name="current_session_context_class">thread</property>
 
    </session-factory>


*/