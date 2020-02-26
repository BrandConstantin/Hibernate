package es.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.hibernate.crud.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			Employee tempEmployee = new Employee("Catalina", "Becks", "Usa Company");
			
			// start transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempEmployee);
			System.out.println("Saving student ...");
			System.out.println(tempEmployee);
			
			//commit transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}

}
