package com.kaiqueDev.DSCommerce.domain.dto.responce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDtoResponce {

	private Long PkProductId;
	private String PkProductName; 
	private Double price;
	private Integer  quantity;
	
	public Double getSubTotal() {
		return price * quantity;
	}
}
