package com.amigoscode.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

	public void registerCustomer(CustomerRegistrationRequest request) {
		// TODO Auto-generated method stub
		Customer customer = Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();
		
		customerRepository.save(customer);
	}

}
