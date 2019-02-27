package net.javaguides.springboot.springsecurity.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.springsecurity.model.Product;
import net.javaguides.springboot.springsecurity.repository.ProductRepository;

/**
*@author Mariano Puchetta
*15 feb. 2019
*/
@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public String listProducts(Model model) {
		System.out.println("Get all products...");
		model.addAttribute("products", productRepository.findAll());
		 return "products";
		}
		
	@GetMapping("/products/fragment")
	public ModelAndView listOfProducts() {
	     ModelAndView mv = new ModelAndView("products :: content");
	    mv.addObject("products", productRepository.findAll());
	     return mv;
	    }
	@GetMapping("/products/adminFragment")
	public ModelAndView listOfProductsAdmin() {
	     ModelAndView mv = new ModelAndView("productsAdmin :: productsAd");
	    mv.addObject("products", productRepository.findAll());
	     return mv;
	    }
	
    @RequestMapping("admin/product/new")
    public String newProduct(Model model) {
    	model.addAttribute("product", new Product());
    	return "productForm";
    }
    
    @RequestMapping(value ="admin/product", method = RequestMethod.POST)
    	public String saveOrUpdateProduct(Product product) {
    	Product savedProduct = productRepository.save(product);
    	return "redirect:/product/show/" + savedProduct.getId();
    }
    
    @RequestMapping("admin/product/delete/{id}")
    public String delete(@PathVariable long id) {
    	System.out.println("Delete product with Id: " + id);
    	productRepository.deleteById(id);
    	return"redirect:admin/productsAdmin";
    }
	
	@RequestMapping("product/show/{id}")
	public String getProduct(@PathVariable long id,Model model) {
		model.addAttribute("product",productRepository.findById(id));
		return "productDetail";
	}
	@RequestMapping("admin/product/edit/{id}")
	public String edit(@PathVariable long id,Model model) {
		model.addAttribute("product", productRepository.findById(id));
		return "productForm";
	}
	/*
	@RequestMapping("/productDetail/{numArt}")
	public Optional<Product> findByNumArt(@PathVariable long numArt) {
		System.out.println(numArt);
		Optional<Product> products = productRepository.findById(numArt);
		return products;
	}*/
	/*
	@RequestMapping("/product/edit/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		System.out.println("Update Product with ID = " + id + "...");

		Optional<Product> productData = productRepository.findById(id);

		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setNumArt(product.getNumArt());
			_product.setTitle(product.getTitle());
			_product.setPrice(product.getPrice());
			_product.setDescription(product.getDescription());
			_product.setImageUrl(product.getImageUrl());
			_product.setInStock(product.getInStock());
			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
	
/*
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/product/list")
	public String listProducts(Model model) {
	model.addAttribute("products", productService.listAll());
	 return "product/list";
	}
	
	@RequestMapping("/product/show/{id}")
	public String getProduct(@PathVariable Integer id,Model model) {
		model.addAttribute("product",productService.getById(id));
		return "product/show";
	}
	
	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		model.addAttribute("product", productService.getById(id));
		return "product/productForm";
	}
	*/

}
