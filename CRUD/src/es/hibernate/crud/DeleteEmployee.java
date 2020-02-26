package es.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.hibernate.crud.Employee;

public class DeleteEmployee {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int employeeId = 1;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive fiel based on primary key
			System.out.println("Getting employee with id " + employeeId);
			Employee myemployee = session.get(Employee.class, employeeId);
			
			// deleting
			System.out.println("Deleting " + myemployee);
			session.delete(myemployee);
			
			// commit the transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
}
