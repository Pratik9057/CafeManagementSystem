package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OrderItem;

public interface OrderItemService {
	
	public OrderItem addOrderItem(OrderItem order);
	public List<OrderItem > getAllOrderItems();
	public OrderItem getOrderItemById(int id);
	public String deleteOrderItem(int id);
	public OrderItem updateOrderItem(OrderItem order);

}
