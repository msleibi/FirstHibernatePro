package com.otto.hibernate.demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.BoxLayout;

import java.awt.Color;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;

import java.awt.FlowLayout;

import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otto.hibernate.demo.entity.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTable;

public class StudentWin {

	private JFrame frame;
	private JTextField txtClickMe;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentWin window = new StudentWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		session = factory.getCurrentSession();
		session.beginTransaction();

		List<Student> theStudents = session.createQuery("from Student").getResultList();

		frame = new JFrame();
		frame.setBounds(100, 100, 801, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnClickMe = new JButton("Click me");
		btnClickMe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				SessionFactory factory = new Configuration().configure()
						.addAnnotatedClass(Student.class).buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();
				session = factory.getCurrentSession();
				session.beginTransaction();

				List<Student> theStudents = session.createQuery(
						"from Student s where s.firstName='Ivan'")
						.getResultList();
				// displayInTxt(theStudents, txtClickMe);
			}
		});
		
		btnClickMe.setBounds(97, 193, 89, 23);
		frame.getContentPane().add(btnClickMe);

		txtClickMe = new JTextField();
		txtClickMe.setBounds(67, 106, 162, 35);
		frame.getContentPane().add(txtClickMe);
		txtClickMe.setColumns(10);

		table = new JTable();
		table.setBounds(332, 95, 372, 266);
		frame.getContentPane().add(table);
	}

	private static void displayInTxt(List<Student> theStudents,
			JTextField txtClickMe) {
		for (Student student : theStudents) {
			txtClickMe.setText(student.getFirstName());
		}
	}

	private static void displayInTable(List<Student> theStudents, JTable table) {
		for (Student student : theStudents) {

		}
	}
}
