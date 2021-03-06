package es.udemy.hibernate.objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.udemy.hibernate.entity.Course;
import es.udemy.hibernate.entity.Instructor;
import es.udemy.hibernate.entity.InstructorDetail;
import es.udemy.hibernate.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			// get courses for the instructor
			System.out.println("Instructor: " + tempInstructor);
			System.out.println("Line 36 -> Courses: " + tempInstructor.getCourses());
						
			//commit transaction
			session.getTransaction().commit();
			// close the session
			session.close();
			
			// REZOLVE THE EXCEPTION LAZILY 
			// option 1: call getter method while session is open
			// se the line 36 -> the session is open, so work			
			
			System.out.println("Line 48 -> Courses: " + tempInstructor.getCourses());
		}finally{
			session.close();
			factory.close();
		}
	}

}
