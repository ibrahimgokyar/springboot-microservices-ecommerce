package com.techcareer.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcareer.productservice.entity.Product;
import com.techcareer.productservice.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		
		return productService.tumUrunler();
		
	}
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product)
	{
		return productService.kaydet(product);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> gueryById(@PathVariable("id") Long id)
	{
		return productService.queryById(id);
	}
	

}
