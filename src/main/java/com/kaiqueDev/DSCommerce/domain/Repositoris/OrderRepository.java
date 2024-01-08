package com.kaiqueDev.DSCommerce.domain.Repositoris;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaiqueDev.DSCommerce.domain.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o JOIN FETCH o.items WHERE o.id = :id")
	Optional<Order> findById(Long id);
}
