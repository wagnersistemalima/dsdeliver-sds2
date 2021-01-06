package com.sistemalima.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemalima.dsdeliver.dto.OrderDTO;
import com.sistemalima.dsdeliver.entities.Order;
import com.sistemalima.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	// injeção de dependencia para a camada de acesso a dados OrderRepository
	
	@Autowired
	private OrderRepository repository;
	
	// metodo para buscar todos
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}
