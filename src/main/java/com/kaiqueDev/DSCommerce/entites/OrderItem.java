package com.kaiqueDev.DSCommerce.entites;

import java.io.Serializable;

import com.kaiqueDev.DSCommerce.entites.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK pk = new OrderItemPK();
	private Integer quantity;
	private Double price;

	public OrderItem(Product product, Order order, Integer quantity, Double price) {
		this.pk.setOrder(order);
		this.pk.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Order getOrder() {
		return pk.getOrder();
	}

	public Product getProduct() {
		return pk.getProduct();
	}

	public void setOrder(Order order) {
		pk.setOrder(order);
	}

	public void setOrderProduct(Product product) {
		pk.setProduct(product);
	}
}
