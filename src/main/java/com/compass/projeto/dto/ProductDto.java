package com.compass.projeto.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.compass.projeto.model.Product;

import io.swagger.annotations.ApiModelProperty;

public class ProductDto {
	
	@ApiModelProperty(value = "Descrição do produto")
	private String description;
	@ApiModelProperty(value = "Id do produto")
	private Integer id;
	@ApiModelProperty(value = "Nome do produto")
	private String name;
	@ApiModelProperty(value = "Preço do produto")
	private double price;
	
	public ProductDto(Product product) {
		this.description = product.getDescription();
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public static List<ProductDto> convertToList(List<Product> products) {
		return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	public static Page<ProductDto> convertToPage(Page<Product> products){
		return products.map(ProductDto::new);
	}
}
