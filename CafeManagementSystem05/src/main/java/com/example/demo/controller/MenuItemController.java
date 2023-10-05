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

import com.example.demo.entity.MenuItem;
import com.example.demo.service.MenuItemService;

@RestController
public class MenuItemController {
	
	@Autowired
	MenuItemService menuitemService;
	
	
	@PostMapping("/menus")
	public MenuItem addMenuItem(@RequestBody MenuItem me) {
		return menuitemService.addMenuItem(me);
		
	}
	
	@GetMapping("/menus")
	public List<MenuItem> getAllMenuItems(){
		return menuitemService.getAllMenuItems();
		}
	
	@GetMapping("/menus/{id}")
	public MenuItem getMenuItemById(@PathVariable int id) {
		return menuitemService.getMenuItemById(id);
		
	}
	
	@DeleteMapping("/menus/{id}")
	public String deleteMenuItem(@PathVariable int id) {
		return menuitemService.deleteMenuItem(id);
	}
	
	@PutMapping("/menus")
	public MenuItem updateMenuItem(@RequestBody MenuItem me) {
		return menuitemService.updateMenuItem(me);
	}

}
