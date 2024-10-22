package com.ust.feignclient.ifaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ust.feignclient.model.Product;

@FeignClient(value="feignclient",url = "http://localhost:8090/product/api")
public interface ProductFeignInterface {
	
	@GetMapping("/productsinfo")
	public List<Product> getAllProducts();
	
//	@PostMapping("/addProduct")
//	public Product insertProducts(Product product);
	
	@GetMapping("/productid/{id}")
	public Product getById(@PathVariable("id") int id);
	
	@GetMapping("/brand/{brand}")
	public List<Product> getByBrand(@PathVariable("brand") String brand);
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id);
	
}
