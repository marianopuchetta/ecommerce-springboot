package net.javaguides.springboot.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.Product;

/**
*@author Mariano Puchetta
*15 feb. 2019
*/
public interface ProductRepository extends JpaRepository<Product,Long> {

	List<Product>findByNumArt(long numArt);

	Product findById(long id);
	
}
