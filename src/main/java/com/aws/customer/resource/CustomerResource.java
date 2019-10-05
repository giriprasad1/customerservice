package com.aws.customer.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.customer.domain.Customer;
import com.aws.customer.service.CustomerService;


@RestController
@RequestMapping(value="/v1/customers")
public class CustomerResource {
	
	private CustomerService customerService;
	
	public CustomerResource(CustomerService pCustomerService) {
		
		this.customerService = pCustomerService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		System.out.println("-------------------invoked Service-------------------------");
		if (!this.customerService.getAllCustomers().isEmpty()) {
			return ResponseEntity.ok(this.customerService.getAllCustomers());
			
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") long pCustomerId) {
		
		Optional<Customer> customer = this.customerService.getCustomer(pCustomerId);
		return customer.isPresent() ? new ResponseEntity<Customer>(customer.get(), HttpStatus.OK) 
				: new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}

	

}
