package com.kaiqueDev.DSCommerce.domain.Repositoris;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaiqueDev.DSCommerce.domain.entites.Product;

public interface ProductRepository extends  JpaRepository<Product, Long>{

}
