package com.otto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otto.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
				
			int studentId=1;
			
			//now get a session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+studentId);
			
			Student myStudent=session.get(Student.class,studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Samer");
			
			//commit transaction
			session.getTransaction().commit();
			
			//New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Updating the students emails
			System.out.println("Update the emails for students...");
			session.createQuery("update Student set email='@hotmail.com'")
								.executeUpdate();
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			factory.close();

		}

	}

}
