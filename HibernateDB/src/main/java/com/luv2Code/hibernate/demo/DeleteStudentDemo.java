package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DeleteStudentDemo {
	public static void main(String[] args) {
	
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();  
		
		//create session
		Session session = sessionFactory.openSession();

		try {
			
		
			int studentId=3;
		    Student stu = session.get(Student.class, studentId);
		    Transaction t = session.beginTransaction();
		    System.out.println("Deleting Student"+stu);
		    //First Way of Deletion
		    //session.delete(stu);
		 
		    //Second Way of Deletion
		    session.createQuery("delete from Student where id = 2").executeUpdate();
			
		    session.getTransaction().commit();
			System.out.println("Done");
			
		} catch (Exception ex) {
             ex.printStackTrace();
        }finally{
            if(session != null){
                session.close();
            }
        }
	}
}


//jo ganda bol rha hai wo usi ko lgege
//wo uske karm hai mere nai
//almaam,kadi patta, alovera, oninon,meti , soak and apply
//help other mereko hi punya milega
//cow no dirty food
