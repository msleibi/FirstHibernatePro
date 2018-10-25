package com.otto.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otto.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student")
					.getResultList();

			// display the students
			displayStudents(theStudents);
			System.out.println("\n\n");

			// query students with email: gmail
			theStudents = session.createQuery(
					"from Student s where s.email like '%gmail%'")
					.getResultList();

			System.out.println("\n\nThe Students who have email gmail are: ");
			displayStudents(theStudents);

			// query students with firstname Mohammad Or lastname Mustermann
			theStudents = session				
					.createQuery(
							"from Student s where s.firstName='Mohammad' or s.lastName='Mustermann'")
					.getResultList();

			System.out.println("\n\n The Students who have firstname Mohammad Or lastname Mustermann: ");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println("Name: " + student.getFirstName() + " "
					+ student.getLastName());
		}
	}
}
