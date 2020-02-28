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

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course tempCourse = new Course("Spring");
			
			// save the course and leverage the cascade all
			System.out.println("Saving...");
			session.save(tempCourse);
			
			// create the students
			Student thempStudent1 = new Student("John", "Doe", "john.doe@udemy.es");
			Student thempStudent2 = new Student("Rodriquez", "Love", "mary@udemy.es");
			
			// add students to course
			session.save(thempStudent1);
			session.save(thempStudent2);
			System.out.println("Students saved " + tempCourse.getStudents());
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
			session.close();
			factory.close();
		}
	}

}
