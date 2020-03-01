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

public class AddCourseForAlexandraDemo {

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
			
			// get strudenet id from database
			int studentId = 3;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println(tempStudent.getCourses());
			
			// create more courses
			Course thempCourse1 = new Course("PHP");
			Course thempCourse2 = new Course("JavaScript");
			Course thempCourse3 = new Course("AngularJS");
			
			// add student to courses
			thempCourse1.addStudent(tempStudent);
			thempCourse2.addStudent(tempStudent);
			thempCourse3.addStudent(tempStudent);

			// save the course
			session.save(thempCourse3);
			session.save(thempCourse2);
			session.save(thempCourse1);
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
			session.close();
			factory.close();
		}
	}

}
