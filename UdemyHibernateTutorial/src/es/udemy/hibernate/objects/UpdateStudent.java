package es.udemy.hibernate.objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.udemy.hibernate.entity.Student;

public class UpdateStudent {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId = 1;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive fiel based on primary key
			System.out.println("Getting student with id " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// updating
			myStudent.setFirstName("Alexander");
			
			System.out.println(myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// other update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student s set s.email='officer@gmail.com' where s.email LIKE '%officer@andrea%'").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
}
