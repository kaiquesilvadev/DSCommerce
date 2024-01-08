package com.kaiqueDev.DSCommerce.domain.dto.converso;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaiqueDev.DSCommerce.domain.dto.responce.OrderDtoResponce;
import com.kaiqueDev.DSCommerce.domain.entites.Order;

@Component
public class OrderDtoConverso {

	@Autowired
	private ModelMapper mapper;
	
	public OrderDtoResponce convertiEntiti(Order order) {
		return mapper.map(order, OrderDtoResponce.class);
	}
}
