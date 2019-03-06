package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.Cart;

/**
*@author Mariano Puchetta
*1 mar. 2019
*/
public interface CartDetailRepository extends JpaRepository<Cart,Long> {

}
