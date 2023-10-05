package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Table;

public interface TableService {
	
	public Table addTable(Table table);
	public List<Table > getAllTables();
	public Table getTableById(int id);
	public String deleteTable(int id);
	public Table updateTable(Table table);

}
