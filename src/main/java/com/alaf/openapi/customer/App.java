package com.alaf.openapi.customer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.alaf.openapi.customer.model.Customer;
import com.alaf.openapi.customer.repository.CustomerRepositoryIf;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EntityScan("com.alaf.openapi.customer")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	

	@Autowired
	CustomerRepositoryIf customerRepo;;
	
	@PostConstruct
	public void init() {
		Customer aCustomer = new Customer();
		aCustomer.setFirstName("Kalle");
		aCustomer.setLastName("Anka");
		aCustomer.setAge(20);
		aCustomer.setEmail("kalle.anka@ankeborg.com");
		aCustomer.setEmail1("kalle@abc.com");
		customerRepo.save(aCustomer);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDescription,
			@Value("${application-version}") String appVersion) {
		return new OpenAPI().info(new Info().title("Sample application API").version(appVersion)
				.description(appDescription).termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

	
	
}