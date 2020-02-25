package es.udemy.hibernate.create.object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.udemy.hibernate.entity.Student;

public class CreateStudent {

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
			Student tempStudent = new Student("Mary", "Dougles", "mary@doug.usa");
			
			// start transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			System.out.println("Saving student ...");
			System.out.println(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}

}
