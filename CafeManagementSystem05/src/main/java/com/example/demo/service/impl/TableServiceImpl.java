package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Table;
import com.example.demo.repository.TableRepository;
import com.example.demo.service.TableService;

@Service
public class TableServiceImpl implements TableService{

	
	@Autowired
	TableRepository tableRepository;

	@Override
	public Table addTable(Table table) {
		// TODO Auto-generated method stub
		return tableRepository.save(table);
	}

	@Override
	public List<Table> getAllTables() {
		// TODO Auto-generated method stub
		return tableRepository.findAll();
	}

	@Override
	public Table getTableById(int id) {
		// TODO Auto-generated method stub
		return tableRepository.findById(id).get();
	}

	@Override
	public String deleteTable(int id) {
		// TODO Auto-generated method stub
		tableRepository.deleteById(id);
		return "Table Deleted...";
	}

	@Override
	public Table updateTable(Table table) {
		// TODO Auto-generated method stub
		Table table1=tableRepository.findById(table.getTableId()).get();
		table1.setTableNumber(table.getTableNumber());
		table1.setAvailable(table.isAvailable());
		table1.setCapacity(table.getCapacity());
		return tableRepository.save(table1);
	}
}
