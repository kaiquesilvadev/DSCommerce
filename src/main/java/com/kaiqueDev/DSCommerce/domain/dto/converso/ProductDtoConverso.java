package com.kaiqueDev.DSCommerce.domain.dto.converso;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaiqueDev.DSCommerce.domain.dto.request.ProductDtoRequest;
import com.kaiqueDev.DSCommerce.domain.dto.responce.ProductDtoResponce;
import com.kaiqueDev.DSCommerce.domain.dto.responce.ProductMinDtoResponce;
import com.kaiqueDev.DSCommerce.domain.entites.Category;
import com.kaiqueDev.DSCommerce.domain.entites.Product;

@Component
public class ProductDtoConverso {

	@Autowired
	private ModelMapper mapper;
	
	public ProductDtoResponce convertiEntiti(Product product) {
		return mapper.map(product, ProductDtoResponce.class);
	}
	
	public ProductMinDtoResponce convertiMin(Product product) {
		return mapper.map(product, ProductMinDtoResponce.class);
	}
	
	public Product convertiDto(ProductDtoRequest productDto) {
		return mapper.map(productDto, Product.class);
	}
	
	@SuppressWarnings("unchecked")
	public void atualiza(ProductDtoRequest productDto, Product product) {
		 // Limpar as categorias existentes e adicionar as novas categorias
	    product.getCategories().clear();
	    product.getCategories().addAll(productDto.getCategories().stream()
	            .map(categoryId -> new Category(categoryId))
	            .collect(Collectors.toSet()));

	    // Mapear os outros atributos do DTO para a entidade Product
		mapper.map(productDto, product);
	}
	
	public List<ProductMinDtoResponce> ListDto(List<Product> list) {
		return list.stream().map(Product -> convertiMin(Product)).toList();
	}
	
	
}
