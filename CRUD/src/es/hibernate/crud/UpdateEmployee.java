package es.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.hibernate.crud.Employee;

public class UpdateEmployee {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int employeeId = 3;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive fiel based on primary key
			System.out.println("Getting employee with id " + employeeId);
			Employee myemployee = session.get(Employee.class, employeeId);
			
			// updating
			myemployee.setCompany("Usa SS Company");			
			System.out.println(myemployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// other update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Employee e set e.company='General Company' where e.company LIKE '%oliver@%'").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
		}finally{
			session.close();
			factory.close();
		}
	}
}
