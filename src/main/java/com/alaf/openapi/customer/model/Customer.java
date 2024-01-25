package com.alaf.openapi.customer.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Data
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@NotBlank
	private String firstName;

	private String lastName;

	@NotNull
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	private String email;
	
	
	@Email()
	private String email1;

	@Min(18)
	//@Max(62)
	private int age;

	//@CreditCardNumber
	//private String creditCardNumber;

	/*
	 * public String getCreditCardNumber() { return creditCardNumber;
	 * 
	 * }
	 * 
	 * public void setCreditCardNumber(String creditCardNumber) {
	 * this.creditCardNumber = creditCardNumber; }
	 * 
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 * 
	 * public String getEmail1() { return email1; }
	 * 
	 * public void setEmail1(String email1) { this.email1 = email1; }
	 * 
	 * @Size(min = 2) public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName;
	 * 
	 * }
	 * 
	 * public String getLastName() { return lastName;
	 * 
	 * }
	 * 
	 * public void setLastName(String lastName) {
	 * 
	 * this.lastName = lastName;
	 * 
	 * }
	 * 
	 * public String getEmail() {
	 * 
	 * return email; }
	 * 
	 * public void setEmail(String email) {
	 * 
	 * this.email = email; }
	 * 
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 */
}
