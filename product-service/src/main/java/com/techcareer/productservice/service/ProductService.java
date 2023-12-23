package com.techcareer.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techcareer.productservice.entity.Product;
import com.techcareer.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ResponseEntity<Product> queryById(Long id)
	{
	    Product product = 	productRepository.findById(id)
	    		.orElseThrow(() -> new RuntimeException("ilgili id ye ait kayıt yok"));
	    return ResponseEntity.ok(product);
	}

	 public ResponseEntity<List<Product>> tumUrunler() {
		 
		 return ResponseEntity.ok().body(productRepository.findAll());
	 }

	 
	 public ResponseEntity<Product> kaydet(Product product)
	 {
		 return ResponseEntity.ok().body(productRepository.save(product));
	 }

}
