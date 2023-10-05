package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	MenuItemRepository menuItemRepository;
	@Override
	public MenuItem addMenuItem(MenuItem menu) {
		// TODO Auto-generated method stub
		return menuItemRepository.save(menu);
	}

	@Override
	public List<MenuItem> getAllMenuItems() {
		// TODO Auto-generated method stub
		return menuItemRepository.findAll();
	}

	@Override
	public MenuItem getMenuItemById(int id) {
		// TODO Auto-generated method stub
		return menuItemRepository.findById(id).get();
	}

	@Override
	public String deleteMenuItem(int id) {
		// TODO Auto-generated method stub
		menuItemRepository.deleteById(id);
		return "MenuItem Deleted...";
	}

	@Override
	public MenuItem updateMenuItem(MenuItem menu) {
		// TODO Auto-generated method stub
		MenuItem menui=menuItemRepository.findById(menu.getItemId()).get();
		menui.setItemName(menu.getItemName());
		menui.setPrice(menu.getPrice());
		return menuItemRepository.save(menu);
	}

}
