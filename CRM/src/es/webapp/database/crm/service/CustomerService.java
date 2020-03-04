package es.webapp.database.crm.service;

import java.util.List;

import es.webapp.database.crm.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
