package com.compass.projeto.dto;

import com.compass.projeto.model.Product;

import io.swagger.annotations.ApiModelProperty;

public class FindProductDto {
	
	@ApiModelProperty(value = "Descrição do produto")
	private String description;
	@ApiModelProperty(value = "Id do produto")
	private Integer id;
	@ApiModelProperty(value = "Nome do produto")
	private String name;
	@ApiModelProperty(value = "Preço do produto")
	private double price;
	
	public FindProductDto(Product product) {
		this.description = product.getDescription();
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		
	}
	public String getDescription() {
		return description;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
}
