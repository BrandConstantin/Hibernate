package es.udemy.hibernate.objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.udemy.hibernate.entity.Course;
import es.udemy.hibernate.entity.Instructor;
import es.udemy.hibernate.entity.InstructorDetail;
import es.udemy.hibernate.entity.Student;

public class CreateInstructorDemo {

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
			// create the objects
			Instructor tempInstructor = new Instructor("Kaly", "Right", "kaly.r@hibernate.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.spring.com", "Spring");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start transaction
			session.beginTransaction();
			
			// save the instructor and detail object because of CascadeType.All
			System.out.println("Saving instructor " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
			session.close();
			factory.close();
		}
	}

}
