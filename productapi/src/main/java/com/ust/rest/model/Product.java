package com.ust.rest.model;

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
	
	private int productId;
	private String brand;
	private String description;
	private int qty;
	private int price;

}
