package com.alaf.openapi.customer.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alaf.openapi.customer.model.Customer;
import com.alaf.openapi.customer.repository.CustomerRepositoryIf;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ImplCustomerService implements IfCustomerService {

	@Autowired
	CustomerRepositoryIf customerRepo;

	public Optional<Customer> getCustomerbyId(Long id) {
		return customerRepo.findById(id);
	}

	public Customer saveCustomer(Customer customer) {
			return customerRepo.save(customer);
	}
	

	public List<Customer> fetchCustomerList() {
		List<Customer> customerList = new ArrayList<>(); 
		customerRepo.findAll().spliterator().forEachRemaining(customerList::add);
		return customerList;
	}
	
	public void deleteCustomerbyId(Long id) {
		if (customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
		} else {
			log.warn("No record found for id: {} ", id );
		}
	}
}
