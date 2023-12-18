package com.kaiqueDev.DSCommerce.domain.dto.request;

import java.util.Set;

import com.kaiqueDev.DSCommerce.domain.dto.referencias.CategorieDtoRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoRequest {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	//private Set<CategorieDtoRef> categories;

}
