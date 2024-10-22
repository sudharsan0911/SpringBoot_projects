package com.ust.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Product {
	
	
	private int Id;
	private String brand;
	private String description;
	private int qty;
	private int price;

}
