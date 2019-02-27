package net.javaguides.springboot.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
       //return "redirect:/products";
    	return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/cart")
    public String getCar(Model model) {
    	return "/cart";
    }
   

    @GetMapping("/user")
    public String userBoard(Model model) {
        return "userBoard";
    }
    @GetMapping("/admin")
    public String adminBoard(Model model) {
    	return "adminBoard";
    }
    @GetMapping("/productDetail")
    public String productDetail(Model model) {
    	return "productDetail";
    }
    @GetMapping("productForm")
    public String productForm(Model model) {
    	return "productForm";
    }
 
   
}
