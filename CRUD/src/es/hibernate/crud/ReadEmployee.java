package es.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.hibernate.crud.Employee;

public class ReadEmployee {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a employee object
			Employee tempEmployee = new Employee("Oliver", "Stone", "Canada Company", null);
			
			// start transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("Saving employee ...");
			System.out.println(tempEmployee);
			session.save(tempEmployee);
			
			//commit transaction
			session.getTransaction().commit();
			
			// find the primary key
			System.out.println("ID: " + tempEmployee.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive fiel based on primary key
			System.out.println("Getting employee with id " + tempEmployee.getId());
			Employee myemployee = session.get(Employee.class, tempEmployee.getId());
			
			// commit the transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
}
