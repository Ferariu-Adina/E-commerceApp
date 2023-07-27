package ro.adina.application;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class ShoppingCart {
	
	Long id;
	
	
	private List<Products> allProducts;
	private double totalPrice;

	
	public ShoppingCart() {
		totalPrice = 0;
		allProducts = new ArrayList<>();
		
	}
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Products> getAllProducts() {
		return allProducts;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
	public Products getProductFromCart(Products product){
        for (Products item : allProducts){
            if(item.getId() == product.getId()){
                return item;
            }
        }
        return null;
	}
	
	public int getNumberOfProducts() {
		return allProducts.size();
	}


	public void addProduct(Products product) {
			
			allProducts.add(product);
			
	
	}
	
	public void removeProduct(Products product) {
		
		Products item = getProductFromCart(product);
		if(item != null) {
			
			allProducts.remove(item);
			
		}
		
	}

	public double getTotal() {
		for(Products product : allProducts) {
			
			totalPrice += product.price;
		}
		
		return totalPrice;
	}
	
	public boolean isEmpty() {
		return allProducts.isEmpty();
	}
	
	
	
	

}
