package com.sistemalima.dsdeliver.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sistemalima.dsdeliver.entities.Order;
import com.sistemalima.dsdeliver.entities.OrderStatus;

// Objeto para carregar os dados

public class OrderDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// atributos basico
	
	private Long Id;
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	
	private OrderStatus status;
	
	List<ProductDTO> products = new ArrayList<>();
	
	
	
	
	// construtor default
	
	public OrderDTO() {
		
	}
	
	// construtor com argumentos

	public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		Id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}
	
	// construtor personalizado
	
	public OrderDTO(Order entity) {
		this.Id = entity.getId();
		this.address = entity.getAddress();
		this.latitude = entity.getLatitude();
		this.longitude = entity.getLongitude();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.products = entity.getProducts().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	
	// getters & setters

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}


}
