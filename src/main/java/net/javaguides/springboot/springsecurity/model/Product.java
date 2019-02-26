package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
*@author Mariano Puchetta
*14 feb. 2019
*/
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private long numArt;
	private String title;
	private String description;
	private double price;
	private String imageUrl;
	private int inStock;
	
	public Product() {
		
	}
	public Product(long numArt,String title,String description,double price,String imageUrl,int inStock) {
		this.numArt=numArt;
		this.title=title;
		this.description=description;
		this.price=price;
		this.imageUrl=imageUrl;
		this.inStock=inStock;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumArt() {
		return numArt;
	}
	public void setNumArt(long numArt) {
		this.numArt = numArt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	public String toString() {
		return  "Product: " + title + "- Price: " + price;
	}

}
