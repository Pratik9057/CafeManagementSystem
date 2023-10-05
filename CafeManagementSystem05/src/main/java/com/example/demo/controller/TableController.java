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

import com.example.demo.entity.Table;
import com.example.demo.service.TableService;


@RestController
public class TableController {
	
	@Autowired
	
       TableService tableService;
	
	
	@PostMapping("/tables")
	public Table addTable(@RequestBody Table tab) {
		return tableService.addTable(tab);
		
	}
	
	@GetMapping("/tables")
	public List<Table> getAllTables(){
		return tableService.getAllTables();
		}
	
	@GetMapping("/tables/{id}")
	public Table getTableById(@PathVariable int id) {
		return tableService.getTableById(id);
		
	}
	
	@DeleteMapping("/tables/{id}")
	public String deleteTable(@PathVariable int id) {
		return tableService.deleteTable(id);
	}
	
	@PutMapping("/tables")
	public Table updateTable(@RequestBody Table tab) {
		return tableService.updateTable(tab);
	}


}
