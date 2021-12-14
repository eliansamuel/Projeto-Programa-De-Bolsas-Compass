package com.compass.projeto.controller.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.projeto.dto.FindProductDto;
import com.compass.projeto.dto.ProductDto;
import com.compass.projeto.form.ProductForm;
import com.compass.projeto.form.UpdateProductForm;
import com.compass.projeto.model.Product;
import com.compass.projeto.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductDto> list(){
		List<Product> product = productRepository.findAll();
			return ProductDto.convertToList(product);	
	}
	
	public List<ProductDto> search(@RequestParam(required = false) Double maxPricedb, @RequestParam(required = false) Double minPricedb, @RequestParam(required = false) String q){
		List<Product> product = productRepository.findByPrice(maxPricedb, minPricedb, q);
		return ProductDto.convertToList(product);
  	}
	
	public ResponseEntity<ProductDto> registerProduct(@RequestBody @Valid ProductForm productForm, UriComponentsBuilder uriBuilder){
		Product	product = productForm.convert();
		productRepository.save(product);
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
	}
	
	public ResponseEntity<FindProductDto> searchById(@PathVariable Integer id){
		Optional<Product> product = productRepository.findById(id);
			return new ResponseEntity<FindProductDto>(new FindProductDto(product.get()), HttpStatus.OK);
	}
	
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody @Valid UpdateProductForm productForm){
		Product product = productForm.update(id, productRepository);
		return ResponseEntity.ok(new ProductDto(product));
	}
	
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		productRepository.deleteById(id);		
		return ResponseEntity.ok().build();
	}

}
