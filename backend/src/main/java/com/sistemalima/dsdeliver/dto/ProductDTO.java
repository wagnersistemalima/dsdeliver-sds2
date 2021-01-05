package com.sistemalima.dsdeliver.dto;

import java.io.Serializable;

import com.sistemalima.dsdeliver.entities.Product;

// Objeto para carregar os dados

public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	
	// construtor default
	
	public ProductDTO() {
		
	}
	
	// construtor com argumentos

	public ProductDTO(Long id, String name, Double price, String description, String imageUri) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imageUri;
	}
	
	// construtor personalizado recebendo uma entidade para povoar o dto
	
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.description = entity.getDescription();
		this.imageUri = entity.getImageUri();
	}
	
	// getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	

}
