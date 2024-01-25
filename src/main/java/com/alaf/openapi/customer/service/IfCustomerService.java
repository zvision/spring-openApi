package com.alaf.openapi.customer.service;

import java.util.List;
import java.util.Optional;

import com.alaf.openapi.customer.model.Customer;

public interface IfCustomerService {

	 // Save operation
    Customer saveCustomer(Customer customer);
 
    // Read operation
    List<Customer> fetchCustomerList();
 
    Optional<Customer> getCustomerbyId(Long customertId);
 
   
}
