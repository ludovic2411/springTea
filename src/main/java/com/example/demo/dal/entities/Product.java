package com.example.demo.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String reference;
	@Column(nullable=false)
	@Size(min=3,max=50, message="Product's name must be between 3 and 5O characters")
	private String name;
	@ManyToOne
	private Category category;
	@Column(nullable=false)
	@Check(constraints="price>0")
	private double price;
	@Column(nullable=true)
	@Check(constraints="quantity>0")
	private int quantity;
	@Column(nullable=false)
	private String imageUrl;
	
	
	public String getReference() {
		return reference;
	}
	public String getName() {
		return name;
	}
	public Category getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
