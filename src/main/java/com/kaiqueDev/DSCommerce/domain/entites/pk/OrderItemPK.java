package com.kaiqueDev.DSCommerce.domain.entites.pk;

import com.kaiqueDev.DSCommerce.domain.entites.Order;
import com.kaiqueDev.DSCommerce.domain.entites.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class OrderItemPK {

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

}
