package com.kaiqueDev.DSCommerce.domain.dto.responce;

import java.util.HashSet;
import java.util.Set;

import com.kaiqueDev.DSCommerce.domain.dto.referencias.CategorieDtoRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoResponce {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	Set<CategorieDtoRef> categories = new HashSet<>();
}
