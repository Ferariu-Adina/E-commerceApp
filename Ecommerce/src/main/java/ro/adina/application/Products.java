package ro.adina.application;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	double price;
	//String description;
	String name;
	
	
	public Products() {
		super();
	}
	public Products(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", price=" + price + ", name=" + name + "]";
	}
	
	

}
