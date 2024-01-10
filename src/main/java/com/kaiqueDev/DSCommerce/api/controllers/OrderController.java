package com.kaiqueDev.DSCommerce.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaiqueDev.DSCommerce.domain.dto.converso.OrderDtoConverso;
import com.kaiqueDev.DSCommerce.domain.dto.request.OrderDtoRequest;
import com.kaiqueDev.DSCommerce.domain.dto.responce.OrderDtoResponce;
import com.kaiqueDev.DSCommerce.domain.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@Autowired
	private OrderDtoConverso converso;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDtoResponce> findById(@PathVariable Long id) {
		return ResponseEntity.ok(converso.convertiEntiti(service.findById(id)));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public OrderDtoResponce adicionar(@Valid @RequestBody OrderDtoRequest dtoRequest) {
		return converso.convertiEntiti(service.adicionar(dtoRequest));
	}

}
