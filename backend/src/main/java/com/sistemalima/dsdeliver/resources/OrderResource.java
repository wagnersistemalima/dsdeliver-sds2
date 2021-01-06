package com.sistemalima.dsdeliver.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// 2º end point/ inserir um pedido / resposta 201 created
	
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
