package es.udemy.hibernate.objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.udemy.hibernate.entity.Student;

public class ReadStudent {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			Student tempStudent = new Student("Oliver", "Stone", "oliver@stone.canada");
			
			// start transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student ...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			// find the primary key
			System.out.println("ID: " + tempStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive fiel based on primary key
			System.out.println("Getting student with id " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			// commit the transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
}
