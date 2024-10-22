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
import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ust.rest.model.Product;
import com.ust.rest.service.ProductService;

@RestController
@RequestMapping("/product/api")
public class ProductController {
	@Autowired
	private ProductService service;
	
	Logger logger = Logger.getLogger("ProductController.class");
	@GetMapping(value="/productid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Product>> getProductsById(@PathVariable("id") int id)
	{
		Optional<Product> optionalProduct = service.displayProductsByid(id);
		logger.info("get by id method : "+ optionalProduct);
       if(optionalProduct != null)
       {
    	   return ResponseEntity.status(HttpStatus.OK).body(optionalProduct);
    	   
       }
       else
       {
    	   return ResponseEntity.notFound().build();
       }
	}
	@GetMapping(value="/brand/{brand}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getByBrand(@PathVariable ("brand")String brand)
	{
		List<Product> productbyBrand = service.getProductByBrand(brand);
		if(productbyBrand != null)
		{
			return ResponseEntity.ok(productbyBrand);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping(value="/addProduct",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		logger.info("entered post method" + product);
		Product savedProduct = service.addProduct(product);
		logger.info("product posted "+savedProduct);
		return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
		
	}	
	@GetMapping(value="/productsinfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> displayProducts()
	{
		List<Product> allproducts = service.getAllProducts();
		if(allproducts != null)
		{
			return ResponseEntity.ok(allproducts);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	@PutMapping(value="/modify",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		
		Product updated = service.updateProduct(product);
		if(updated != null)
		{
			return ResponseEntity.ok(updated);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
		
	}
	@DeleteMapping(value="/delete/{id}")
	public String removeById(@PathVariable("id") int id)
	{
		service.deleteById(id);
		return "product deleted";
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
