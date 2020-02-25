package es.udemy.hibernate.objects;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.udemy.hibernate.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName = Doe
			theStudents = session.createQuery("from Student s where s.lastName='Stone'").getResultList();
			System.out.println("Display students with the lastName Stone is ");
			displayStudents(theStudents);
			
			// query student with last name Lavinia or first name Lavinia
			theStudents = session.createQuery("from Student s where "
					+ "s.lastName='Lavinia' OR s.firstName='Lavinia'").getResultList();
			System.out.println("Find Lavinia: ");
			displayStudents(theStudents);
			
			// query students where email like '%hibernate%'
			theStudents = session.createQuery("from Student s where s.email LIKE '%hibernate%'").getResultList();
			System.out.println("Find hibernate email");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
            session.close();
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
