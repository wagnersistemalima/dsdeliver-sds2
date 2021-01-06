package com.sistemalima.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemalima.dsdeliver.dto.OrderDTO;
import com.sistemalima.dsdeliver.dto.ProductDTO;
import com.sistemalima.dsdeliver.entities.Order;
import com.sistemalima.dsdeliver.entities.OrderStatus;
import com.sistemalima.dsdeliver.entities.Product;
import com.sistemalima.dsdeliver.repositories.OrderRepository;
import com.sistemalima.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	// injeção de dependencia para a camada de acesso a dados OrderRepository
	
	@Autowired
	private OrderRepository repository;
	
	// injeção de dependencia para camada de acesso a dados dos produtos ProductRepository
	
	@Autowired
	private ProductRepository productRepository;
	
	// metodo para buscar todos pedidos pendentes, ordenados pelos mais antigos ate os recentes
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	// metodo para inserir um pedido
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order entity = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
	
		for (ProductDTO p: dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			entity.getProducts().add(product);
		}
		entity = repository.save(entity);
		return new OrderDTO(entity);
	}

}
