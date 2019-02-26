package net.javaguides.springboot.springsecurity.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
import net.javaguides.springboot.springsecurity.service.UserService;

/**
*@author Mariano Puchetta
*24 feb. 2019
*/

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/user/{email}")
	public String getUser(@PathVariable String email,Model model) {
		Object authClient = userService.loadUserByUsername(email);
		Object authServer =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authServer.equals(authClient)) {
			model.addAttribute("user",userRepository.findByEmail(email));
			return "userBoard";		
			}
		System.out.println(( SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
		System.out.println(userService.loadUserByUsername(email));
		return "/index"; 
		
		
	}

}
