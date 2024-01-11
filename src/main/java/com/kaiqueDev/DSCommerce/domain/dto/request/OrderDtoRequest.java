package com.kaiqueDev.DSCommerce.domain.dto.request;

import java.time.Instant;
import java.util.List;

import com.kaiqueDev.DSCommerce.domain.dto.responce.PaymentDtoResponce;
import com.kaiqueDev.DSCommerce.domain.dto.responce.UseMinDtoResponce;
import com.kaiqueDev.DSCommerce.domain.enuns.OrderStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDtoRequest {

	private Instant moment;
	private OrderStatus status;
	private UseMinDtoResponce client;
	private PaymentDtoResponce payment;
	
	@Valid
	@Size(min = 1)
	private List<OrderItemDtoRequest> items;

	
}
