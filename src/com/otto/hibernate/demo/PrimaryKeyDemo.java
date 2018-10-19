package com.otto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otto.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
											.configure()
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();

				try {
					// create 3 students object
					System.out.println("Creating new student object...");
					Student tempStudent1 = new Student("Peter", "Malcom","eggensperger@otto.de");
					Student tempStudent2 = new Student("Mohammad", "Sleibi","msalibi83@gmail.com");
					Student tempStudent3 = new Student("Max", "Mustermann","mustermann@yahoo.com");

					// start a transaction
					session.beginTransaction();

					// save the students objects
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);

					// commit transaction
					session.getTransaction().commit();

					System.out.println("Done!");

				} finally {
					factory.close();

				}

			}

	}


