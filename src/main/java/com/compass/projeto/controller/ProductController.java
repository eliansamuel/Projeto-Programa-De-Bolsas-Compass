package com.compass.projeto.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.projeto.controller.service.ProductService;
import com.compass.projeto.dto.FindProductDto;
import com.compass.projeto.dto.ProductDto;
import com.compass.projeto.form.ProductForm;
import com.compass.projeto.form.UpdateProductForm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
@Api(value = "Controller de produtos")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "Retorna uma lista de produtos")
	@GetMapping
	public List<ProductDto> list(){
			return productService.list();	
	}
	
	@ApiOperation(value = "Retorna uma lista com filtros de preços máximos e mínimos")
	@GetMapping("/search")
	public List<ProductDto> search(@RequestParam(required = false) Double maxPricedb, @RequestParam(required = false) Double minPricedb, @RequestParam(required = false) String q){
		return productService.search(maxPricedb, minPricedb, q);
  	}
	
	@ApiOperation(value = "Cria um novo produto")
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> registerProduct(@RequestBody @Valid ProductForm productForm, UriComponentsBuilder uriBuilder){
		return productService.registerProduct(productForm, uriBuilder);
	}
	
	@ApiOperation(value = "Busca um produto por seu id")
	@GetMapping("/{id}")
	public ResponseEntity<FindProductDto> searchById(@PathVariable Integer id){
		return productService.searchById(id);
	}
	
	@ApiOperation(value = "Atualiza um produto por seu id")
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody @Valid UpdateProductForm productForm){
		return productService.updateProduct(id, productForm);
	}
	
	@ApiOperation(value = "Remove um produto por seu id")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		return productService.deleteProduct(id);
	}
}
