package com.techcareer.shoppingcartservice.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {
	
	@Id
	private Long id;
	private String name;

	
	@ManyToMany(mappedBy = "products")
	private Set<ShoppingCart> shoppingCarts;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
