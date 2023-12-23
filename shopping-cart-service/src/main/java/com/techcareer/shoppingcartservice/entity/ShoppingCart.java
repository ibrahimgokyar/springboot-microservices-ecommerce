package com.techcareer.shoppingcartservice.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
@Entity
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String shoppingCartName;
	
	@ManyToMany
	@JoinTable(name = "shopping_cart_product",
	joinColumns = @JoinColumn(name = "shopping_cart_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	Set<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShoppingCartName() {
		return shoppingCartName;
	}

	public void setShoppingCartName(String shoppingCartName) {
		this.shoppingCartName = shoppingCartName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
