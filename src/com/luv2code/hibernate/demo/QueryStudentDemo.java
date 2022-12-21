package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	
	public static void main(String args []) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			//query  all the students
			List<Student> theStudents  = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			// query students : lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//display the students
			System.out.println("\n\n students who have last name of Doe");
			displayStudents(theStudents);
			
			
			// query students : lastName = 'Doe' OR FirstName='Daffy'
			theStudents = session.createQuery("from Student s where"
								  + " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nStudents who have lastName of Doe or firstName Daffy");
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where"
								  + " s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\nStudents whose email ends with gmail.com");
			displayStudents(theStudents);
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done");

		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student :theStudents) {
			System.out.println(student);
		}
	}

}










