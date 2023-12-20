package com.kaiqueDev.DSCommerce.domain.dto.request;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
	// private Set<CategorieDtoRef> categories;

}
