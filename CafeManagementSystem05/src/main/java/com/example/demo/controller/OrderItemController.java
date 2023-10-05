package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderItem;
import com.example.demo.service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	
	OrderItemService orderitemService;
	
	
	@PostMapping("/orders")
	public OrderItem addOrderItem(@RequestBody OrderItem ord) {
		return orderitemService.addOrderItem(ord);
		
	}
	
	@GetMapping("/orders")
	public List<OrderItem> getAllOrderItems(){
		return orderitemService.getAllOrderItems();
		}
	
	@GetMapping("/orders/{id}")
	public OrderItem getOrderItemById(@PathVariable int id) {
		return orderitemService.getOrderItemById(id);
		
	}
	
	@DeleteMapping("/orders/{id}")
	public String deleteOrderItem(@PathVariable int id) {
		return orderitemService.deleteOrderItem(id);
	}
	
	@PutMapping("/orders")
	public OrderItem updateOrderItem(@RequestBody OrderItem ord) {
		return orderitemService.updateOrderItem(ord);
	}

}
