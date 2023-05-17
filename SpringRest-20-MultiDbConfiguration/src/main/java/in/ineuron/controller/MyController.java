package in.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import in.ineuron.model.customer.Customer;
import in.ineuron.repo.customer.ICustomerDao;

@Controller
public class MyController {

	
	
	@Autowired
	private ICustomerDao iCustomerDao;
	
	public void getAllCustomer() {
		
		List<Customer> list = iCustomerDao.findAll();
		System.out.println(list);
	}
	
	
	
}
