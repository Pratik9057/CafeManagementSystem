package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MenuItem;

public interface MenuItemService {
	
	public MenuItem addMenuItem(MenuItem menu);
	public List<MenuItem > getAllMenuItems();
	public MenuItem getMenuItemById(int id);
	public String deleteMenuItem(int id);
	public MenuItem updateMenuItem(MenuItem menu);
	

}
