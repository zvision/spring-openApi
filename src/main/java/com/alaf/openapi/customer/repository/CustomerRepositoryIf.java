package com.alaf.openapi.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alaf.openapi.customer.model.Customer;

@Repository
public interface CustomerRepositoryIf extends JpaRepository<Customer, Long> {

	
}
