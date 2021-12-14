package com.compass.projeto.controller.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.projeto.dto.FindProductDto;
import com.compass.projeto.dto.ProductDto;
import com.compass.projeto.form.ProductForm;
import com.compass.projeto.form.UpdateProductForm;

public interface ProductServiceInterface {
	
	List<ProductDto> list();
	
	List<ProductDto> search(@RequestParam(required = false) Double maxPricedb, @RequestParam(required = false) Double minPricedb, @RequestParam(required = false) String q);

	ResponseEntity<ProductDto> registerProduct(@RequestBody @Valid ProductForm productForm, UriComponentsBuilder uriBuilder);
	
	ResponseEntity<FindProductDto> searchById(@PathVariable Integer id);
	
	ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody @Valid UpdateProductForm productForm);
	
	ResponseEntity<?> deleteProduct(@PathVariable Integer id);
}
