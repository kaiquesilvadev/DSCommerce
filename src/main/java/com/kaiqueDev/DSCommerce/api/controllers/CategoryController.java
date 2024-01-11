package com.kaiqueDev.DSCommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaiqueDev.DSCommerce.domain.dto.converso.CategoryDtoConverso;
import com.kaiqueDev.DSCommerce.domain.dto.responce.CategoryDtoResponce;
import com.kaiqueDev.DSCommerce.domain.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@Autowired
	private CategoryDtoConverso converso;

	
	@GetMapping
	public List<CategoryDtoResponce> lista() {
		return converso.ListDto(service.lista());
	}

}
