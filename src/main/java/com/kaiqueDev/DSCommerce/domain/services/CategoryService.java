package com.kaiqueDev.DSCommerce.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiqueDev.DSCommerce.domain.Repositoris.CategoryRepository;
import com.kaiqueDev.DSCommerce.domain.entites.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> lista() {
		return repository.findAll();
	}
}
