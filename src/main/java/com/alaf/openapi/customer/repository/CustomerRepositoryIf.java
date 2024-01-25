package com.alaf.openapi.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alaf.openapi.customer.model.Customer;

@Repository
public interface CustomerRepositoryIf extends CrudRepository<Customer, Long> {

	
}
