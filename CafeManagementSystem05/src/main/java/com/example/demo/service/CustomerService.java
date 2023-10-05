package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer cu);
	public List<Customer > getAllCustomers();
	public Customer getCustomerById(int id);
	public String deleteCustomer(int id);
	public Customer updateCustomer(Customer cu);
	public Customer findBycustContact(String custContact);

}
