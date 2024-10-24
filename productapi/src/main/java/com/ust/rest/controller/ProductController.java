package com.ust.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ust.rest.model.Product;

@RestController
@RequestMapping("/product/api")
public class ProductController {
	
	ArrayList<Product> productsList = new ArrayList<>();
	{
	productsList.add(new Product(101,"nike","sports",10,1500));
	productsList.add(new Product(102,"puma","sports",15,1600));
	productsList.add(new Product(103,"adidas","sports",11,1700));

	}
	@GetMapping(value="/productid/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getById(@PathVariable int id)
	{
		Optional<Product> optional = productsList.stream().filter(product -> product.getProductId() == id).findFirst();
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		 
	}
	@GetMapping(value="/brand/{brand}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getByBrand(@PathVariable String brand)
	{
		Optional<Product> optional = productsList.stream().filter(product -> product.getBrand().equals(brand)).findFirst();
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		 
	}
	@PostMapping(value="/addProduct",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		boolean flag = false;
		if(product != null) {
			flag = productsList.add(product);
			
		}
		
		return flag ?  ResponseEntity.status(201).body(product) : ResponseEntity.status(404).body(null);
		
	}
	


	
	@GetMapping(value="/productsinfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> displayProducts()
	{
		
		return ResponseEntity.ok(productsList);
		
	}
	@PutMapping(value="/modify",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		Optional<Product> optional = productsList.stream().filter(p->p.getProductId()==product.getProductId()).findFirst();
		Product temp = optional.get();
		
		temp.setBrand(product.getBrand());
		temp.setDescription(product.getDescription());
		temp.setPrice(product.getPrice());
		temp.setQty(product.getQty());
//		
//		int index = productsList.indexOf(temp);
//		productsList.remove(index);
//		productsList.add(temp);
		return null;
		
		
	}
	@DeleteMapping(value="/delete/{id}")
	public void removeById(@PathVariable int id)
	{
		Optional<Product> optional = productsList.stream().filter(p->p.getProductId()== id ).findFirst();
		productsList.remove(optional.get());
	}
	
	
	
//	@GetMapping("/status")
//	public String status()
//	{
//		return "Running.....!";
//	}
//	@GetMapping("/time")
//	public String time()
//	{
//		return new Date().getTime()+"";
//	}
//	
//	@PostMapping
//	public String post(int a) {
//		return "Posted " + a;
//	}

}
