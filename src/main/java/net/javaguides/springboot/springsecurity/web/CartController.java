package net.javaguides.springboot.springsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.springsecurity.model.Cart;
import net.javaguides.springboot.springsecurity.model.CartDetail;
import net.javaguides.springboot.springsecurity.model.Product;
import net.javaguides.springboot.springsecurity.repository.CartDetailRepository;
import net.javaguides.springboot.springsecurity.repository.CartRepository;
import net.javaguides.springboot.springsecurity.repository.ProductRepository;

/**
*@author Mariano Puchetta
*5 mar. 2019
*/

@Controller
public class CartController {
	
	@Autowired
	CartDetailRepository cartDetailRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam Product product){
        CartDetail cartDetail = new CartDetail();
        Cart cart =new Cart();
        cartDetail.setCart(cart);
		cartDetail.setProduct(product);
	    ModelAndView cartModel = new ModelAndView();
	    cartModel.addObject("cartDetail",productRepository.findAll());
	    return "cart";    
	}

}
