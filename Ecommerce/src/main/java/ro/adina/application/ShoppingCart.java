package ro.adina.application;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	
	private List<Products> allProducts;
	private double totalPrice;

	
	public ShoppingCart() {
		totalPrice = 0;
		allProducts = new ArrayList<>();
		
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
		totalPrice = 0;
		for(Products product : allProducts) {
			
			totalPrice += product.price;
		}
		
		return totalPrice;
	}
	
	public boolean isEmpty() {
		return allProducts.isEmpty();
	}
	
	
	
	

}
