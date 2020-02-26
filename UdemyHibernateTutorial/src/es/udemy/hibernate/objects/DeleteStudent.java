package es.udemy.hibernate.objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.udemy.hibernate.entity.Student;

public class DeleteStudent {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId = 5;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive fiel based on primary key
			System.out.println("Getting student with id " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// deleting
//			System.out.println("Deleting " + myStudent);
//			session.delete(myStudent);
			
			System.out.println("Delete other student with id 7");
			session.createQuery("delete from Student where id=7").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
}
