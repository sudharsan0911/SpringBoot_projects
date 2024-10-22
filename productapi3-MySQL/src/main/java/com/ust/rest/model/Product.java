package com.ust.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	private String brand;
	private String description;
	private int qty;
	private int price;

}
