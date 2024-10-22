package com.ust.feignclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.feignclient.ifaces.ProductFeignInterface;
import com.ust.feignclient.model.Product;

@RestController
@RequestMapping("/client")
public class FeignClient {
	@Autowired
	private ProductFeignInterface feignClient;
	
	@GetMapping("/allproducts")
	public List<Product> getAll()
	{
		return feignClient.getAllProducts();
	}
//	@PostMapping("/adding")
//	public Product insert(Product product)
//	{
//		return feignClient.insertProducts(product);
//	}
	
	@GetMapping("/product/Id/{id}")
	public Product fetchById(@PathVariable("id") int id)
	{
		return feignClient.getById(id);
	}
	@GetMapping("/product/brand/{brand}")
	public List<Product> fetchByBrand(@PathVariable("brand") String brand)
	{
		return feignClient.getByBrand(brand);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public String deleteProductById(@PathVariable("id") int id)
	{
		return feignClient.deleteById(id);
	}
	

}
