package com.kaiqueDev.DSCommerce.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoRequest {

	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	//private Set<CategorieDtoRef> categories;

}
