package com.kaiqueDev.DSCommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaiqueDev.DSCommerce.domain.entites.Product;
import com.kaiqueDev.DSCommerce.domain.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductControlle {

	@Autowired
	private ProductService service;

	@GetMapping
	public List<Product> lista() {
		return service.lista();
	}

	@GetMapping("/{id}")
	public Product duscaPorId(@PathVariable Long id) {
		return service.buscaPorId(id);
	}
}
