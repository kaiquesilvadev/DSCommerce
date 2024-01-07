package com.kaiqueDev.DSCommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaiqueDev.DSCommerce.domain.dto.converso.ProductDtoConverso;
import com.kaiqueDev.DSCommerce.domain.dto.request.ProductDtoRequest;
import com.kaiqueDev.DSCommerce.domain.dto.responce.ProductDtoResponce;
import com.kaiqueDev.DSCommerce.domain.entites.Product;
import com.kaiqueDev.DSCommerce.domain.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductControlle {

	@Autowired
	private ProductService service;

	@Autowired
	private ProductDtoConverso converso;

	@GetMapping
	public Page<ProductDtoResponce> lista(@RequestParam(name = "name" , defaultValue = "") 
	String nome , Pageable pageable) {
		Page<Product> pageProduct = service.lista(nome, pageable);
		List<ProductDtoResponce> Product = converso.ListDto(pageProduct.getContent());
		return new PageImpl<>(Product, pageable, pageProduct.getTotalElements());
	}

	@GetMapping("/{id}")
	public ProductDtoResponce duscaPorId(@PathVariable Long id) {
		return converso.convertiEntiti(service.buscaPorId(id));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ProductDtoResponce adicionar(@Valid @RequestBody ProductDtoRequest dtoRequest) {
		return converso.convertiEntiti(service.adicionar(dtoRequest));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	public ProductDtoResponce adicionar(@Valid @RequestBody ProductDtoRequest dtoRequest , @PathVariable Long id) {
		return converso.convertiEntiti(service.atualizar(dtoRequest,id));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
