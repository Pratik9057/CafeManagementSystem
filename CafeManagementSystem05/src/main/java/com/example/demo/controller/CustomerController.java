package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.exceptionhandling.CustomerNameValidException;
import com.example.demo.exceptionhandling.PhoneNumberValidationException;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		// Customer Name Validation
		if(!isValidCustomerName(customer.getCustName()))
		{
			throw new CustomerNameValidException("Name at least 3 characters and it must be only alphabets");
		}
		
		//Mobile Number Validation
		if (!isValidMobileNumber(customer.getCustContact())) {
            throw new PhoneNumberValidationException("Invalid mobile number. It should be 10 digits.");
        }
		customerService.addCustomer(customer);
        
        return ResponseEntity.ok("User registered successfully!");
        
	}
	public boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber != null && mobileNumber.matches("\\d{10}");
    }
	public boolean isValidCustomerName(String name)
	{
		return name != null && name.matches("^[a-zA-Z]{3,25}$");
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
		}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
		
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return customerService.deleteCustomer(id);
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

}
