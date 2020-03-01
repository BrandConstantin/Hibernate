package es.udemy.hibernate.objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sun.javafx.util.TempState;

import es.udemy.hibernate.entity.Course;
import es.udemy.hibernate.entity.Instructor;
import es.udemy.hibernate.entity.InstructorDetail;
import es.udemy.hibernate.entity.Review;
import es.udemy.hibernate.entity.Student;

public class DeleteCourseForAlexandraDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			
			// get the course from db
			int courseId = 14;
			Course tempCourse = session.get(Course.class, courseId);
			System.out.println("Delete " + tempCourse.getTitle());

			// delete the course
			session.delete(tempCourse);

			//commit transaction
			session.getTransaction().commit();
		}finally{
			session.close();
			factory.close();
		}
	}

}
