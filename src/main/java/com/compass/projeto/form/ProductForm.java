package com.compass.projeto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.compass.projeto.model.Product;

import io.swagger.annotations.ApiModelProperty;

public class ProductForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	@ApiModelProperty(value = "Descrição do produto")
	private String description;
	
	@NotNull @NotEmpty @Length(min = 2)
	@ApiModelProperty(value = "Nome do produto")
	private String name;
	
	@NotNull 
	@ApiModelProperty(value = "Preço do produto")
	private double price;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product convert() {
		return new Product(description, name, price);
	}
	
	
}
