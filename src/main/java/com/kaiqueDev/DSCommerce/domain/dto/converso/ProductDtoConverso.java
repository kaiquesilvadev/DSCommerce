package com.kaiqueDev.DSCommerce.domain.dto.converso;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaiqueDev.DSCommerce.domain.dto.request.ProductDtoRequest;
import com.kaiqueDev.DSCommerce.domain.dto.responce.ProductDtoResponce;
import com.kaiqueDev.DSCommerce.domain.entites.Product;

@Component
public class ProductDtoConverso {

	@Autowired
	private ModelMapper mapper;
	
	public ProductDtoResponce convertiEntiti(Product product) {
		return mapper.map(product, ProductDtoResponce.class);
	}
	
	public Product convertiDto(ProductDtoRequest productDto) {
		return mapper.map(productDto, Product.class);
	}
	
	public void atualiza(ProductDtoRequest productDto, Product product) {
		mapper.map(productDto, product);
	}
	
	public List<ProductDtoResponce> ListDto(List<Product> list) {
		return list.stream().map(Product -> convertiEntiti(Product)).toList();
	}
	
	
}
