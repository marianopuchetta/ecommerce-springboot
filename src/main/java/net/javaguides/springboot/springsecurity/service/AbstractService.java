package net.javaguides.springboot.springsecurity.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
*@author Mariano Puchetta
*16 feb. 2019
*/
public class AbstractService {
protected EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
