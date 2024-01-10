package com.kaiqueDev.DSCommerce.domain.Repositoris;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaiqueDev.DSCommerce.domain.entites.OrderItem;
import com.kaiqueDev.DSCommerce.domain.entites.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
