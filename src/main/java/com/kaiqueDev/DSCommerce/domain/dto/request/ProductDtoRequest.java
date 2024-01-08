package com.kaiqueDev.DSCommerce.domain.dto.request;

import java.util.Set;

import com.kaiqueDev.DSCommerce.domain.dto.referencias.CategorieDtoRef;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@NonNull
	@Positive
	private Double price;

	@NotBlank
	private String imgUrl;
	
	@Size(min = 1)
	private Set<CategorieDtoRef> categories;

}
