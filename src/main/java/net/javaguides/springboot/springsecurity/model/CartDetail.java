package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
*@author Mariano Puchetta
*28 feb. 2019
*/

@Entity
public class CartDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Cart cart;
	
	@OneToOne
	private Product product;
	
	private int quantity;
	
	public CartDetail() {
		
	}
	
	public  CartDetail(Cart cart,Product product,int quantity) {
		this.cart=cart;
		this.product=product;
		this.quantity=quantity;
	}
	
	public Cart getCart() {
		return this.cart;
	}
	public void setCart(Cart cart) {
		this.cart=cart;
	}
	
	public Product getProduct() {
		return this.product;
	}
	public void setProduct(Product product) {
		this.product=product;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
	 this.quantity=quantity;
	}
	

}
