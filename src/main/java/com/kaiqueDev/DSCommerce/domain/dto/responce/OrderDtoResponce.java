package com.kaiqueDev.DSCommerce.domain.dto.responce;

import java.time.Instant;
import java.util.List;

import com.kaiqueDev.DSCommerce.domain.enuns.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDtoResponce {

	private Instant moment;
	private OrderStatus status;
	private UseMinDtoResponce client;
	private PaymentDtoResponce payment;
	private List<OrderItemDtoResponce> items;

	public Double getTotal() {
		return items.stream()
	            .mapToDouble(OrderItemDtoResponce::getSubTotal)
	            .reduce(0.0, Double::sum);
 	}
}
