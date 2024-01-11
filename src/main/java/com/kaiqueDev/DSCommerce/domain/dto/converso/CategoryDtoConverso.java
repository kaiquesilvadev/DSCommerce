package com.kaiqueDev.DSCommerce.domain.dto.converso;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaiqueDev.DSCommerce.domain.dto.request.ProductDtoRequest;
import com.kaiqueDev.DSCommerce.domain.dto.responce.CategoryDtoResponce;
import com.kaiqueDev.DSCommerce.domain.dto.responce.ProductDtoResponce;
import com.kaiqueDev.DSCommerce.domain.dto.responce.ProductMinDtoResponce;
import com.kaiqueDev.DSCommerce.domain.entites.Category;
import com.kaiqueDev.DSCommerce.domain.entites.Product;

@Component
public class CategoryDtoConverso {

	@Autowired
	private ModelMapper mapper;
	
	public CategoryDtoResponce convertiEntiti(Category category) {
		return mapper.map(category, CategoryDtoResponce.class);
	}
	
	public List<CategoryDtoResponce> ListDto(List<Category> list) {
		return list.stream().map(c -> convertiEntiti(c)).toList();
	}
	
	
}
