package com.kaiqueDev.DSCommerce.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDtoRequest {

	@NotNull
	private Long productId;
	
	@NotNull
	@Positive
	private Integer  quantity;
}
