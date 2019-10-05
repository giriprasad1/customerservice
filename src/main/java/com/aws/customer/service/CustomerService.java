package com.aws.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.customer.domain.Customer;
import com.aws.customer.repoitory.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository pCustomerRepositor) {
		
		this.customerRepository = pCustomerRepositor;
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
	    this.customerRepository.findAll().forEach(customerList::add);
	    return customerList;
	}
	
	public Optional<Customer> getCustomer(long pId) {
		
		return this.customerRepository.findById(pId);
		
	}

}
