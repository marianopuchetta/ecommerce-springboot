package net.javaguides.springboot.springsecurity.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
*@author Mariano Puchetta
*28 feb. 2019
*/
@Entity
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@OneToOne
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cart", orphanRemoval = true)
	private List<CartDetail>cartDetails = new ArrayList<>();
	
	public Cart() {
		
	}
	
	public Cart(User user,ArrayList<CartDetail>cartDetails) {
		this.user=user;
		this.cartDetails = cartDetails;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	public User getUser() {
		return this.user;
	}
	
	public List<CartDetail> getCartDetails(){
		return this.cartDetails;
	}
	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails=cartDetails;
	}
	public void addCartDetail(CartDetail cartDetail) {
	    cartDetails.add(cartDetail);
		cartDetail.setCart(this);
	}
   public void removeCartDetail(CartDetail cartDetail) {
	   cartDetail.setCart(null);
	   this.cartDetails.remove(cartDetail);
   }
}
