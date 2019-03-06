package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.springsecurity.model.CartDetail;

/**
*@author Mariano Puchetta
*1 mar. 2019
*/
public interface CartRepository extends JpaRepository<CartDetail,Long>{

}
