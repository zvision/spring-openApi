package com.alaf.openapi.customer.controller;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alaf.openapi.customer.exception.ResourceNotFoundException;
import com.alaf.openapi.customer.model.Customer;
import com.alaf.openapi.customer.service.ImplCustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerController {

	@Autowired
	private ImplCustomerService customerService;

	
	@Operation(summary = "Create a new customer")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Customer created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)),
					@Content(mediaType = "application/xml", schema = @Schema(implementation = Customer.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content) })
	@PostMapping(path = "/customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		return ResponseEntity.ok().body(customerService.saveCustomer(customer));
	}

	// @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET,
	// produces = { "application/json", "application/xml" })
	@GetMapping(value = "/customer/{id}", produces = { "application/json", "application/xml" })
	@Operation(summary = "Get a customer by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the customer", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class)),
					@Content(mediaType = "application/xml", schema = @Schema(implementation = Customer.class)) }),
			@ApiResponse(responseCode = "404", description = "Customer not found", content = @Content) })
	public ResponseEntity<?> getCustomer(
			@Parameter(description = "id of the customer to be searched") @PathVariable("id") long id) {

		Optional<Customer> customer = customerService.getCustomerbyId(Long.valueOf(id));
		if (customer.isPresent())
			return ResponseEntity.ok().body(customer.get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such customer with id " + id);

	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	@Operation(summary = "Delete a customer by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Delete the customer", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Hashtable.class)) }),
			@ApiResponse(responseCode = "404", description = "Customer not found", content = @Content) })
	public ResponseEntity<String> deleteCustomer(
			@Parameter(description = "id of the customer to be deleted") @PathVariable("id") long id)
			throws ResourceNotFoundException {

		Optional<Customer> customer = customerService.getCustomerbyId(Long.valueOf(id));
		String jsonMsg = "";

		if (customer.isPresent()) {
			customerService.deleteCustomerbyId(customer.get().getId());
			jsonMsg = "{\"status\":\"Customer deleted!\"}";
			return ResponseEntity.ok().body(jsonMsg);
		}

		jsonMsg = "{\"status\":\"Customer not found!\"}";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonMsg);
	}

}
