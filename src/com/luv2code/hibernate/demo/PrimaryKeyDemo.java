package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
public static void main(String args []) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student objects
			System.out.println("creating student objects");
			Student tempStudent1 = new Student("Paul", "Wall", "paul@luv2code.com");
			Student tempStudent2 = new Student("Vivek", "Sam", "vvsam@luv2code.com");
			Student tempStudent3 = new Student("HOney", "Bee", "honeyb@luv2code.com");

			// start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done");

		}
		finally {
			factory.close();
		}
		
	}

}
