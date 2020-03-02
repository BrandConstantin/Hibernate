package es.webapp.database.crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.webapp.database.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; // is the session factory from spring-mvc-crud-demo-servlet.xml

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = currSession.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the resutls
		return customers;
	}
}
