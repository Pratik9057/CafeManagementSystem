package com.example.demo.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemName;
	private int quantity;
	private int price;
	
	private int cust_Id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Customer customer;
	
	//private int menu_Id;
	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	//List<MenuItem>  menuitem;
}
