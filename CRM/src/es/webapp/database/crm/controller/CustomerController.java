package es.webapp.database.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.webapp.database.crm.dao.CustomerDAO;
import es.webapp.database.crm.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDao; // ist the CustomerDAO interface name

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the dao
		List<Customer> theCustomers = customerDao.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}