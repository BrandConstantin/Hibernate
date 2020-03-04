package es.webapp.database.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.webapp.database.crm.dao.CustomerDAO;
import es.webapp.database.crm.entity.Customer;
import es.webapp.database.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	/*
	 * // need to inject the customer dao
	 * 
	 * @Autowired private CustomerDAO customerDao; // ist the CustomerDAO interface
	 * name
	 */

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;

//	@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel1) {
		// crate model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel1.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}

}