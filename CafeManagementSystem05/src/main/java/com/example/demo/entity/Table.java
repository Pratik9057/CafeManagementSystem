package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "CafeTable")
public class Table {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tableId;
	private int tableNumber;
	private boolean Available;
	private int capacity;

}
