package com.sistemalima.dsdeliver.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemalima.dsdeliver.dto.ProductDTO;
import com.sistemalima.dsdeliver.services.ProductService;

// Controlador rest

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	// injeção de dependencia para a camada de serviço
	
	@Autowired
	private ProductService service;
	
	// 1º end point/ buscar todos/ retornando resposta http 200 ok
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
