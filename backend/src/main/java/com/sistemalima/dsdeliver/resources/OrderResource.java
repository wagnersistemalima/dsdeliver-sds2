package com.sistemalima.dsdeliver.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemalima.dsdeliver.dto.OrderDTO;
import com.sistemalima.dsdeliver.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	// injeção de dependencia para a camada de serviço OrderService
	
	@Autowired
	private OrderService service;
	
	// 1º end point / buscar todos / retorna resposta http 200
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
