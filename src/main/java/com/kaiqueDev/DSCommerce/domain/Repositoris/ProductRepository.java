package com.kaiqueDev.DSCommerce.domain.Repositoris;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaiqueDev.DSCommerce.domain.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where upper(p.name) like upper(concat('%' , :nome , '%'))")
	Page<Product> lista(String nome, Pageable pageable);
	
	@Query("SELECT p FROM Product p JOIN FETCH p.categories WHERE p.id = :id")
	Optional<Product> buscaPorId(@Param("id") Long id);
}
