package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.exceptionhandling.DuplicateMobileNumberException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public Customer addCustomer(Customer cu) {
		// TODO Auto-generated method stub
		
		//check the unique mobile number
		if(customerRepository.findBycustContact(cu.getCustContact())!=null) {
			throw new DuplicateMobileNumberException("Mobile number already exists.");
		}
		return customerRepository.save(cu);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
		return "Customer deleted";
	}

	@Override
	public Customer updateCustomer(Customer cu) {
		// TODO Auto-generated method stub
		Customer cust=customerRepository.findById(cu.getCustId()).get();
		cust.setCustName(cu.getCustName());
		cust.setCustContact(cu.getCustContact());
		
		
		return customerRepository.save(cust);
	}

	@Override
	public Customer findBycustContact(String custContact) {
		// TODO Auto-generated method stub
		return customerRepository.findBycustContact(custContact);
	}

}
