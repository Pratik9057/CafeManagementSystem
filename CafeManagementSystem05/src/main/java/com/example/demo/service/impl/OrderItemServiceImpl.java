package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.MenuItem;
import com.example.demo.entity.OrderItem;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	OrderItemRepository orderItemRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public OrderItem addOrderItem(OrderItem order) {
		// TODO Auto-generated method stub
		Customer _cust=customerRepository.findById(order.getCust_Id()).get();
		order.setCustomer(_cust);
/*		List<MenuItem> _menu= menuItemRepository.findAll();
		order.setMenuitem(_menu);*/
		return orderItemRepository.save(order);
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		// TODO Auto-generated method stub
		return orderItemRepository.findAll();
	}

	@Override
	public OrderItem getOrderItemById(int id) {
		// TODO Auto-generated method stub
		return orderItemRepository.findById(id).get();
	}

	@Override
	public String deleteOrderItem(int id) {
		// TODO Auto-generated method stub
		orderItemRepository.deleteById(id);
		return "OrderItem Delete... ";
	}

	@Override
	public OrderItem updateOrderItem(OrderItem order) {
		// TODO Auto-generated method stub
		OrderItem orderi=orderItemRepository.findById(order.getId()).get();
		orderi.setItemName(order.getItemName());
		orderi.setQuantity(order.getQuantity());
		orderi.setPrice(order.getPrice());
		return orderItemRepository.save(orderi);
	}
}
