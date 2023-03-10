package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String args []) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("creating student object");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student");
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// new extra code
			System.out.println("saved student. Generated id: "+tempStudent.getId());
			
			// now get a new session and start the transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
		
			//retrieve the student based on id : primary key
			System.out.println("\nGetting student with id: "+tempStudent.getId());

			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("get complete "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done");
			

		}
		finally {
			factory.close();
		}
		
	}

}





