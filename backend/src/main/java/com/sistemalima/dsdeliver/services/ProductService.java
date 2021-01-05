package com.sistemalima.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemalima.dsdeliver.dto.ProductDTO;
import com.sistemalima.dsdeliver.entities.Product;
import com.sistemalima.dsdeliver.repositories.ProductRepository;

// camada de serviço

@Service
public class ProductService {
	
	// injeção de dependencia para o repository
	
	@Autowired
	private ProductRepository repository;
	
	// metodo para buscar todos ordenados pelo nome
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	

}
