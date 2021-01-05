package com.sistemalima.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemalima.dsdeliver.entities.Product;

// camada de acesso a dados

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// metodo auxiliar para buscar os dados ordenados por nome
	
	List<Product> findAllByOrderByNameAsc();
		
	

}
