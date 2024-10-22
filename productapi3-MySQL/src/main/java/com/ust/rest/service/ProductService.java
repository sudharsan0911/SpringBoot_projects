package com.ust.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.Product;
import com.ust.rest.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(Product newProduct)
	{
		return repository.save(newProduct);
	}
	public Optional<Product> displayProductsByid(long id)
	{
		return repository.findById(id);
	}
	public List<Product> getProductByBrand(String brandToSearch)
	{
		return repository.findByBrand(brandToSearch);
	}
	public List<Product> getAllProducts()
	{
		return repository.findAll();
	}
	public void deleteById(long id)
	{
		repository.deleteById(id);
	}
	public Product updateProduct(Product product)
	{
		if(repository.existsById(product.getId()))
			return repository.save(product);
		return null;
		
	}
}
